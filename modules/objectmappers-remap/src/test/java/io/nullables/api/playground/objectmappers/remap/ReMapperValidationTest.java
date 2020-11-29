/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.remap;

import com.remondis.remap.AssertMapping;
import com.remondis.remap.Mapper;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;
import io.nullables.api.playground.objectmappers.remap.configuration.ReMapperConfiguration;
import io.nullables.api.playground.objectmappers.testflow.annotation.SimpleTest;
import org.junit.jupiter.api.Test;

@SimpleTest
class ReMapperValidationTest {

    @Test
    void checkDeliveryDtoToDeliveryEntityMappingProperties_shouldBeValid() {
        // given
        final Mapper<DeliveryDto, DeliveryEntity> mapper = new ReMapperConfiguration().deliveryMapper();

        // then
        AssertMapping.of(mapper).expectReplace(DeliveryDto::getCodes, DeliveryEntity::getCodes)
                        .andTest(StringUtils::convertToIntegerArray)
                        .expectReplace(DeliveryDto::getId, DeliveryEntity::getId).andTest(StringUtils::convertToUuid)
                        .expectReplace(DeliveryDto::getShippableDue, DeliveryEntity::getShippableDue)
                        .andTest(DateUtils::convertToLocalDateTime)
                        .expectReplace(DeliveryDto::getDiscount, DeliveryEntity::getDiscount).andSkipWhenNull()
                        .ensure();
    }

    @Test
    void checkAddressDtoToAddressEntityMappingProperties_shouldBeValid() {
        // given
        final Mapper<AddressDto, AddressEntity> mapper = new ReMapperConfiguration().addressMapper();

        // then
        AssertMapping.of(mapper).expectReplace(AddressDto::getId, AddressEntity::getId)
                        .andTest(StringUtils::convertToUuid).expectReplace(AddressDto::getCity, AddressEntity::getCity)
                        .andTest(StringUtils::notEmptyOrNull)
                        .expectReplace(AddressDto::getCountry, AddressEntity::getCountry)
                        .andTest(StringUtils::notEmptyOrNull).ensure();
    }
}
