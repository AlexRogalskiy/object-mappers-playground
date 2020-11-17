package io.nullables.api.playground.objectmappers.commons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {
    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -6518611464972728811L;

    /**
     * Address identifier
     */
    private String id;
    /**
     * City name
     */
    private String city;
    /**
     * Country name
     */
    private String country;
    /**
     * State/province name
     */
    private String stateOrProvince;
    /**
     * Postal code
     */
    private String postalCode;
    /**
     * Street name
     */
    private String street;
}
