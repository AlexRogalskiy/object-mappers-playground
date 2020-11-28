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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.mapstruct;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
                injectionStrategy = InjectionStrategy.FIELD)
public interface MapStructOrderMapper extends OrderMapper {

    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "customer.billingAddress.street", target = "billingStreetAddress")
    @Mapping(source = "customer.billingAddress.city", target = "billingCity")
    @Mapping(source = "customer.shippingAddress.street", target = "shippingStreetAddress")
    @Mapping(source = "customer.shippingAddress.city", target = "shippingCity", defaultExpression = "java(null)")
    OrderDto map(final OrderEntity source);

    @Mapping(source = "name", target = "name")
    ProductDto productToProductDTO(final ProductEntity product);
}
