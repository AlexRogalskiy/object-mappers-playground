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
//package io.nullables.api.playground.objectmappers.benchmarks.mapper.jmapper;
//
//import com.googlecode.jmapper.JMapper;
//import com.googlecode.jmapper.api.JMapperAPI;
//import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
//import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
//import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
//import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
//
//import static com.googlecode.jmapper.api.JMapperAPI.attribute;
//import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;
//
//public class JMapperMapper implements OrderMapper {
//
//    private final JMapper<OrderDto, OrderEntity> mapper;
//
//    public JMapperMapper() {
//        final JMapperAPI api = new JMapperAPI()
//            .add(mappedClass(OrderDto.class)
//                .add(attribute("shippingStreetAddress").value("${customer.shippingAddress.street}"))
//                .add(attribute("shippingCity").value("${customer.shippingAddress.city}"))
//                .add(attribute("billingStreetAddress").value("${customer.billingAddress.street}"))
//                .add(attribute("billingCity").value("${customer.billingAddress.city}"))
//                .add(attribute("customerName").value("${customer.name}"))
//            .add(attribute("products").value("products")))
//            .add(mappedClass(ProductDto.class)
//            .add(attribute("name").value("name")));
//
//        this.mapper = new JMapper<>(OrderDto.class, OrderEntity.class, api);
//    }
//
//    @Override
//    public OrderDto map(final OrderEntity source) {
//        return this.mapper.getDestination(source);
//    }
//}
