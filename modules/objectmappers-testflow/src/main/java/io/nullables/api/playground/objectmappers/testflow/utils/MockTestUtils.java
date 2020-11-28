/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.testflow.utils;

import lombok.experimental.UtilityClass;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.abstraction.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.nullables.api.playground.objectmappers.testflow.utils.LocalDateTimes.localDateTimes;
import static net.andreinc.mockneat.types.enums.IPv4Type.CLASS_A;
import static net.andreinc.mockneat.types.enums.IPv4Type.CLASS_C;
import static net.andreinc.mockneat.types.enums.StringFormatType.LOWER_CASE;
import static net.andreinc.mockneat.types.enums.StringFormatType.UPPER_CASE;
import static net.andreinc.mockneat.types.enums.StringType.*;
import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.time.LocalDates.localDates;
import static net.andreinc.mockneat.unit.types.Doubles.doubles;
import static net.andreinc.mockneat.unit.types.Floats.floats;
import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.types.Longs.longs;

@UtilityClass
public class MockTestUtils {
    /**
     * Default integer mock unit instances {@link MockUnitInt}
     */
    public static final MockUnitInt thousandMock = ints().range(1, 999);
    public static final MockUnitInt monthMock = ints().range(1, 12);
    public static final MockUnitInt codeMock = ints().bound(10);
    public static final MockUnitInt intMock = ints().bound(1000000);
    public static final MockUnitInt byteMock = ints().bound(255);
    public static final MockUnitInt shortMock = ints().bound(15000);
    public static final MockUnitInt intRangeMock = ints().range(1000, 5000);
    /**
     * Default {@link MockUnitLong}
     */
    public static final MockUnitLong longMock = longs().bound(10000000);
    public static final MockUnitLong longRangeMock = longs().range(100000, 500000);
    /**
     * Default {@link MockUnitDouble}
     */
    public static final MockUnitDouble doubleMock = doubles().bound(50000);
    /**
     * Default {@link MockUnitFloat}
     */
    public static final MockUnitFloat floatMock = floats().bound(5000);
    /**
     * Default {@link MockUnitLocalDate}
     */
    public static final MockUnitLocalDate localDateMock = localDates();
    public static final MockUnitLocalDateTime localDateTimeMock = localDateTimes();
    public static final MockUnitLocalDate yearLocalDateMock = localDates().thisYear();
    public static final MockUnitLocalDate pastLocalDateMock = localDates().past(LocalDate.now().minusYears(3));
    public static final MockUnitLocalDate futureLocalDateMock = localDates().future(LocalDate.now().plusYears(3));
    /**
     * Default {@link MockUnitString}
     */
    public static final MockUnitString alphaNumericStringMock = strings().types(ALPHA_NUMERIC);
    public static final MockUnitString lettersStringMock = strings().types(LETTERS);
    public static final MockUnitString numbersStringMock = strings().types(NUMBERS);
    /**
     * Default {@link MockUnitString}
     */
    public static final MockUnitString ipv4ClassACMock = MockNeat.threadLocal().ipv4s().types(CLASS_A, CLASS_C);
    public static final MockUnitString ipv6Mock = MockNeat.threadLocal().iPv6s().mapToString();
    public static final MockUnitString uuidMock = MockNeat.threadLocal().uuids().mapToString();
    public static final MockUnitString countryNameMock = MockNeat.threadLocal().countries().names();
    public static final MockUnitString cityNameMock = MockNeat.threadLocal().cities().capitals();
    public static final MockUnitString currencyNameMock = MockNeat.threadLocal().currencies().name();
    public static final MockUnitString creditCardNameMock = MockNeat.threadLocal().creditCards().names();
    public static final MockUnitString emailMock = MockNeat.threadLocal().emails().mapToString();
    public static final MockUnitString domainMock = MockNeat.threadLocal().domains().all();
    public static final MockUnitString departmentMock = MockNeat.threadLocal().departments().mapToString();
    public static final MockUnitString genderMock = MockNeat.threadLocal().genders().letter();
    public static final MockUnitString firstNameMock = MockNeat.threadLocal().names().first();
    public static final MockUnitString lastNameMock = MockNeat.threadLocal().names().last();
    public static final MockUnitString quotationMock = MockNeat.threadLocal().naughtyStrings().quotations();
    public static final MockUnitString dayNameMock = MockNeat.threadLocal().days().mapToString();
    public static final MockUnitString monthNameMock = MockNeat.threadLocal().months().mapToString();

    /**
     * Returns {@link MockUnit} to produce array of {@link Float} by initial input array size and range (lower / upper
     * bounds)
     *
     * @param size - initial input array size
     * @param lowerBound - initial input lower bound
     * @param upperBound - initial input upper bound
     * @return {@link MockUnit} to produce array of {@link Float}
     */
    public static MockUnit<Float[]> generateFloats(int size, float lowerBound, float upperBound) {
        return MockNeat.threadLocal().floats().range(lowerBound, upperBound).array(size);
    }

