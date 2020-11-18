package io.nullables.api.playground.objectmappers.benchmarks;


import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractMapperTest {

    @Test
    public void map() {
        final OrderEntity order = OrderFactory.buildOrder();
        final OrderDto orderDTO = this.testedOrderMapper().map(order);

        assertEquals(orderDTO.getCustomerName(), "Joe Smith");
        assertEquals(orderDTO.getBillingStreetAddress(), "1234 Market Street");
        assertEquals(orderDTO.getBillingCity(), "San Fran");
        assertEquals(orderDTO.getShippingStreetAddress(), "1234 West Townsend");
        assertEquals(orderDTO.getShippingCity(), "Boston");
        assertEquals(orderDTO.getProducts().get(0).getName(), "socks");
        assertEquals(orderDTO.getProducts().get(1).getName(), "shoes");
    }

    protected abstract OrderMapper testedOrderMapper();
}
