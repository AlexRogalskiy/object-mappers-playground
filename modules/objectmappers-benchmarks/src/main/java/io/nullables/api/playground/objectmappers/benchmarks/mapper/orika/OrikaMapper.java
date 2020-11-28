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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.orika;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Using custom BoundMapperFacade with no object graph cycles.
 *
 * @see <a href="http://orika-mapper.github.io/orika-docs/performance-tuning.html">
 *      http://orika-mapper.github.io/orika-docs/performance-tuning.html</a>
 */
public class OrikaMapper implements OrderMapper {

    private final BoundMapperFacade<OrderEntity, OrderDto> orderMapper;

    public OrikaMapper() {
        final MapperFactory factory = new DefaultMapperFactory.Builder().build();
        factory.registerClassMap(
                        factory.classMap(OrderEntity.class, OrderDto.class).field("customer.name", "customerName")
                                        .field("customer.billingAddress.street", "billingStreetAddress")
                                        .field("customer.billingAddress.city", "billingCity")
                                        .field("customer.shippingAddress.street", "shippingStreetAddress")
                                        .field("customer.shippingAddress.city", "shippingCity")
                                        .field("products", "products").toClassMap());
        this.orderMapper = factory.getMapperFacade(OrderEntity.class, OrderDto.class, false);
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.orderMapper.map(source);
    }
};
