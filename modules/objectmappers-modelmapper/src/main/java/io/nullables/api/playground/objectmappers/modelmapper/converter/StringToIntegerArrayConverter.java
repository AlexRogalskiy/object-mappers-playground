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

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToIntegerArray;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

/**
 * {@link String} to {@link Integer} array {@link Converter} implementation
 */
public class StringToIntegerArrayConverter implements Converter<String[], Integer[]> {
    /**
     * Returns converted array of {@link Integer}s from input {@link String} array by {@link MappingContext}
     *
     * @param context - initial input {@link MappingContext} to operate by
     * @return converted array of {@link Integer}s
     */
    @Override
    public Integer[] convert(final MappingContext<String[], Integer[]> context) {
        return convertToIntegerArray(context.getSource());
    }
}
