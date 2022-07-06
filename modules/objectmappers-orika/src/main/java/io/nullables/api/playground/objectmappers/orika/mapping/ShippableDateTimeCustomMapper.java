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
package io.nullables.api.playground.objectmappers.orika.mapping;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime;
import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToString;

import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class ShippableDateTimeCustomMapper extends CustomMapper<DeliveryDto, DeliveryEntity> {

	@Override
	public void mapAtoB(final DeliveryDto a, final DeliveryEntity b, final MappingContext context) {
		b.setShippableDue(convertToLocalDateTime(a.getShippableDue()));
	}

	@Override
	public void mapBtoA(final DeliveryEntity b, final DeliveryDto a, final MappingContext context) {
		a.setShippableDue(convertToString(b.getShippableDue()));
	}

}
