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
package io.nullables.api.playground.objectmappers.modelmapper.converter;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;

import java.util.UUID;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import lombok.extern.slf4j.Slf4j;

/**
 * {@link String} to {@link UUID} {@link Converter} implementation
 */
@Slf4j
public class StringToUuidConverter implements Converter<String, UUID> {

	/**
	 * Returns converted {@link UUID} from {@link String} by input {@link MappingContext}
	 * @param context - initial input {@link MappingContext} to operate by
	 * @return converted {@link UUID}
	 */
	@Override
	public UUID convert(final MappingContext<String, UUID> context) {
		try {
			return convertToUuid(context.getSource());
		}
		catch (RuntimeException ex) {
			log.error("Cannot convert input source: {} to UUID format", context.getSource(), ex);
			return null;
		}
	}

}
