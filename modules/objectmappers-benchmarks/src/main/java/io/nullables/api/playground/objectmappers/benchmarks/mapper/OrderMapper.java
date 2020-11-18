package io.nullables.api.playground.objectmappers.benchmarks.mapper;

import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;

@FunctionalInterface
public interface OrderMapper {
    /**
     * Returns converted {@link OrderDto} by input {@link OrderEntity}
     *
     * @param source initial input {@link OrderEntity}
     * @return converted {@link OrderDto}
     */
    OrderDto map(final OrderEntity source);
}
