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
package io.nullables.api.playground.objectmappers.beanmapper.converter;

import io.beanmapper.core.converter.SimpleBeanConverter;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;

public class StringToIntegerArrayConverter extends SimpleBeanConverter<String[], Integer[]> {

    /**
     * Construct a new bean converter, manually declaring the source and target class.
     */
    public StringToIntegerArrayConverter() {
        super(String[].class, Integer[].class);
    }

    @Override
    public Integer[] doConvert(final String[] value) {
        return StringUtils.convertToIntegerArray(value);
    }
}
