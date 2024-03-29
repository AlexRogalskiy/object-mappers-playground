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
package io.nullables.api.playground.objectmappers.benchmarks.mapper.dozer;

import com.github.dozermapper.core.Mapper;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.dozer.configuration.DozerMapperConfiguration;

public class DozerMapper implements OrderMapper {

	private final Mapper mapper;

	public DozerMapper() {
		this.mapper = DozerMapperConfiguration.newBuilder().configureMapper("mappings/dozer.xml").build();
	}

	@Override
	public OrderDto map(final OrderEntity source) {
		return this.mapper.map(source, OrderDto.class);
	}

}
