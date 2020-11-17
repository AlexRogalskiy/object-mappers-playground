package io.nullables.api.playground.objectmappers.testflow.utils;

import net.andreinc.mockneat.abstraction.MockUnit;
import net.andreinc.mockneat.abstraction.MockUnitString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static java.util.Date.from;
import static net.andreinc.mockneat.utils.MockUnitUtils.ifSupplierNotNullDo;
import static net.andreinc.mockneat.utils.ValidationUtils.notNull;

public interface MockUnitLocalDateTime extends MockUnit<LocalDateTime> {


    /**
     * <p>Transforms an existing {@code MockUnitLocalDateTime} into a {@code MockUnit<java.util.Date>}.</p>
     * <p>
     * Use {@code mapToDate()} method instead.
     *
     * @return A new {@code MockUnit<java.util.Date>}.
     */
    @Deprecated
    default MockUnit<Date> toUtilDate() {
        return () -> ifSupplierNotNullDo(supplier(),
            localDateTime -> from(
                localDateTime.atZone(ZoneId.systemDefault())
                    .toInstant()));
    }

    /**
     * <p>Transforms an existing {@code MockUnitLocalDateTime} into a {@code MockUnit<java.util.Date>}.</p>
     *
     * @return A new {@code MockUnit<java.util.Date>}.
     */
    default MockUnit<Date> mapToDate() {
        return () -> ifSupplierNotNullDo(supplier(), MockUnitLocalDateTime::convertToDateViaInstant);
    }

    /**
     * <p>Transforms an existing {@code MockUnitLocalDateTime} into a {@code MockUnitString} - the textual representation of the date object.</p>
     *
     * @param format The format of the date. (Eg.: "yyyy:MM:dd")
     * @return A new {@code MockUnitString}
     */
    default MockUnitString display(String format) {
        return this.display(format, Locale.getDefault());
    }

    /**
     * <p>Transforms an existing {@code MockUnitLocalDateTime} into a {@code MockUnitString} - the textual representation of the date object.</p>
     *
     * @param locale the locale. (Eg.: Locale.FRANCE)
     * @param format The format of the date. (Eg.: "yyyy:MM:dd")
     * @return A new {@code MockUnitString}
     */
    default MockUnitString display(String format, Locale locale) {
        notNull(format, "format");
        notNull(locale, "locale");

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format, locale);
        return () -> ifSupplierNotNullDo(supplier(), LocalDateTime -> LocalDateTime.format(dtf));
    }

    default MockUnitString display(DateTimeFormatter dtf, Locale locale) {
        notNull(dtf, "dtf");
        notNull(locale, "locale");
        return () -> ifSupplierNotNullDo(supplier(), dtf::format);
    }

    default MockUnitString display(DateTimeFormatter dtf) {
        return this.display(dtf, Locale.getDefault());
    }

    static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }
}
