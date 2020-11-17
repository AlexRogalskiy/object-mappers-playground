package io.nullables.api.playground.objectmappers.commons.utils;

import lombok.experimental.UtilityClass;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoField.*;

@UtilityClass
public class DateUtils {

    public static final String DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String ZONED_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static final int SECONDS_PER_DAY = Math.toIntExact(TimeUnit.DAYS.toSeconds(1));

    public static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
        .appendValue(HOUR_OF_DAY, 2)
        .appendLiteral(':')
        .appendValue(MINUTE_OF_HOUR, 2)
        .optionalStart()
        .appendLiteral(':')
        .appendValue(SECOND_OF_MINUTE, 2)
        .toFormatter(Locale.ROOT);

    public static final DateTimeFormatter DATETIME_FORMATTER = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(DateTimeFormatter.ISO_LOCAL_DATE)
        .appendLiteral('T')
        .append(TIME_FORMATTER)
        .toFormatter(Locale.ROOT);

    public static final DateTimeFormatter ZONED_DATETIME_FORMATTER = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(DateTimeFormatter.ISO_LOCAL_DATE)
        .appendLiteral('T')
        .append(TIME_FORMATTER)
        .appendLiteral('Z')
        .toFormatter(Locale.ROOT);
}
