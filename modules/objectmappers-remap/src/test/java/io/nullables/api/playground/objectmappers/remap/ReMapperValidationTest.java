package io.nullables.api.playground.objectmappers.remap;

import com.remondis.remap.AssertMapping;
import com.remondis.remap.Mapper;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;
import io.nullables.api.playground.objectmappers.remap.configuration.ReMapConfiguration;
import io.nullables.api.playground.objectmappers.testflow.annotation.SimpleTest;
import org.junit.jupiter.api.Test;

@SimpleTest
class ReMapperValidationTest {

    @Test
    void checkDeliveryDtoToDeliveryEntityMappingProperties_shouldBeValid() {
        // given
        final Mapper<DeliveryDto, DeliveryEntity> mapper = new ReMapConfiguration().deliveryMapper();

        // then
        AssertMapping.of(mapper)
            .expectReplace(DeliveryDto::getCodes, DeliveryEntity::getCodes)
            .andTest(StringUtils::convertToIntegerArray)
            .expectReplace(DeliveryDto::getId, DeliveryEntity::getId)
            .andTest(StringUtils::convertToUuid)
            .expectReplace(DeliveryDto::getShippableDue, DeliveryEntity::getShippableDue)
            .andTest(DateUtils::convertToLocalDateTime)
//            .expectReplace(DeliveryDto::getDiscount, DeliveryEntity::getDiscount)
//            .andTest(BigDecimal::new)
            .expectReplace(DeliveryDto::getDiscount, DeliveryEntity::getDiscount)
            .andSkipWhenNull()
            .ensure();
    }

    @Test
    void checkAddressDtoToAddressEntityMappingProperties_shouldBeValid() {
        // given
        final Mapper<AddressDto, AddressEntity> mapper = new ReMapConfiguration().addressMapper();

        // then
        AssertMapping.of(mapper)
            .expectReplace(AddressDto::getId, AddressEntity::getId)
            .andTest(StringUtils::convertToUuid)
            .expectReplace(AddressDto::getCity, AddressEntity::getCity)
            .andTest(StringUtils::notEmptyOrNull)
            .expectReplace(AddressDto::getCountry, AddressEntity::getCountry)
            .andTest(StringUtils::notEmptyOrNull)
            .ensure();
    }
}
