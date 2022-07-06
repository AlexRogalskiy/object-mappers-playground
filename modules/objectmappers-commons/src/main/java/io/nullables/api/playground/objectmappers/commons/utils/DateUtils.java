/**
 * Object Mappers GNU GPL License Agreement
 *
 * <p>Copyright (c) 2020 Nullables, Inc.
 *
 * <p>This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * <p>You should have received a copy of the GNU General Public License along with this program. If
 * not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.commons.utils;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtils {

	public static final String DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	public static final String ZONED_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

	public static final int SECONDS_PER_DAY = Math.toIntExact(TimeUnit.DAYS.toSeconds(1));

	public static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(HOUR_OF_DAY, 2)
			.appendLiteral(':').appendValue(MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':')
			.appendValue(SECOND_OF_MINUTE, 2).toFormatter(Locale.ROOT);

	public static final DateTimeFormatter DATETIME_FORMATTER = new DateTimeFormatterBuilder().parseCaseInsensitive()
			.append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T').append(TIME_FORMATTER)
			.toFormatter(Locale.ROOT);

	public static final DateTimeFormatter ZONED_DATETIME_FORMATTER = new DateTimeFormatterBuilder()
			.parseCaseInsensitive().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T').append(TIME_FORMATTER)
			.appendLiteral('Z').toFormatter(Locale.ROOT);

	@Nullable
	public LocalDateTime convertToLocalDateTime(final String value) {
		return Optional.ofNullable(value).map(v -> LocalDateTime.parse(v, DATETIME_FORMATTER)).orElse(null);
	}

	@Nullable
	public String convertToString(final LocalDateTime value) {
		return Optional.ofNullable(value).map(DATETIME_FORMATTER::format).orElse(null);
	}

}
