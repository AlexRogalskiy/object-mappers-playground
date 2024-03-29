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

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_PATTERN;
import static io.nullables.api.playground.objectmappers.testflow.utils.MockTestUtils.alphaNumericStringMock;
import static io.nullables.api.playground.objectmappers.testflow.utils.MockTestUtils.doubleMock;
import static io.nullables.api.playground.objectmappers.testflow.utils.MockTestUtils.generateInts;
import static io.nullables.api.playground.objectmappers.testflow.utils.MockTestUtils.intMock;
import static io.nullables.api.playground.objectmappers.testflow.utils.MockTestUtils.lettersStringMock;
import static io.nullables.api.playground.objectmappers.testflow.utils.MockTestUtils.localDateMock;
import static io.nullables.api.playground.objectmappers.testflow.utils.MockTestUtils.localDateTimeMock;
import static net.andreinc.mockneat.unit.id.UUIDs.uuids;
import static net.andreinc.mockneat.unit.objects.Filler.filler;
import static net.andreinc.mockneat.unit.types.Ints.ints;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import lombok.experimental.UtilityClass;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.abstraction.MockUnit;

@UtilityClass
public class ModelMockTestUtils {

	/**
	 * Default number of {@link AddressDto} items
	 */
	public static final int DEFAULT_ADDRESS_INFO_COUNT = 5;

	/**
	 * Default {@link DeliveryStatus} collection {@link List}
	 */
	public static final List<DeliveryStatus> DELIVERY_STATUS_LIST = Collections
			.unmodifiableList(Arrays.asList(DeliveryStatus.values()));

	/**
	 * Default {@link DeliveryDto} {@link MockUnit}
	 * @return {@link DeliveryDto} {@link MockUnit}
	 */
	public static MockUnit<DeliveryDto> deliveryDtoMock() {
		return deliveryDtoMock(DEFAULT_ADDRESS_INFO_COUNT);
	}

	/**
	 * Default delivery info mock unit instance {@link MockUnit}
	 * @return delivery info mock unit instance {@link MockUnit}
	 */
	public static MockUnit<DeliveryDto> deliveryDtoMock(int addressCount) {
		return filler(DeliveryDto::new).setter(DeliveryDto::setId, uuids().mapToString())
				.setter(DeliveryDto::setType, intMock).setter(DeliveryDto::setGid, alphaNumericStringMock)
				.setter(DeliveryDto::setDescription, lettersStringMock)
				.setter(DeliveryDto::setCreatedAt, localDateMock.mapToDate())
				.setter(DeliveryDto::setUpdatedAt, localDateMock.mapToDate())
				.setter(DeliveryDto::setShippableDue, localDateTimeMock.display(DATETIME_PATTERN, Locale.ROOT))
				.setter(DeliveryDto::setBalance, doubleMock).setter(DeliveryDto::setStatus, generateStatus())
				.setter(DeliveryDto::setDiscount, generateDiscount(1.5, 20.5).mapToString())
				.setter(DeliveryDto::setCodes, generateCodes(10, 100, 200))
				.setter(DeliveryDto::setAddresses, addressDtoMock().list(addressCount));
	}

	/**
	 * Default {@link AddressDto} {@link MockUnit}
	 * @return {@link AddressDto} {@link MockUnit}
	 */
	public static MockUnit<AddressDto> addressDtoMock() {
		return filler(AddressDto::new).setter(AddressDto::setId, uuids().mapToString())
				.setter(AddressDto::setCity, lettersStringMock).setter(AddressDto::setCountry, lettersStringMock)
				.setter(AddressDto::setPostalCode, alphaNumericStringMock)
				.setter(AddressDto::setStateOrProvince, lettersStringMock)
				.setter(AddressDto::setStreet, lettersStringMock);
	}

	/**
	 * Returns {@link DeliveryStatus} {@link MockUnit}
	 * @return {@link DeliveryStatus} {@link MockUnit}
	 */
	public static MockUnit<DeliveryStatus> generateStatus() {
		return ints().bound(DELIVERY_STATUS_LIST.size()).map(DELIVERY_STATUS_LIST::get);
	}

	/**
	 * Returns delivery info discount {@link MockUnit} by initial input range (lower /
	 * upper bounds)
	 * @return delivery info discount {@link MockUnit}
	 */
	public static MockUnit<BigDecimal> generateDiscount(double lowerBound, double upperBound) {
		return MockNeat.threadLocal().doubles().range(lowerBound, upperBound).map(BigDecimal::valueOf);
	}

	/**
	 * Returns delivery info discount {@link MockUnit} by initial input range (lower /
	 * upper bounds)
	 * @return delivery info discount {@link MockUnit}
	 */
	public static MockUnit<String[]> generateCodes(int size, int lowerBound, int upperBound) {
		return generateInts(10, 100, 200).map(v -> Arrays.stream(v).map(String::valueOf).toArray(String[]::new));
	}

}
