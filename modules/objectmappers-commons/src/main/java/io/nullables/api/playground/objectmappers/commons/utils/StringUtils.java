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
package io.nullables.api.playground.objectmappers.commons.utils;

import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@UtilityClass
public class StringUtils {

    @Nonnull
    public Integer[] convertToIntegerArray(final String... value) {
        return Optional.ofNullable(value).map(Arrays::stream).orElse(Stream.empty()).map(Integer::valueOf)
                        .toArray(Integer[]::new);
    }

    @Nonnull
    public String[] convertToStringArray(final Integer... value) {
        return Optional.ofNullable(value).map(Arrays::stream).orElse(Stream.empty()).map(String::valueOf)
                        .toArray(String[]::new);
    }

    @Nullable
    public UUID convertToUuid(final String value) {
        return Optional.ofNullable(value).map(UUID::fromString).orElse(null);
    }

    @Nullable
    public String convertToString(final UUID value) {
        return Optional.ofNullable(value).map(UUID::toString).orElse(null);
    }

    @Nullable
    public String notEmptyOrNull(final String value) {
        return Optional.ofNullable(value).filter(org.apache.commons.lang3.StringUtils::isNotEmpty).orElse(null);
    }
}
