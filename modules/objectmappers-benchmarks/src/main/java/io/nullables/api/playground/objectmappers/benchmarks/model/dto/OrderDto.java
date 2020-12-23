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
package io.nullables.api.playground.objectmappers.benchmarks.model.dto;

import java.util.List;

import io.beanmapper.annotations.BeanCollection;
import io.beanmapper.annotations.BeanCollectionUsage;
import io.beanmapper.annotations.BeanProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    @BeanCollection(elementType = ProductDto.class, beanCollectionUsage = BeanCollectionUsage.CONSTRUCT)
    private List<ProductDto> products;

    @BeanProperty(name = "customer.name")
    private String customerName;

    @BeanProperty(name = "customer.shippingAddress.street")
    private String shippingStreetAddress;

    @BeanProperty(name = "customer.shippingAddress.city")
    private String shippingCity;

    @BeanProperty(name = "customer.billingAddress.street")
    private String billingStreetAddress;

    @BeanProperty(name = "customer.billingAddress.city")
    private String billingCity;
}
