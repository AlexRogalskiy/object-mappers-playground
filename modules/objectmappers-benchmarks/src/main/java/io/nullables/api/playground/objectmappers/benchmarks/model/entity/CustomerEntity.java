package io.nullables.api.playground.objectmappers.benchmarks.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    private String name;
    private AddressEntity shippingAddress;
    private AddressEntity billingAddress;
}
