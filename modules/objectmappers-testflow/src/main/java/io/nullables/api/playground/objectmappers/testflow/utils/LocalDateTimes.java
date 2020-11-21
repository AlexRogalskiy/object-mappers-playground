package io.nullables.api.playground.objectmappers.testflow.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.abstraction.MockUnitBase;

import java.time.*;
import java.util.function.Supplier;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.SECONDS_PER_DAY;
import static java.time.LocalDate.*;
import static net.andreinc.mockneat.utils.ValidationUtils.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocalDateTimes extends MockUnitBase implements MockUnitLocalDateTime {

    public static final LocalDateTime EPOCH_START = LocalDateTime.of(LocalDate.ofEpochDay(0), LocalTime.of(0, 0, 0, 0));

    public static LocalDateTimes localDateTimes() {
        return new LocalDateTimes(MockNeat.threadLocal());
    }

    public LocalDateTimes(MockNeat mockNeat) {
        super(mockNeat);
    }

    @Override
    public Supplier<LocalDateTime> supplier() {
        return between(EPOCH_START, LocalDateTime.now(Clock.systemDefaultZone()))::val;
    }

    /**
     * <p>
     * This method can be used to generate date objects from the current year.
     * </p>
     *
     * @return A new {@code MockUnitLocalDateTime} object.
     */
    public MockUnitLocalDateTime thisYear() {
        Supplier<LocalDateTime> supp = () -> {
            int year = now().getYear();
            int randDay = mockNeat.ints().range(1, now().lengthOfYear() + 1).val();
            int randSecond = mockNeat.ints().range(1, SECONDS_PER_DAY).val();
            return LocalDateTime.of(ofYearDay(year, randDay), LocalTime.ofSecondOfDay(randSecond));
        };
        return () -> supp;
    }

    /**
     * <p>
     * This method can be used to generate date objects from the current month.
     * </p>
     *
     * @return A new {@code MockUnitLocalDateTime} object.
     */
    public MockUnitLocalDateTime thisMonth() {
        Supplier<LocalDateTime> supp = () -> {
            int year = now().getYear();
            Month month = now().getMonth();
            int randDay = mockNeat.ints().range(1, now().lengthOfMonth() + 1).val();
            int randSecond = mockNeat.ints().range(1, SECONDS_PER_DAY).val();
            return LocalDateTime.of(of(year, month, randDay), LocalTime.ofSecondOfDay(randSecond));
        };
        return () -> supp;
    }

    /**
     * <p>
     * This method can be used to generate date objects in the defined range (lowerDate, upperDate).
     * </p>
     *
     * @param lowerDate The lower limit of the interval.
     * @param upperDate The upper limit of the interval.
     * @return A new {@code MockUnitLocalDateTime} object.
     */
    public MockUnitLocalDateTime between(LocalDateTime lowerDate, LocalDateTime upperDate) {
        notNull(lowerDate, "lowerDate");
        notNull(upperDate, "upperDate");
        isTrue(lowerDate.compareTo(upperDate) < 0, LOWER_DATE_SMALLER_THAN_UPPER_DATE, "lower", lowerDate, "upper",
                        upperDate);

        Supplier<LocalDateTime> supp = () -> {
            long lowerEpoch = lowerDate.atZone(ZoneId.systemDefault()).toEpochSecond();
            long upperEpoch = upperDate.atZone(ZoneId.systemDefault()).toEpochSecond();
            long diff = upperEpoch - lowerEpoch;
            long randEpoch = mockNeat.longs().range(0, diff).val();
            return LocalDateTime.ofInstant(Instant.ofEpochSecond(lowerEpoch + randEpoch), ZoneId.systemDefault());
        };
        return () -> supp;
    }

    /**
     * <p>
     * This method can be used to generate date objects in the future.
     * </p>
     *
     * @param maxDate The maxDate from the future.
     * @return A new {@code MockUnitLocalDateTime} object.
     */
    public MockUnitLocalDateTime future(LocalDateTime maxDate) {
        notNull(maxDate, "maxDate");
        isTrue(maxDate.compareTo(LocalDateTime.MAX.minusDays(1)) <= 0, MAX_DATE_NOT_BIGGER_THAN, "max", maxDate, "date",
                        MAX.minusDays(1));
        isTrue(maxDate.plusDays(1).compareTo(LocalDateTime.now()) > 0, MAX_DATE_DIFFERENT_THAN_NOW, "max", maxDate,
                        "now", now());
        return between(LocalDateTime.now().plusDays(1), maxDate.plusDays(1));
    }

    /**
     * <p>
     * This method can be used to generate date objects in the past.
     * </p>
     *
     * @param minDate The minDate from the past.
     * @return A new {@code MockUnitLocalDateTime}.
     */
    public MockUnitLocalDateTime past(LocalDateTime minDate) {
        notNull(minDate, "minDate");
        isTrue(minDate.compareTo(LocalDateTime.MIN) > 0, MIN_DATE_BIGGER_THAN, "min", minDate, "date", MIN);
        isTrue(minDate.minusDays(1).compareTo(LocalDateTime.now()) < 0, MIN_DATE_DIFFERENT_THAN_NOW, "min", minDate,
                        "now", now());
        return between(minDate, LocalDateTime.now());
    }
}
