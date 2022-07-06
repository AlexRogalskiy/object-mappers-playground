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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.bull;

import java.util.stream.Stream;

import com.hotels.beans.BeanUtils;
import com.hotels.beans.transformer.BeanTransformer;
import com.hotels.transformer.model.FieldMapping;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;

public class BullMapper implements OrderMapper {

	private final BeanTransformer transformer;

	public BullMapper() {
		final FieldMapping<String, String>[] fieldMappings = Stream
				.of(new FieldMapping<>("customer.name", "customerName"),
						new FieldMapping<>("customer.billingAddress.city", "billingCity"),
						new FieldMapping<>("customer.billingAddress.street", "billingStreetAddress"),
						new FieldMapping<>("customer.shippingAddress.city", "shippingCity"),
						new FieldMapping<>("customer.shippingAddress.street", "shippingStreetAddress"))
				.<FieldMapping<String, String>>toArray(FieldMapping[]::new);
		this.transformer = new BeanUtils().getTransformer().withFieldMapping(fieldMappings);
	}

	@Override
	public OrderDto map(final OrderEntity source) {
		return this.transformer.transform(source, OrderDto.class);
	}

}
