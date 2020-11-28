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
package io.nullables.api.playground.objectmappers.selma.mapping;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;

@Mapper(
    withIgnoreMissing = IgnoreMissing.ALL,
    withCustomFields = {
        @Field(value = {"id", "id"}, withCustom = StringToUuidMapper.class),
        @Field({"city", "city"}),
        @Field({"country", "country"}),
        @Field({"stateOrProvince", "stateOrProvince"}),
        @Field({"street", "street"})
    }
)
public interface AddressMapper {
    /**
     * Returns converted {@link AddressEntity} by input {@link AddressDto}
     *
     * @param in initial input {@link AddressDto} to convert from
     * @return converted {@link AddressEntity}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    AddressEntity toAddressEntity(final AddressDto in);

    /**
     * Returns converted {@link AddressDto} by input {@link AddressEntity} and {@link AddressDto}
     *
     * @param in initial input {@link AddressEntity} to convert from
     * @return converted {@link AddressDto}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    AddressDto toAddressDto(final AddressEntity in);
}
