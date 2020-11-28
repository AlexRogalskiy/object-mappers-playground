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

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDateTime;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime;

/**
 * {@link String} to {@link LocalDateTime} array {@link Converter} implementation
 */
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    /**
     * Returns converted {@link LocalDateTime} from input {@link String} by {@link MappingContext}
     *
     * @param context - initial input {@link MappingContext} to operate by
     * @return converted {@link LocalDateTime}
     */
    @Override
    public LocalDateTime convert(final MappingContext<String, LocalDateTime> context) {
        return convertToLocalDateTime(context.getSource());
    }
}