    /**
     * Returns {@link MockUnit} to produce array of {@link Double} by initial input array size and range (lower / upper
     * bounds)
     *
     * @param size - initial input array size
     * @param lowerBound - initial input lower bound
     * @param upperBound - initial input upper bound
     * @return {@link MockUnit} to produce array of {@link Double}
     */
    public static MockUnit<Double[]> generateDoubles(int size, double lowerBound, double upperBound) {
        return MockNeat.threadLocal().doubles().range(lowerBound, upperBound).array(size);
    }

    /**
     * Returns {@link MockUnit} to produce array of {@link Integer} by initial input array size and range (lower / upper
     * bounds)
     *
     * @param size - initial input array size
     * @param lowerBound - initial input lower value bound
     * @param upperBound - initial input upper value bound
     * @return {@link MockUnit} to produce array of {@link Integer}
     */
    public static MockUnit<Integer[]> generateInts(int size, int lowerBound, int upperBound) {
        return MockNeat.threadLocal().ints().range(lowerBound, upperBound).array(size);
    }

    /**
     * Returns {@link MockUnit} to produce array of {@link Long} by initial input array size and range (lower / upper
     * bounds)
     *
     * @param size - initial input array size
     * @param lowerBound - initial input lower value bound
     * @param upperBound - initial input value value bound
     * @return {@link MockUnit} to produce array of {@link Long}
     */
    public static MockUnit<Long[]> generateLongs(int size, long lowerBound, long upperBound) {
        return MockNeat.threadLocal().longs().range(lowerBound, upperBound).array(size);
    }

    /**
     * Returns mock unit {@link MockUnit} to produce {@link List} of {@link Integer} by initial input list size and
     * bound
     *
     * @param size - initial input {@link List} size
     * @param bound - initial input value bound
     * @return {@link MockUnit} to produce {@link List} of {@link Integer}
     */
    public static MockUnit<List<Integer>> generateInts(int size, int bound) {
        return MockNeat.threadLocal().ints().bound(bound).list(LinkedList.class, size);
    }

    /**
     * Returns {@link MockUnit} to produce list {@link List} of {@link String} by initial input list size
     *
     * @param size - initial input {@link List} size
     * @return {@link MockUnit} to produce list {@link List} of {@link String}
     */
    public static MockUnit<List<String>> generateStrings(int size) {
        final MockUnitInt num = MockNeat.threadLocal().probabilites(Integer.class)
                        .add(0.3, MockNeat.threadLocal().ints().range(0, 10))
                        .add(0.7, MockNeat.threadLocal().ints().range(10, 20)).mapToInt(Integer::intValue);

        return MockNeat.threadLocal().fmt("#{first} #{last} #{num}")
                        .param("first", MockNeat.threadLocal().names().first().format(LOWER_CASE))
                        .param("last", MockNeat.threadLocal().names().last().format(UPPER_CASE)).param("num", num)
                        .list(size);
    }

    /**
     * Returns {@link MockUnit} to produce {@link List} of {@link Boolean} by initial input probability and size values
     *
     * @param probability - initial input probability value
     * @param size - initial input {@link List} size
     * @return {@link MockUnit} to produce {@link List} of {@link Boolean}
     */
    public static MockUnit<List<Boolean>> generateBooleans(double probability, int size) {
        return MockNeat.threadLocal().bools().probability(probability).list(size);
    }

    /**
     * Returns {@link MockUnit} to produce {@link List} of {@link String} by range (lower / upper bounds)
     *
     * @param lowerBound - initial input lower value bound
     * @param upperBound - initial input value value bound
     * @return {@link MockUnit} to produce {@link List} of {@link Boolean}
     */
    public static MockUnit<List<String>> generateStrings(int lowerBound, int upperBound) {
        final MockUnitInt sizeGenerator = MockNeat.threadLocal().ints().range(lowerBound, upperBound);
        return MockNeat.threadLocal().strings().list(ArrayList::new, sizeGenerator);
    }

    /**
     * Returns {@link MockUnit} to produce {@link List} of {@link String} by range (lower / upper bounds)
     *
     * @param dateStart - initial input date start value {@link LocalDate}
     * @param dateEnd - initial input date end value {@link LocalDate}
     * @return {@link MockUnit} to produce {@link Date}
     */
    public static MockUnit<Date> generateDates(final LocalDate dateStart, final LocalDate dateEnd) {
        return MockNeat.threadLocal().localDates().between(dateStart, dateEnd).mapToDate();
    }
}
