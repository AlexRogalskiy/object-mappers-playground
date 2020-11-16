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
     * Default address info ID
     */
    private String id;
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
