package io.nullables.api.playground.objectmappers.selma.mapping;

import java.time.LocalDateTime;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime;
import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToString;

public class StringToLocalDateTimeMapper {

    public LocalDateTime stringToLocalDateTime(final String value) {
        return convertToLocalDateTime(value);
    }

    public String localTimeDateToString(final LocalDateTime value) {
        return convertToString(value);
    }
}
