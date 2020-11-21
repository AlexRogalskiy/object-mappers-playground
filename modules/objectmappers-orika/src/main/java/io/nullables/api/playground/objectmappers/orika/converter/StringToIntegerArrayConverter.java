package io.nullables.api.playground.objectmappers.orika.converter;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToIntegerArray;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToStringArray;

public class StringToIntegerArrayConverter extends BidirectionalConverter<String[], Integer[]> {

    @Override
    public Integer[] convertTo(final String[] source, final Type<Integer[]> destinationType,
                    final MappingContext mappingContext) {
        return convertToIntegerArray(source);
    }

    @Override
    public String[] convertFrom(final Integer[] source, final Type<String[]> destinationType,
                    final MappingContext mappingContext) {
        return convertToStringArray(source);
    }
}
