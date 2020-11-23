package io.nullables.api.playground.objectmappers.beanutils;

import io.nullables.api.playground.objectmappers.beanutils.configuration.BeanUtilsMapper;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
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
import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToIntegerArray;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;
import static io.nullables.api.playground.objectmappers.testflow.utils.ModelMockTestUtils.deliveryDtoMock;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

@SimpleTest
class BeanUtilsMapperTest {

    public static final Stream<Arguments> deliveryDtoValues =
        IntStream.iterate(0, n -> n + 1).limit(ThreadLocalRandom.current().nextInt(1, 10))
            .mapToObj(v -> deliveryDtoMock().val()).map(Arguments::of);

    private BeanUtilsMapper<AddressDto, AddressEntity> addressMapper;
    private BeanUtilsMapper<DeliveryDto, DeliveryEntity> deliveryMapper;

    @BeforeEach
    void before() {
        this.addressMapper = BeanUtilsMapper.<AddressDto, AddressEntity>newBuilder(AddressEntity.class)
            .map("id", source -> convertToUuid(source.getId()))
            .map("city", AddressDto::getCity)
            .map("country", AddressDto::getCountry)
            .map("stateOrProvince", AddressDto::getStateOrProvince)
            .map("postalCode", AddressDto::getPostalCode)
            .map("street", AddressDto::getStreet)
            .build();

        this.deliveryMapper = BeanUtilsMapper.<DeliveryDto, DeliveryEntity>newBuilder(DeliveryEntity.class)
            .map("id", source -> convertToUuid(source.getId()))
            .map("type", DeliveryDto::getType)
            .map("description", DeliveryDto::getDescription)
            .map("gid", DeliveryDto::getGid)
            .map("createdAt", DeliveryDto::getCreatedAt)
            .map("updatedAt", DeliveryDto::getUpdatedAt)
            .map("shippableDue", source -> convertToLocalDateTime(source.getShippableDue()))
            .map("balance", DeliveryDto::getBalance)
            .map("discount", source -> new BigDecimal(source.getDiscount()))
            .map("status", DeliveryDto::getStatus)
            .map("addresses", source -> source.getAddresses().stream().map(this.addressMapper::map).collect(Collectors.toList()))
            .map("codes", source -> convertToIntegerArray(source.getCodes()))
            .build();
    }

    @ParameterizedTest
    @VariableSource("deliveryDtoValues")
    void testCheckDeliveryDtoConversion(@Nonnull final DeliveryDto source) {
        // when
        final DeliveryEntity target = this.deliveryMapper.map(source);

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
