package io.nullables.api.playground.objectmappers.beanmapper.converter;

import io.beanmapper.core.converter.SimpleBeanConverter;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;

import java.util.UUID;

public class StringToUuidConverter extends SimpleBeanConverter<String, UUID> {

    @Override
    public UUID doConvert(final String value) {
        return StringUtils.convertToUuid(value);
    }
}
