package io.nullables.api.playground.objectmappers.benchmarks.mapper.mapstruct;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import org.mapstruct.factory.Mappers;

public class MapStructMapper implements OrderMapper {

    private final MapStructOrderMapper mapper = Mappers.getMapper(MapStructOrderMapper.class);

    @Override
    public OrderDto map(final OrderEntity source) {
        return mapper.map(source);
    }
}
