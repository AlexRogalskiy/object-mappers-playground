package io.nullables.api.playground.objectmappers.beanmapper;

import io.beanmapper.BeanMapper;
import io.beanmapper.core.collections.ListCollectionHandler;
import io.beanmapper.core.converter.impl.StringToBigDecimalConverter;
import io.nullables.api.playground.objectmappers.beanmapper.configuration.BeanMapperConfigBuilder;
import io.nullables.api.playground.objectmappers.beanmapper.converter.StringToIntegerArrayConverter;
import io.nullables.api.playground.objectmappers.beanmapper.converter.StringToLocalDateTimeConverter;
import io.nullables.api.playground.objectmappers.beanmapper.converter.StringToUuidConverter;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.ArrayUtils;
import io.nullables.api.playground.objectmappers.testflow.annotation.SimpleTest;
import io.nullables.api.playground.objectmappers.testflow.annotation.VariableSource;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.nullables.api.playground.objectmappers.testflow.utils.ModelMockTestUtils.deliveryDtoMock;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

@SimpleTest
class BeanMapperTest {

    public static final Stream<Arguments> deliveryDtoValues =
        IntStream.iterate(0, n -> n + 1).limit(ThreadLocalRandom.current().nextInt(1, 10))
            .mapToObj(v -> deliveryDtoMock().val()).map(Arguments::of);

    private BeanMapper deliveryMapper;
    private BeanMapper addressMapper;

    @BeforeEach
    void before() {
        this.deliveryMapper = BeanMapperConfigBuilder.newBuilder()
            .withConverter(new StringToUuidConverter())
            .withConverter(new StringToBigDecimalConverter())
            .withConverter(new StringToIntegerArrayConverter())
            .withConverter(new StringToLocalDateTimeConverter())
            .withCollectionHandler(new ListCollectionHandler())
            .build();
        this.addressMapper = BeanMapperConfigBuilder.newBuilder()
            .withConverter(new StringToUuidConverter())
            .build();
    }

    @ParameterizedTest
    @VariableSource("deliveryDtoValues")
    void testCheckDeliveryDtoConversion(@Nonnull final DeliveryDto source) {
        // when
        final DeliveryEntity target = this.deliveryMapper.map(source, DeliveryEntity.class);
        target.setAddresses(this.addressMapper.map(source.getAddresses(), AddressEntity.class));

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
