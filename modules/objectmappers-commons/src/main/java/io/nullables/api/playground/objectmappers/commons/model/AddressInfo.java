package io.nullables.api.playground.objectmappers.commons.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressInfo implements Serializable {
    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -6518611464972728811L;

    /**
     * Default address info ID
     */
    private Long id;
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
