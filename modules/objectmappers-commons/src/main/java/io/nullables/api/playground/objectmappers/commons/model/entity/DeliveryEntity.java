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
package io.nullables.api.playground.objectmappers.commons.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
public class DeliveryEntity implements Serializable {
  /** Default explicit serialVersionUID for interoperability */
  private static final long serialVersionUID = 6995213010065919507L;

  /** Delivery identifier */
  private UUID id;
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
  private LocalDateTime shippableDue;
  /** Balance */
  private double balance;
  /** Discount */
  private BigDecimal discount;
  /** Delivery status */
  private DeliveryStatus status;
  /** {@link List} collection of {@link AddressEntity}s */
  @Singular("address")
  private List<AddressEntity> addresses;
  /** Delivery types */
  private Integer[] codes;
}
