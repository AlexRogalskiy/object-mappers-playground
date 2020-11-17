package io.nullables.api.playground.objectmappers.orika.converter;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_FORMATTER;

public class StringToLocalDateTimeConverter extends BidirectionalConverter<String, LocalDateTime> {

    @Override
    public LocalDateTime convertTo(final String source,
                                   final Type<LocalDateTime> destinationType,
                                   final MappingContext mappingContext) {
        return LocalDateTime.parse(source, DATETIME_FORMATTER);
    }

    @Override
    public String convertFrom(final LocalDateTime source,
                              final Type<String> destinationType,
                              final MappingContext mappingContext) {
        return DATETIME_FORMATTER.format(source);
    }
}
