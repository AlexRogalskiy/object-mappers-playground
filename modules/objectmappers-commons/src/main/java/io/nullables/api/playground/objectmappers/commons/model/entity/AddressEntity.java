package io.nullables.api.playground.objectmappers.commons.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity implements Serializable {
    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -1880066107464593905L;

    /**
     * Default address info ID
     */
    private UUID id;
    /**
     * Default city name
     */
    private String city;
    /**
     * Default country name
     */
    private String country;
    /**
     * Default state/province name
     */
    private String stateOrProvince;
    /**
     * Default postal code
     */
    private String postalCode;
    /**
     * Default street name
     */
    private String street;
}
