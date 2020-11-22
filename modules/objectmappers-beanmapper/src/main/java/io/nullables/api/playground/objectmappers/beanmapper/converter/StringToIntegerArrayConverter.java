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
