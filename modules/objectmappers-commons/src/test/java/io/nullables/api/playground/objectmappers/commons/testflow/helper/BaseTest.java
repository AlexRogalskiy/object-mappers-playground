package io.nullables.api.playground.objectmappers.commons.testflow.helper;

import lombok.Getter;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.abstraction.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

@Getter
public abstract class BaseTest {
    /**
     * Default thread local mock instance {@link MockNeat}
     */
    protected final MockNeat mock = MockNeat.threadLocal();
    /**
     * Default integer mock unit instances {@link MockUnitInt}
     */
    protected final MockUnitInt thousandMock = ints().range(1, 999);
    protected final MockUnitInt monthMock = ints().range(1, 12);
    protected final MockUnitInt codeMock = ints().bound(10);
    protected final MockUnitInt intMock = ints().bound(1000000);
    protected final MockUnitInt byteMock = ints().bound(255);
    protected final MockUnitInt shortMock = ints().bound(15000);
    protected final MockUnitInt intRangeMock = ints().range(1000, 5000);
    /**
     * Default {@link MockUnitLong}
     */
    protected final MockUnitLong longMock = longs().bound(10000000);
    protected final MockUnitLong longRangeMock = longs().range(100000, 500000);
    /**
     * Default {@link MockUnitDouble}
     */
    protected final MockUnitDouble doubleMock = doubles().bound(50000);
    /**
     * Default {@link MockUnitFloat}
     */
    protected final MockUnitFloat floatMock = floats().bound(5000);
    /**
     * Default {@link MockUnitLocalDate}
     */
    protected final MockUnitLocalDate localDateMock = localDates();
    protected final MockUnitLocalDate yearLocalDateMock = localDates().thisYear();
    protected final MockUnitLocalDate pastLocalDateMock = localDates().past(LocalDate.now().minusYears(3));
    protected final MockUnitLocalDate futureLocalDateMock = localDates().future(LocalDate.now().plusYears(3));
    /**
     * Default {@link MockUnitString}
     */
    protected final MockUnitString alphaNumericStringMock = strings().types(ALPHA_NUMERIC);
    protected final MockUnitString lettersStringMock = strings().types(LETTERS);
    protected final MockUnitString numbersStringMock = strings().types(NUMBERS);
    /**
     * Default {@link MockUnitString}
     */
    protected final MockUnitString ipv4ClassACMock = this.getMock().ipv4s().types(CLASS_A, CLASS_C);
    protected final MockUnitString ipv6Mock = this.getMock().iPv6s().mapToString();
    protected final MockUnitString uuidMock = this.getMock().uuids().mapToString();
    protected final MockUnitString countryNameMock = this.getMock().countries().names();
    protected final MockUnitString cityNameMock = this.getMock().cities().capitals();
    protected final MockUnitString currencyNameMock = this.getMock().currencies().name();
    protected final MockUnitString creditCardNameMock = this.getMock().creditCards().names();
    protected final MockUnitString emailMock = this.getMock().emails().mapToString();
    protected final MockUnitString domainMock = this.getMock().domains().all();
    protected final MockUnitString departmentMock = this.getMock().departments().mapToString();
    protected final MockUnitString genderMock = this.getMock().genders().letter();
    protected final MockUnitString firstNameMock = this.getMock().names().first();
    protected final MockUnitString lastNameMock = this.getMock().names().last();
    protected final MockUnitString quotationMock = this.getMock().naughtyStrings().quotations();
    protected final MockUnitString dayNameMock = this.getMock().days().mapToString();
    protected final MockUnitString monthNameMock = this.getMock().months().mapToString();

    /**
     * Returns {@link MockUnit} to produce array of {@link Float} by initial input array size and range (lower / upper bounds)
     *
     * @param size       - initial input array size
     * @param lowerBound - initial input lower bound
     * @param upperBound - initial input upper bound
     * @return {@link MockUnit} to produce array of {@link Float}
     */
    protected MockUnit<Float[]> generateFloats(int size, float lowerBound, float upperBound) {
        return this.getMock().floats()
            .range(lowerBound, upperBound)
            .array(size);
    }

