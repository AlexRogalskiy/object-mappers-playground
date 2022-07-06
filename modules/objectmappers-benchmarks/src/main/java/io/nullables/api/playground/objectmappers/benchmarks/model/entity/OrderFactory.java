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
package io.nullables.api.playground.objectmappers.benchmarks.model.entity;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderFactory {

	@Nonnull
	public static OrderEntity buildOrder() {
		final OrderEntity entity = new OrderEntity();
		entity.setCustomer(buildCustomer());
		entity.setProducts(buildProducts());
		return entity;
	}

	@Nonnull
	public static CustomerEntity buildCustomer() {
		final CustomerEntity entity = new CustomerEntity();
		entity.setName("Joe Smith");
		entity.setBillingAddress(buildBillingAddress());
		entity.setShippingAddress(buildShippingAddress());
		return entity;
	}

	@Nonnull
	public static AddressEntity buildBillingAddress() {
		final AddressEntity entity = new AddressEntity();
		entity.setStreet("1234 Market Street");
		entity.setCity("San Fran");
		return entity;
	}

	@Nonnull
	public static AddressEntity buildShippingAddress() {
		final AddressEntity entity = new AddressEntity();
		entity.setStreet("1234 West Townsend");
		entity.setCity("Boston");
		return entity;
	}

	@Nonnull
	public static List<ProductEntity> buildProducts() {
		return Arrays.asList(new ProductEntity("socks"), new ProductEntity("shoes"));
	}

}
