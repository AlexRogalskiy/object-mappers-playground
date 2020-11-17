package io.nullables.api.playground.objectmappers.modelmapper.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToIntegerArray;

/**
 * {@link String} to {@link Integer} array {@link Converter} implementation
 */
public class StringToIntegerArrayConverter implements Converter<String[], Integer[]> {
    /**
     * Returns converted array of {@link Integer}s from input {@link String} array by {@link MappingContext}
     *
     * @param context - initial input {@link MappingContext} to operate by
     * @return converted array of {@link Integer}s
     */
    @Override
    public Integer[] convert(final MappingContext<String[], Integer[]> context) {
        return convertToIntegerArray(context.getSource());
    }
}