    /**
     * Returns {@link MockUnit} to produce array of {@link Double} by initial input array size and range (lower / upper bounds)
     *
     * @param size       - initial input array size
     * @param lowerBound - initial input lower bound
     * @param upperBound - initial input upper bound
     * @return {@link MockUnit} to produce array of {@link Double}
     */
    protected MockUnit<Double[]> generateDoubles(int size, double lowerBound, double upperBound) {
        return this.getMock().doubles()
            .range(lowerBound, upperBound)
            .array(size);
    }

    /**
     * Returns {@link MockUnit} to produce array of {@link Integer} by initial input array size and range (lower / upper bounds)
     *
     * @param size       - initial input array size
     * @param lowerBound - initial input lower value bound
     * @param upperBound - initial input upper value bound
     * @return {@link MockUnit} to produce array of {@link Integer}
     */
    protected MockUnit<Integer[]> generateInts(int size, int lowerBound, int upperBound) {
        return this.getMock().ints()
            .range(lowerBound, upperBound)
            .array(size);
    }

    /**
     * Returns {@link MockUnit} to produce array of {@link Long} by initial input array size and range (lower / upper bounds)
     *
     * @param size       - initial input array size
     * @param lowerBound - initial input lower value bound
     * @param upperBound - initial input value value bound
     * @return {@link MockUnit} to produce array of {@link Long}
     */
    protected MockUnit<Long[]> generateLongs(int size, long lowerBound, long upperBound) {
        return this.getMock().longs()
            .range(lowerBound, upperBound)
            .array(size);
    }

    /**
     * Returns mock unit {@link MockUnit} to produce {@link List} of {@link Integer} by initial input list size and bound
     *
     * @param size  - initial input {@link List} size
     * @param bound - initial input value bound
     * @return {@link MockUnit} to produce {@link List} of {@link Integer}
     */
    protected MockUnit<List<Integer>> generateInts(int size, int bound) {
        return this.getMock().ints()
            .bound(bound)
            .list(LinkedList.class, size);
    }

    /**
     * Returns {@link MockUnit} to produce list {@link List} of {@link String} by initial input list size
     *
     * @param size - initial input {@link List} size
     * @return {@link MockUnit} to produce list {@link List} of {@link String}
     */
    protected MockUnit<List<String>> generateStrings(int size) {
        final MockUnitInt num = getMock().probabilites(Integer.class)
            .add(0.3, getMock().ints().range(0, 10))
            .add(0.7, getMock().ints().range(10, 20))
            .mapToInt(Integer::intValue);

        return this.getMock().fmt("#{first} #{last} #{num}")
            .param("first", getMock().names().first().format(LOWER_CASE))
            .param("last", getMock().names().last().format(UPPER_CASE))
            .param("num", num)
            .list(size);
    }

    /**
     * Returns {@link MockUnit} to produce {@link List} of {@link Boolean} by initial input probability and size values
     *
     * @param probability - initial input probability value
     * @param size        - initial input {@link List} size
     * @return {@link MockUnit} to produce {@link List} of {@link Boolean}
     */
    protected MockUnit<List<Boolean>> generateBools(double probability, int size) {
        return this.getMock().bools()
            .probability(probability)
            .list(size);
    }

    /**
     * Returns {@link MockUnit} to produce {@link List} of {@link String} by range (lower / upper bounds)
     *
     * @param lowerBound - initial input lower value bound
     * @param upperBound - initial input value value bound
     * @return {@link MockUnit} to produce {@link List} of {@link Boolean}
     */
    protected MockUnit<List<String>> generateStrings(int lowerBound, int upperBound) {
        final MockUnitInt sizeGenerator = getMock().ints().range(lowerBound, upperBound);
        return this.getMock().strings()
            .list(ArrayList::new, sizeGenerator);
    }

    /**
     * Returns {@link MockUnit} to produce {@link List} of {@link String} by range (lower / upper bounds)
     *
     * @param dateStart - initial input date start value {@link LocalDate}
     * @param dateEnd   - initial input date end value {@link LocalDate}
     * @return {@link MockUnit} to produce {@link Date}
     */
    protected MockUnit<Date> generateDates(final LocalDate dateStart, final LocalDate dateEnd) {
        return this.getMock().localDates()
            .between(dateStart, dateEnd)
            .toUtilDate();
    }
}
