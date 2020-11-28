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
package io.nullables.api.playground.objectmappers.mapstruct.mapping;

import org.mapstruct.Named;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.*;

public class BaseMappings {

    @Named("IdTranslator")
    public static class IdMappings {

        @Named("IdToUuid")
        public UUID convertIdToUuid(final String id) {
            return convertToUuid(id);
        }

        @Named("UuidToId")
        public String convertUuidToId(final UUID uuid) {
            return convertToString(uuid);
        }
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Decode {
    }

    @Code
    public Integer[] code(final String[] value) {
        return convertToIntegerArray(value);
    }

    @Decode
    public String[] decode(final Integer[] value) {
        return convertToStringArray(value);
    }
}
