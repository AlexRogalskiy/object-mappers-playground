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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;

public class BeanUtilsMapper implements OrderMapper {

    private final BiConsumer<OrderEntity, OrderDto> orderMapper;
    private final BiConsumer<ProductEntity, ProductDto> productMapper;

    public BeanUtilsMapper() {
        this.productMapper = (source, target) -> this.wrap("name", source.getName()).accept(target);
        this.orderMapper = (source, target) -> {
            this.wrap("customerName", source.getCustomer().getName()).accept(target);
            this.wrap("shippingStreetAddress", source.getCustomer().getShippingAddress().getStreet()).accept(target);
            this.wrap("shippingCity", source.getCustomer().getShippingAddress().getCity()).accept(target);
            this.wrap("billingStreetAddress", source.getCustomer().getBillingAddress().getStreet()).accept(target);
            this.wrap("billingCity", source.getCustomer().getBillingAddress().getCity()).accept(target);
            this.wrap("products", source.getProducts().stream()
                .map(p -> {
                    final ProductDto product = new ProductDto();
                    this.productMapper.accept(p, product);
                    return product;
                })
                .collect(Collectors.toList())).accept(target);
        };
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        final OrderDto target = new OrderDto();
        this.orderMapper.accept(source, target);
        return target;
    }

    private <S, T> Consumer<T> wrap(final String propertyName, final S source) {
        return target -> {
            try {
                BeanUtils.copyProperty(target, propertyName, source);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                throw new IllegalArgumentException(ex);
            }
        };
    }
}
