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

import static fr.xebia.extras.selma.CollectionMappingStrategy.ALLOW_GETTER;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;

@Mapper(
    withIgnoreMissing = IgnoreMissing.ALL,
    withCollectionStrategy = ALLOW_GETTER,
    withCustomFields = {
        @Field(value = {"id", "id"}, withCustom = StringToUuidMapper.class),
        @Field({"type", "type"}),
        @Field({"description", "description"}),
        @Field({"gid", "gid"}),
        @Field({"createdAt", "createdAt"}),
        @Field({"updatedAt", "updatedAt"}),
        @Field(value = {"shippableDue", "shippableDue"}, withCustom = StringToLocalDateTimeMapper.class),
        @Field({"balance", "balance"}),
        @Field(value = {"discount", "discount"}, withCustom = StringToBigDecimalMapper.class),
        @Field({"status", "status"}),
        @Field({"addresses", "addresses"}),
        @Field(value = {"codes", "codes"}, withCustom = StringToIntegerArrayMapper.class)
    }
)
public interface DeliveryMapper {
    /**
     * Returns converted {@link DeliveryEntity} by input {@link DeliveryDto}
     *
     * @param in initial input {@link DeliveryDto} to convert from
     * @return converted {@link DeliveryEntity}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    DeliveryEntity toDeliveryEntity(final DeliveryDto in);

    /**
     * Returns converted {@link DeliveryDto} by input {@link DeliveryEntity} and {@link DeliveryDto}
     *
     * @param in initial input {@link DeliveryEntity} to convert from
     * @return converted {@link DeliveryDto}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    DeliveryDto toDeliveryDto(final DeliveryEntity in);
}
