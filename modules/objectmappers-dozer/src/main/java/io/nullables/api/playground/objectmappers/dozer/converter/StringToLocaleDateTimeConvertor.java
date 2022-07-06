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

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime;
import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToString;

import java.time.LocalDateTime;

import com.github.dozermapper.core.DozerConverter;

public class StringToLocaleDateTimeConvertor extends DozerConverter<String, LocalDateTime> {

	public StringToLocaleDateTimeConvertor() {
		super(String.class, LocalDateTime.class);
	}

	@Override
	public LocalDateTime convertTo(final String s, final LocalDateTime uuid) {
		return convertToLocalDateTime(s);
	}

	@Override
	public String convertFrom(final LocalDateTime localDateTime, final String s) {
		return convertToString(localDateTime);
	}

}
