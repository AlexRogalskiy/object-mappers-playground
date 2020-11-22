package io.nullables.api.playground.objectmappers.benchmarks;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.datus.DatusMapper;

public class DatusMapperTest extends AbstractMapperTest {

    @Override
    protected OrderMapper testedOrderMapper() {
        return new DatusMapper();
    }
}
