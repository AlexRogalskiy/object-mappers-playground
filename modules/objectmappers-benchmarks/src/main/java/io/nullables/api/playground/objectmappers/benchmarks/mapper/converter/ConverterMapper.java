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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.converter;

import java.util.ArrayList;
import java.util.List;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.CustomerEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;

public final class ConverterMapper implements OrderMapper {

	@Override
	public OrderDto map(final OrderEntity source) {
		final OrderDto target = new OrderDto();
		final CustomerEntity customer = source.getCustomer();
		this.mapCustomer(target, customer);
		this.mapProducts(target, source);
		return target;
	}

	private void mapCustomer(final OrderDto target, final CustomerEntity customer) {
		if (customer != null) {
			target.setCustomerName(customer.getName());
			this.mapBillingAddress(target, customer.getBillingAddress());
			this.mapShippingAddress(target, customer.getShippingAddress());
		}
	}

	private void mapShippingAddress(final OrderDto target, final AddressEntity shippingAddress) {
		if (shippingAddress != null) {
			target.setShippingCity(shippingAddress.getCity());
			target.setShippingStreetAddress(shippingAddress.getStreet());
		}
	}

	private void mapBillingAddress(final OrderDto target, final AddressEntity billingAddress) {
		if (billingAddress != null) {
			target.setBillingCity(billingAddress.getCity());
			target.setBillingStreetAddress(billingAddress.getStreet());
		}
	}

	private void mapProducts(final OrderDto target, final OrderEntity source) {
		if (source.getProducts() == null) {
			return;
		}
		final List<ProductDto> targetProducts = new ArrayList<>(source.getProducts().size());
		for (final ProductEntity product : source.getProducts()) {
			targetProducts.add(new ProductDto(product.getName()));
		}
		target.setProducts(targetProducts);
	}

}
