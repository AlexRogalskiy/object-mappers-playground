package io.nullables.api.playground.objectmappers.selma.mapping;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToIntegerArray;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToStringArray;

public class StringToIntegerArrayMapper {

    public Integer[] stringToIntegerArray(final String[] value) {
        return convertToIntegerArray(value);
    }

    public String[] integerToStringArray(final Integer[] value) {
        return convertToStringArray(value);
    }
}
