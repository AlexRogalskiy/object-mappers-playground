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

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayUtils {

    public <T extends Comparable<? super T>> int compare(final T[] a, final T[] b) {
        final int i = mismatch(a, b);
        if (i >= 0 && i < Math.min(a.length, b.length)) {
            return a[i].compareTo(b[i]);
        }
        return a.length - b.length;
    }

    private static <T> int mismatch(final T[] a, final T[] b) {
        final int length = Math.min(a.length, b.length);
        if (a == b) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (!Objects.equals(a[i], b[i])) {
                return i;
            }
        }

        return a.length != b.length ? length : -1;
    }

    @Nonnull
    public static <E> List<String> transformUnique(final E[] values,
                                                   final Function<E, String> mapper) {
        return Stream.of(values).map(mapper).distinct().collect(Collectors.toList());
    }
}
