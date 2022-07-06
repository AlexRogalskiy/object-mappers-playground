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
package io.nullables.api.playground.objectmappers.dozer.converter;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToIntegerArray;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToStringArray;

import org.apache.commons.lang3.ArrayUtils;

import com.github.dozermapper.core.DozerConverter;

public class StringToIntegerArrayConvertor extends DozerConverter<String[], Integer[]> {

	public StringToIntegerArrayConvertor() {
		super(String[].class, Integer[].class);
	}

	@Override
	public Integer[] convertTo(final String[] strings, final Integer[] integers) {
		if (ArrayUtils.isEmpty(strings) && this.getParameter().equals("NULL_IF_EMPTY")) {
			return null;
		}
		return convertToIntegerArray(strings);
	}

	@Override
	public String[] convertFrom(final Integer[] integers, final String[] strings) {
		return convertToStringArray(integers);
	}

}
