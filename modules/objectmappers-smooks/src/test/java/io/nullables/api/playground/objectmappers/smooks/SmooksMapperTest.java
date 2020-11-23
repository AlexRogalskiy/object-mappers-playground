package io.nullables.api.playground.objectmappers.smooks;

import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.ArrayUtils;
import io.nullables.api.playground.objectmappers.smooks.configuration.SmooksMapperBuilder;
import io.nullables.api.playground.objectmappers.testflow.annotation.SimpleTest;
import io.nullables.api.playground.objectmappers.testflow.annotation.VariableSource;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.payload.JavaResult;
import org.milyn.payload.JavaSource;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.nullables.api.playground.objectmappers.testflow.utils.ModelMockTestUtils.deliveryDtoMock;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

@SimpleTest
class SmooksMapperTest {

    public static final Stream<Arguments> deliveryDtoValues =
        IntStream.iterate(0, n -> n + 1).limit(ThreadLocalRandom.current().nextInt(1, 10))
            .mapToObj(v -> deliveryDtoMock().val()).map(Arguments::of);

    private Smooks mapper;

    @BeforeEach
    void setUp() {
        this.mapper = SmooksMapperBuilder.newBuilder()
            .withConfiguration("mappings/smooks-config.xml")
            .build();
    }

    private DeliveryEntity getTarget(@Nonnull final DeliveryDto source) throws IOException {
        final ExecutionContext executionContext = this.mapper.createExecutionContext();
        final JavaSource javaSource = new JavaSource(source);
        javaSource.setEventStreamRequired(false);
        final JavaResult javaResult = new JavaResult();
        executionContext.setEventListener(new HtmlReportGenerator("/report/report.html"));
        this.mapper.filterSource(executionContext, javaSource, javaResult);
        return (DeliveryEntity) javaResult.getBean("deliveryEntity");
    }

    @ParameterizedTest
    @VariableSource("deliveryDtoValues")
    void testCheckDeliveryDtoConversion(@Nonnull final DeliveryDto source) throws IOException {
        // when
        final DeliveryEntity target = this.getTarget(source);

        // then
        assertAll("Should DeliveryDto field values match target DeliveryEntity values", () -> Assertions
                .assertThat(target.getAddresses()).isNotNull()
                .extracting(v -> v.getId().toString(), AddressEntity::getCity, AddressEntity::getCountry,
                    AddressEntity::getPostalCode, AddressEntity::getStateOrProvince,
                    AddressEntity::getStreet)
                .containsExactlyInAnyOrder(source.getAddresses().stream()
                    .map(c -> tuple(c.getId(), c.getCity(), c.getCountry(), c.getPostalCode(),
                        c.getStateOrProvince(), c.getStreet()))
                    .toArray(Tuple[]::new)),
            () -> Assertions.assertThat(target).isNotNull()
                .<String[]>usingComparatorForFields(ArrayUtils::compare, "codes")
                .<String>usingComparatorForFields(StringUtils::compare, "id")
                .<String>usingComparatorForFields(StringUtils::compare, "discount")
                .hasFieldOrPropertyWithValue("type", source.getType())
                .hasFieldOrPropertyWithValue("description", source.getDescription())
                .hasFieldOrPropertyWithValue("gid", source.getGid())
                .hasFieldOrPropertyWithValue("createdAt", source.getCreatedAt())
                .hasFieldOrPropertyWithValue("updatedAt", source.getUpdatedAt())
                .hasFieldOrPropertyWithValue("balance", source.getBalance())
                .hasFieldOrPropertyWithValue("status", source.getStatus()));
    }
}
