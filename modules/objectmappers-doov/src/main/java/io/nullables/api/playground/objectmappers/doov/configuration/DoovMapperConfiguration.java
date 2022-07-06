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
package io.nullables.api.playground.objectmappers.doov.configuration;

import static io.doov.core.dsl.DOOV.map;
import static io.doov.core.dsl.mapping.TypeConverters.converter;
import static io.nullables.api.playground.objectmappers.doov.model.AddressDtoFieldModel.STREET_SOURCE;
import static io.nullables.api.playground.objectmappers.doov.model.AddressEntityFieldModel.STREET_TARGET;

import java.math.BigDecimal;

import javax.annotation.Nonnull;

import io.doov.core.dsl.mapping.MappingRegistry;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;
import io.nullables.api.playground.objectmappers.doov.model.AddressDtoFieldModel;
import io.nullables.api.playground.objectmappers.doov.model.AddressEntityFieldModel;
import io.nullables.api.playground.objectmappers.doov.model.DeliveryDtoFieldModel;
import io.nullables.api.playground.objectmappers.doov.model.DeliveryEntityFieldModel;

public final class DoovMapperConfiguration {

	private MappingRegistry mappings;

	private DoovMapperConfiguration() {
		this.mappings = MappingRegistry.mappings();
	}

	@Nonnull
	public static DoovMapperConfiguration newBuilder() {
		return new DoovMapperConfiguration();
	}

	public DoovMapperConfiguration configureAddressMappings() {
		this.mappings = this.mappings.with(
				map(AddressDtoFieldModel.ID_SOURCE)
						.using(converter(StringUtils::convertToUuid, "Converting identifier from <String> to <UUID>"))
						.to(AddressEntityFieldModel.ID_TARGET),
				map(AddressDtoFieldModel.CITY_SOURCE).to(AddressEntityFieldModel.CITY_TARGET),
				map(AddressDtoFieldModel.COUNTRY_SOURCE).to(AddressEntityFieldModel.COUNTRY_TARGET),
				map(AddressDtoFieldModel.STATE_SOURCE).to(AddressEntityFieldModel.STATE_TARGET),
				map(AddressDtoFieldModel.POSTAL_CODE_SOURCE).to(AddressEntityFieldModel.POSTAL_CODE_TARGET),
				map(AddressDtoFieldModel.STREET_SOURCE).to(AddressEntityFieldModel.STREET_TARGET));
		return this;
	}

	public DoovMapperConfiguration configureDeliveryMappings() {
		this.mappings = this.mappings.with(
				map(DeliveryDtoFieldModel.ID_SOURCE)
						.using(converter(StringUtils::convertToUuid, "Converting identifier from <String> to <UUID>"))
						.to(DeliveryEntityFieldModel.ID_TARGET),
				map(DeliveryDtoFieldModel.TYPE_SOURCE).to(DeliveryEntityFieldModel.TYPE_TARGET),
				map(DeliveryDtoFieldModel.DESCRIPTION_SOURCE).to(DeliveryEntityFieldModel.DESCRIPTION_TARGET),
				map(DeliveryDtoFieldModel.GID_SOURCE).to(DeliveryEntityFieldModel.GID_TARGET),
				map(DeliveryDtoFieldModel.CREATED_SOURCE).to(DeliveryEntityFieldModel.CREATED_TARGET),
				map(DeliveryDtoFieldModel.UPDATED_SOURCE).to(DeliveryEntityFieldModel.UPDATED_TARGET),
				map(DeliveryDtoFieldModel.SHIPPABLE_SOURCE)
						.using(converter(DateUtils::convertToLocalDateTime,
								"Converting shippable from <String> to <LocalDateTime>"))
						.to(DeliveryEntityFieldModel.SHIPPABLE_TARGET),
				map(DeliveryDtoFieldModel.BALANCE_SOURCE).to(DeliveryEntityFieldModel.BALANCE_TARGET),
				map(DeliveryDtoFieldModel.DISCOUNT_SOURCE)
						.using(converter(v -> StringUtils.convertToBigDecimal(v, BigDecimal.ZERO),
								"Converting discount from <String> to <BigDecimal>"))
						.to(DeliveryEntityFieldModel.DISCOUNT_TARGET),
				map(DeliveryDtoFieldModel.STATUS_SOURCE).to(DeliveryEntityFieldModel.STATUS_TARGET),
				map(DeliveryDtoFieldModel.ADDRESSES_SOURCE).to(DeliveryEntityFieldModel.ADDRESSES_TARGET),
				map(DeliveryDtoFieldModel.CODES_SOURCE)
						.using(converter(StringUtils::convertToIntegerArray,
								"Converting codes from <String> to <Integer> array"))
						.to(DeliveryEntityFieldModel.CODES_TARGET),
				map(STREET_SOURCE).to(STREET_TARGET));
		return this;
	}

	public MappingRegistry build() {
		return this.mappings;
	}

}
