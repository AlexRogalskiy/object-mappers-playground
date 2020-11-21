package io.nullables.api.playground.objectmappers.benchmarks.mapper.orika;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Using custom BoundMapperFacade with no object graph cycles.
 *
 * @see <a href="http://orika-mapper.github.io/orika-docs/performance-tuning.html">
 *      http://orika-mapper.github.io/orika-docs/performance-tuning.html</a>
 */
public class OrikaMapper implements OrderMapper {

    private final BoundMapperFacade<OrderEntity, OrderDto> orderMapper;

    public OrikaMapper() {
        final MapperFactory factory = new DefaultMapperFactory.Builder().build();
        factory.registerClassMap(
                        factory.classMap(OrderEntity.class, OrderDto.class).field("customer.name", "customerName")
                                        .field("customer.billingAddress.street", "billingStreetAddress")
                                        .field("customer.billingAddress.city", "billingCity")
                                        .field("customer.shippingAddress.street", "shippingStreetAddress")
                                        .field("customer.shippingAddress.city", "shippingCity")
                                        .field("products", "products").toClassMap());
        this.orderMapper = factory.getMapperFacade(OrderEntity.class, OrderDto.class, false);
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.orderMapper.map(source);
    }
};
