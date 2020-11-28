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

import com.github.dozermapper.core.DozerConverter;

public class StringToBooleanConverter extends DozerConverter<String, Boolean> {

    public StringToBooleanConverter() {
        super(String.class, Boolean.class);
    }

    public Boolean convertTo(final String source, final Boolean destination) {
        if ("yes".equals(source)) {
            return Boolean.TRUE;
        } else if ("no".equals(source)) {
            return Boolean.FALSE;
        }
        throw new IllegalStateException("Unknown value!");
    }

    public String convertFrom(final Boolean source, final String destination) {
        if (Boolean.TRUE.equals(source)) {
            return "yes";
        } else if (Boolean.FALSE.equals(source)) {
            return "no";
        }
        throw new IllegalStateException("Unknown value!");
    }
}
