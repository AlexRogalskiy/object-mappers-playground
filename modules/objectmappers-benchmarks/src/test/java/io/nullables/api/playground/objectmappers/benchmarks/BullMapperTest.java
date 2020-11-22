package io.nullables.api.playground.objectmappers.benchmarks;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.bull.BullMapper;

public class BullMapperTest extends AbstractMapperTest {

    @Override
    protected OrderMapper testedOrderMapper() {
        return new BullMapper();
    }
}
