package io.nullables.api.playground.objectmappers.benchmarks.model.dto;

import io.beanmapper.annotations.BeanCollection;
import io.beanmapper.annotations.BeanCollectionUsage;
import io.beanmapper.annotations.BeanProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    @BeanCollection(elementType = ProductDto.class, beanCollectionUsage = BeanCollectionUsage.CONSTRUCT)
    private List<ProductDto> products;

    @BeanProperty(name = "customer.name")
    private String customerName;

    @BeanProperty(name = "customer.shippingAddress.street")
    private String shippingStreetAddress;

    @BeanProperty(name = "customer.shippingAddress.city")
    private String shippingCity;

    @BeanProperty(name = "customer.billingAddress.street")
    private String billingStreetAddress;

    @BeanProperty(name = "customer.billingAddress.city")
    private String billingCity;
}
