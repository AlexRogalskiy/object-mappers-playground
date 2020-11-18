package io.nullables.api.playground.objectmappers.benchmarks.mapper.dozer;

import com.github.dozermapper.core.Mapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.dozer.configuration.DozerConfiguration;

public class DozerMapper implements OrderMapper {

    private final Mapper mapper;

    public DozerMapper() {
        this.mapper = new DozerConfiguration().configureMapper("mappings/dozer.xml");
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.mapper.map(source, OrderDto.class);
    }
}
