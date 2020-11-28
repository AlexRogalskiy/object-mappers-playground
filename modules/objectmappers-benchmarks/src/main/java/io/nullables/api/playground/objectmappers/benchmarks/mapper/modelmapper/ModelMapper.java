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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.modelmapper;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import org.modelmapper.PropertyMap;

public class ModelMapper implements OrderMapper {

    private final org.modelmapper.ModelMapper modelMapper;

    public ModelMapper() {
        this.modelMapper = new org.modelmapper.ModelMapper();
        this.modelMapper.addMappings(new PropertyMap<OrderEntity, OrderDto>() {
            @Override
            protected void configure() {
                this.map().setBillingStreetAddress(source.getCustomer().getBillingAddress().getStreet());
                this.map().setBillingCity(source.getCustomer().getBillingAddress().getCity());
                this.map().setShippingStreetAddress(source.getCustomer().getShippingAddress().getStreet());
                this.map().setShippingCity(source.getCustomer().getShippingAddress().getCity());
            }
        });
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.modelMapper.map(source, OrderDto.class);
    }
}
