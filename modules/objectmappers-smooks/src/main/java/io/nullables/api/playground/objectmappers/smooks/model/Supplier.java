package io.nullables.api.playground.objectmappers.smooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private String name;
    private String phoneNumber;
}
