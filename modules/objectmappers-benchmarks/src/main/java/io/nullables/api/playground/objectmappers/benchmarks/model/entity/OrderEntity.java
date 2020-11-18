package io.nullables.api.playground.objectmappers.benchmarks.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    private CustomerEntity customer;
    private List<ProductEntity> products;
}
