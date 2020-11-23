package io.nullables.api.playground.objectmappers.benchmarks;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.beanmapper.GeneralBeanMapper;

public class BeanMapperTest extends AbstractMapperTest {

    @Override
    protected OrderMapper testedOrderMapper() {
        return new GeneralBeanMapper();
    }
}
