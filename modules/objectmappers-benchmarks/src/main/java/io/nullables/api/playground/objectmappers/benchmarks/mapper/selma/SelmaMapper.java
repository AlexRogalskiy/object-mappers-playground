package io.nullables.api.playground.objectmappers.benchmarks.mapper.selma;

import fr.xebia.extras.selma.Selma;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;

public class SelmaMapper implements OrderMapper {

    private final SelmaOrderMapper mapper = Selma.builder(SelmaOrderMapper.class).build();

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.mapper.map(source);
    }
}
