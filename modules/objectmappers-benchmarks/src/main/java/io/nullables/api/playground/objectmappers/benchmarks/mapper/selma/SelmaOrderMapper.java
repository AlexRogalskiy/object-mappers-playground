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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.selma;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;

@Mapper(withCustomFields = {@Field({"customer.name", "customerName"}),
    @Field({"customer.billingAddress.street", "billingStreetAddress"}),
    @Field({"customer.billingAddress.city", "billingCity"}),
    @Field({"customer.shippingAddress.street", "shippingStreetAddress"}),
    @Field({"customer.shippingAddress.city", "shippingCity"})
})
public interface SelmaOrderMapper {

    OrderDto map(final OrderEntity source);

    ProductDto map(final ProductEntity product);
}
