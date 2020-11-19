package io.nullables.api.playground.objectmappers.dozer.converter;

import com.github.dozermapper.core.DozerConverter;

import java.time.LocalDateTime;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime;
import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToString;

public class StringToLocaleDateTimeConvertor extends DozerConverter<String, LocalDateTime> {

    public StringToLocaleDateTimeConvertor() {
        super(String.class, LocalDateTime.class);
    }

    @Override
    public LocalDateTime convertTo(final String s, final LocalDateTime uuid) {
        return convertToLocalDateTime(s);
    }

    @Override
    public String convertFrom(final LocalDateTime localDateTime, final String s) {
        return convertToString(localDateTime);
    }
}
