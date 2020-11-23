package io.nullables.api.playground.objectmappers.benchmarks.mapper.beanutils;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BeanUtilsMapper implements OrderMapper {

    private final BiConsumer<OrderEntity, OrderDto> orderMapper;
    private final BiConsumer<ProductEntity, ProductDto> productMapper;

    public BeanUtilsMapper() {
        this.productMapper = (source, target) -> this.wrap("name", source.getName()).accept(target);
        this.orderMapper = (source, target) -> {
            this.wrap("customerName", source.getCustomer().getName()).accept(target);
            this.wrap("shippingStreetAddress", source.getCustomer().getShippingAddress().getStreet()).accept(target);
            this.wrap("shippingCity", source.getCustomer().getShippingAddress().getCity()).accept(target);
            this.wrap("billingStreetAddress", source.getCustomer().getBillingAddress().getStreet()).accept(target);
            this.wrap("billingCity", source.getCustomer().getBillingAddress().getCity()).accept(target);
            this.wrap("products", source.getProducts().stream()
                .map(p -> {
                    final ProductDto product = new ProductDto();
                    this.productMapper.accept(p, product);
                    return product;
                })
                .collect(Collectors.toList())).accept(target);
        };
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        final OrderDto target = new OrderDto();
        this.orderMapper.accept(source, target);
        return target;
    }

    private <S, T> Consumer<T> wrap(final String propertyName, final S source) {
        return target -> {
            try {
                BeanUtils.copyProperty(target, propertyName, source);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                throw new IllegalArgumentException(ex);
            }
        };
    }
}
