package io.nullables.api.playground.objectmappers.modelmapper.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDateTime;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_FORMATTER;

/**
 * {@link String} to {@link LocalDateTime} array {@link Converter} implementation
 */
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    /**
     * Returns converted {@link LocalDateTime} from input {@link String} by {@link MappingContext}
     *
     * @param context - initial input {@link MappingContext} to operate by
     * @return converted {@link LocalDateTime}
     */
    @Override
    public LocalDateTime convert(final MappingContext<String, LocalDateTime> context) {
        return LocalDateTime.parse(context.getSource(), DATETIME_FORMATTER);
    }
}
