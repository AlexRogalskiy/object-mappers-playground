package io.nullables.api.playground.objectmappers.benchmarks.mapper.beanmapper;

import io.beanmapper.BeanMapper;
import io.beanmapper.config.BeanMapperBuilder;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;

public class GeneralBeanMapper implements OrderMapper {

    private final BeanMapper beanMapper;

    public GeneralBeanMapper() {
        this.beanMapper = new BeanMapperBuilder()
            .setApplyStrictMappingConvention(false)
            .setUseNullValue()
            .build();
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.beanMapper.map(source, OrderDto.class);
    }
}
