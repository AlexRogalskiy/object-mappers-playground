package io.nullables.api.playground.objectmappers.smooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Date creationDate;
    private Long number;
    private Status status;
    private Supplier supplier;
    private List<Item> items;
}
