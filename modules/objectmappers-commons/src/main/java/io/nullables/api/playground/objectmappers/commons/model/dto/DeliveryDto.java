/**
 * Object Mappers GNU GPL License Agreement
 *
 * <p>Copyright (c) 2020 Nullables, Inc.
 *
 * <p>This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * <p>You should have received a copy of the GNU General Public License along with this program. If
 * not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.commons.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto implements Serializable {
  /** Default explicit serialVersionUID for interoperability */
  private static final long serialVersionUID = 8170421693292671905L;

  /** Delivery identifier */
  private String id;
  /** Delivery type */
  private Integer type;
  /** Description/comments */
  private String description;
  /** Delivery Global ID */
  private String gid;
  /** Created timestamp */
  private Date createdAt;
  /** Updated timestamp */
  private Date updatedAt;
  /** Delivery shippable due timestamp */
  private String shippableDue;
  /** Balance */
  private double balance;
  /** Discount */
  private String discount;
  /** Delivery status */
  private DeliveryStatus status;
  /** {@link List} collection of {@link AddressDto}s */
  @Singular("address")
  private List<AddressDto> addresses;
  /** Delivery types */
  private String[] codes;
}
