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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.remap;

import java.util.Optional;

import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.CustomerEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;

public final class ReMapper implements OrderMapper {

	private final Mapper<ProductEntity, ProductDto> mapperToDtoProduct = Mapping.from(ProductEntity.class)
			.to(ProductDto.class).mapper();

	private final Mapper<OrderEntity, OrderDto> mapperToDto = Mapping.from(OrderEntity.class).to(OrderDto.class)
			.replace(OrderEntity::getCustomer, OrderDto::getCustomerName).withSkipWhenNull(CustomerEntity::getName)
			.replace(OrderEntity::getCustomer, OrderDto::getBillingStreetAddress).withSkipWhenNull(customer -> {
				final AddressEntity billingAddress = customer.getBillingAddress();
				return Optional.ofNullable(billingAddress).map(AddressEntity::getStreet).orElse(null);
			}).replace(OrderEntity::getCustomer, OrderDto::getBillingCity).withSkipWhenNull(customer -> {
				final AddressEntity billingAddress = customer.getBillingAddress();
				return Optional.ofNullable(billingAddress).map(AddressEntity::getCity).orElse(null);
			}).replace(OrderEntity::getCustomer, OrderDto::getShippingStreetAddress).withSkipWhenNull(customer -> {
				final AddressEntity shippingAddress = customer.getShippingAddress();
				return Optional.ofNullable(shippingAddress).map(AddressEntity::getStreet).orElse(null);
			}).replace(OrderEntity::getCustomer, OrderDto::getShippingCity).withSkipWhenNull(customer -> {
				final AddressEntity shippingAddress = customer.getShippingAddress();
				return Optional.ofNullable(shippingAddress).map(AddressEntity::getCity).orElse(null);
			}).useMapper(this.mapperToDtoProduct).mapper();

	@Override
	public OrderDto map(final OrderEntity source) {
		return this.mapperToDto.map(source);
	}

}
