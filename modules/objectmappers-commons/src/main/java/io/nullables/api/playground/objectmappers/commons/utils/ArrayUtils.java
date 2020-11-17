package io.nullables.api.playground.objectmappers.commons.utils;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class ArrayUtils {

    public <T extends Comparable<? super T>> int compare(final T[] a, final T[] b) {
        final int i = Arrays.mismatch(a, b);
        if (i >= 0 && i < Math.min(a.length, b.length)) {
            return a[i].compareTo(b[i]);
        }
        return a.length - b.length;
    }
}
