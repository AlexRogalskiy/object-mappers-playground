package io.nullables.api.playground.objectmappers.benchmarks.model.entity;

import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class OrderFactory {

    @Nonnull
    public static OrderEntity buildOrder() {
        final OrderEntity entity = new OrderEntity();
        entity.setCustomer(buildCustomer());
        entity.setProducts(buildProducts());
        return entity;
    }

    @Nonnull
    public static CustomerEntity buildCustomer() {
        final CustomerEntity entity = new CustomerEntity();
        entity.setName("Joe Smith");
        entity.setBillingAddress(buildBillingAddress());
        entity.setShippingAddress(buildShippingAddress());
        return entity;
    }

    @Nonnull
    public static AddressEntity buildBillingAddress() {
        final AddressEntity entity = new AddressEntity();
        entity.setStreet("1234 Market Street");
        entity.setCity("San Fran");
        return entity;
    }

    @Nonnull
    public static AddressEntity buildShippingAddress() {
        final AddressEntity entity = new AddressEntity();
        entity.setStreet("1234 West Townsend");
        entity.setCity("Boston");
        return entity;
    }

    @Nonnull
    public static List<ProductEntity> buildProducts() {
        return Arrays.asList(new ProductEntity("socks"), new ProductEntity("shoes"));
    }
}
