package io.nullables.api.playground.objectmappers.smooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String code;
    private Double price;
    private Integer quantity;
}
