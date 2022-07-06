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

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToString;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class IdToUuidCustomMapper extends CustomMapper<AddressDto, AddressEntity> {

	@Override
	public void mapAtoB(final AddressDto a, final AddressEntity b, final MappingContext context) {
		b.setId(convertToUuid(a.getId()));
	}

	@Override
	public void mapBtoA(final AddressEntity b, final AddressDto a, final MappingContext context) {
		a.setId(convertToString(b.getId()));
	}

}
