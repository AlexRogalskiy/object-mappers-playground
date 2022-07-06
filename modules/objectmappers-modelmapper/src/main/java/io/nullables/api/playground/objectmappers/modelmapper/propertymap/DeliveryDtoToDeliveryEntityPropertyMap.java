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

import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.modelmapper.converter.StringToIntegerArrayConverter;
import io.nullables.api.playground.objectmappers.modelmapper.converter.StringToLocalDateTimeConverter;
import io.nullables.api.playground.objectmappers.modelmapper.converter.StringToUuidConverter;
import lombok.RequiredArgsConstructor;

/**
 * {@link DeliveryDto} to {@link DeliveryEntity} {@link PropertyMap} binding configuration
 */
@RequiredArgsConstructor
public class DeliveryDtoToDeliveryEntityPropertyMap extends PropertyMap<DeliveryDto, DeliveryEntity> {

	private final StringToUuidConverter stringToUuidConverter = new StringToUuidConverter();

	private final StringToLocalDateTimeConverter stringToLocalDateTimeConverter = new StringToLocalDateTimeConverter();

	private final StringToIntegerArrayConverter stringToIntegerArrayConverter = new StringToIntegerArrayConverter();

	/**
	 * {@link DeliveryEntity} {@link PropertyMap} configuration
	 */
	@Override
	protected void configure() {
		// mapping destination properties
		this.map(this.source.getAddresses()).setAddresses(null);
		this.map(this.source.getCreatedAt()).setCreatedAt(null);
		this.map(this.source.getDescription()).setDescription(null);
		this.map(this.source.getDiscount()).setDiscount(null);
		this.map(this.source.getGid()).setGid(null);
		this.map(this.source.getStatus()).setStatus(null);
		this.map(this.source.getType()).setType(null);
		this.map(this.source.getUpdatedAt()).setUpdatedAt(null);

		this.map().setBalance(this.source.getBalance());

		// mapping destination properties
		this.using(this.stringToUuidConverter).map(this.source.getId()).setId(null);
		this.using(this.stringToLocalDateTimeConverter).map(this.source.getShippableDue()).setShippableDue(null);
		this.using(this.stringToIntegerArrayConverter).map(this.source.getCodes()).setCodes(null);
	}

}
