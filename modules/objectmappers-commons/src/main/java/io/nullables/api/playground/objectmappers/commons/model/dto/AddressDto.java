/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.commons.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
