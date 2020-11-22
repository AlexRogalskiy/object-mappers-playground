package io.nullables.api.playground.objectmappers.beanmapper.converter;

import io.beanmapper.core.converter.SimpleBeanConverter;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;

import java.time.LocalDateTime;

public class StringToLocalDateTimeConverter extends SimpleBeanConverter<String, LocalDateTime> {

    @Override
    public LocalDateTime doConvert(final String value) {
        return DateUtils.convertToLocalDateTime(value);
    }
}
