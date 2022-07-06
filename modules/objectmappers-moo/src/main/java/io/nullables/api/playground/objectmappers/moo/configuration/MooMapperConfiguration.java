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
package io.nullables.api.playground.objectmappers.moo.configuration;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import com.codiform.moo.curry.Translate;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;

public class MooMapperConfiguration {

	public DeliveryEntity translate(final DeliveryDto value) {
		return Translate.to(DeliveryEntity.class).withVariable("id", StringUtils.convertToUuid(value.getId()))
				.withVariable("type", value.getType()).withVariable("description", value.getDescription())
				.withVariable("gid", value.getGid()).withVariable("createdAt", value.getCreatedAt())
				.withVariable("updatedAt", value.getUpdatedAt())
				.withVariable("shippableDue", DateUtils.convertToLocalDateTime(value.getShippableDue()))
				.withVariable("balance", value.getBalance())
				.withVariable("discount", new BigDecimal(value.getDiscount())).withVariable("status", value.getStatus())
				.withVariable("addresses",
						Optional.ofNullable(value.getAddresses()).orElseGet(Collections::emptyList).stream()
								.map(this::translate).collect(Collectors.toList()))
				.withVariable("codes", StringUtils.convertToIntegerArray(value.getCodes())).from(value);
	}

	public AddressEntity translate(final AddressDto value) {
		return Translate.to(AddressEntity.class).withVariable("id", StringUtils.convertToUuid(value.getId()))
				.withVariable("city", value.getCity()).withVariable("country", value.getCountry())
				.withVariable("stateOrProvince", value.getStateOrProvince())
				.withVariable("postalCode", value.getPostalCode()).withVariable("street", value.getStreet())
				.from(value);
	}

}
