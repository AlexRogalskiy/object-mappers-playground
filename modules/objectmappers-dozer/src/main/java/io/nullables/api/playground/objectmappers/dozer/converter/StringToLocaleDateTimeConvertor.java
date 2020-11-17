package io.nullables.api.playground.objectmappers.dozer.converter;

import com.github.dozermapper.core.DozerConverter;

import java.time.LocalDateTime;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_FORMATTER;

public class StringToLocaleDateTimeConvertor extends DozerConverter<String, LocalDateTime> {

    public StringToLocaleDateTimeConvertor() {
        super(String.class, LocalDateTime.class);
    }

    @Override
    public LocalDateTime convertTo(final String s, final LocalDateTime uuid) {
        return LocalDateTime.parse(s, DATETIME_FORMATTER);
    }

    @Override
    public String convertFrom(final LocalDateTime localDateTime, final String s) {
        return DATETIME_FORMATTER.format(localDateTime);
    }
}
