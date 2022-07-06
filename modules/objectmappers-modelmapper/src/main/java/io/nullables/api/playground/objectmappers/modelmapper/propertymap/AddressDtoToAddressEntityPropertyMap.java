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
package io.nullables.api.playground.objectmappers.modelmapper.propertymap;

import org.modelmapper.PropertyMap;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.modelmapper.converter.StringToUuidConverter;
import lombok.RequiredArgsConstructor;

/**
 * {@link AddressDto} to {@link AddressEntity} {@link PropertyMap} binding configuration
 */
@RequiredArgsConstructor
public class AddressDtoToAddressEntityPropertyMap extends PropertyMap<AddressDto, AddressEntity> {

	private final StringToUuidConverter stringToUuidConverter = new StringToUuidConverter();

	/**
	 * {@link AddressEntity} {@link PropertyMap} configuration
	 */
	@Override
	protected void configure() {
		// mapping destination properties
		this.map(this.source.getCity()).setCity(null);
		this.map(this.source.getCountry()).setCountry(null);
		this.map(this.source.getPostalCode()).setPostalCode(null);
		this.map(this.source.getStateOrProvince()).setStateOrProvince(null);
		this.map(this.source.getStreet()).setStreet(null);

		// mapping destination properties
		this.using(this.stringToUuidConverter).map(this.source.getId()).setId(null);
	}

}
