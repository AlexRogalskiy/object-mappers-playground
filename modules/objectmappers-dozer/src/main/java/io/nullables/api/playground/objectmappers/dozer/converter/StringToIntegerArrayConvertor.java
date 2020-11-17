package io.nullables.api.playground.objectmappers.dozer.converter;

import com.github.dozermapper.core.DozerConverter;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToIntegerArray;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToStringArray;

public class StringToIntegerArrayConvertor extends DozerConverter<String[], Integer[]> {

    public StringToIntegerArrayConvertor() {
        super(String[].class, Integer[].class);
    }

    @Override
    public Integer[] convertTo(final String[] strings, final Integer[] integers) {
        return convertToIntegerArray(strings);
    }

    @Override
    public String[] convertFrom(final Integer[] integers, final String[] strings) {
        return convertToStringArray(integers);
    }
}
