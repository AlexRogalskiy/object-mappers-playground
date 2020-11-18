package io.nullables.api.playground.objectmappers.benchmarks.mapper.converter;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.CustomerEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public final class ConverterMapper implements OrderMapper {

    @Override
    public OrderDto map(final OrderEntity source) {
        final OrderDto target = new OrderDto();
        final CustomerEntity customer = source.getCustomer();
        if (customer != null) {
            target.setCustomerName(customer.getName());
            this.mapBillingAddress(target, customer.getBillingAddress());
            this.mapShippingAddress(target, customer.getShippingAddress());
        }
        this.mapProducts(source, target);
        return target;
    }

    private void mapShippingAddress(final OrderDto target, final AddressEntity shippingAddress) {
        if (shippingAddress != null) {
            target.setShippingCity(shippingAddress.getCity());
            target.setShippingStreetAddress(shippingAddress.getStreet());
        }
    }

    private void mapBillingAddress(final OrderDto target, final AddressEntity billingAddress) {
        if (billingAddress != null) {
            target.setBillingCity(billingAddress.getCity());
            target.setBillingStreetAddress(billingAddress.getStreet());
        }
    }

    private void mapProducts(final OrderEntity source, final OrderDto target) {
        if (source.getProducts() == null) {
            return;
        }
        final List<ProductDto> targetProducts = new ArrayList<ProductDto>(source.getProducts().size());
        for (final ProductEntity product : source.getProducts()) {
            targetProducts.add(new ProductDto(product.getName()));
        }
        target.setProducts(targetProducts);
    }
}
