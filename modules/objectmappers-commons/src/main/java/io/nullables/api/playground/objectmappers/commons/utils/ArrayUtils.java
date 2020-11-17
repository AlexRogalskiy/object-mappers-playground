package io.nullables.api.playground.objectmappers.commons.utils;

import lombok.experimental.UtilityClass;

import java.util.Objects;

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
}
