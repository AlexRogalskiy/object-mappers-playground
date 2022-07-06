package io.nullables.api.playground.objectmappers.doov.model;

import static io.doov.core.dsl.runtime.FieldChainBuilder.from;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressDtoFieldType.CITY;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressDtoFieldType.COUNTRY;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressDtoFieldType.ID;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressDtoFieldType.POSTAL_CODE;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressDtoFieldType.STATE;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressDtoFieldType.STREET;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import io.doov.core.dsl.runtime.RuntimeField;
import io.doov.core.dsl.runtime.RuntimeFieldRegistry;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;

public class AddressDtoFieldModel extends RuntimeFieldRegistry<AddressDto> {

	/**
	 * Collection of {@link AddressDto} {@link RuntimeField}s
	 */
	private static final List<RuntimeField<AddressDto, Object>> ALL = new ArrayList<>();

	public static final RuntimeField<AddressDto, String> ID_SOURCE = from(AddressDto.class, ID)
			.readable("address identifier").field(AddressDto::getId, AddressDto::setId, String.class).register(ALL);

	public static final RuntimeField<AddressDto, String> CITY_SOURCE = from(AddressDto.class, CITY)
			.readable("address city").field(AddressDto::getCity, AddressDto::setCity, String.class).register(ALL);

	public static final RuntimeField<AddressDto, String> COUNTRY_SOURCE = from(AddressDto.class, COUNTRY)
			.readable("address country").field(AddressDto::getCountry, AddressDto::setCountry, String.class)
			.register(ALL);

	public static final RuntimeField<AddressDto, String> STATE_SOURCE = from(AddressDto.class, STATE)
			.readable("address state")
			.field(AddressDto::getStateOrProvince, AddressDto::setStateOrProvince, String.class).register(ALL);

	public static final RuntimeField<AddressDto, String> POSTAL_CODE_SOURCE = from(AddressDto.class, POSTAL_CODE)
			.readable("address postal code").field(AddressDto::getPostalCode, AddressDto::setPostalCode, String.class)
			.register(ALL);

	public static final RuntimeField<AddressDto, String> STREET_SOURCE = from(AddressDto.class, STREET)
			.readable("address street").field(AddressDto::getStreet, AddressDto::setStreet, String.class).register(ALL);

	/**
	 * Default private {@link AddressDtoFieldModel} constructor
	 */
	private AddressDtoFieldModel() {
		super(ALL);
	}

	@Nonnull
	public static AddressDtoFieldModel newInstance() {
		return new AddressDtoFieldModel();
	}

}
