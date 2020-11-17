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
     * Address info ID
     */
    private UUID id;
    /**
     * City name
     */
    private String city;
    /**
     * Country name
     */
    private String country;
    /**
     * state/province name
     */
    private String stateOrProvince;
    /**
     * postal code
     */
    private String postalCode;
    /**
     * street name
     */
    private String street;
}
