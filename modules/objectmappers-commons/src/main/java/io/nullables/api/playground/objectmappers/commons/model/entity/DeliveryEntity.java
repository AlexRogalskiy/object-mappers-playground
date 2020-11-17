package io.nullables.api.playground.objectmappers.commons.model.entity;

import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity implements Serializable {
    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 6995213010065919507L;

    /**
     * Delivery identifier
     */
    private UUID id;
    /**
     * Delivery type
     */
    private Integer type;
    /**
     * Description/comments
     */
    private String description;
    /**
     * Delivery Global ID
     */
    private String gid;
    /**
     * Created timestamp
     */
    private Date createdAt;
    /**
     * Updated timestamp
     */
    private Date updatedAt;
    /**
     * Delivery shippable due timestamp
     */
    private LocalDateTime shippableDue;
    /**
     * Balance
     */
    private double balance;
    /**
     * Discount
     */
    private BigDecimal discount;
    /**
     * Delivery status
     */
    private DeliveryStatus status;
    /**
     * {@link List} collection of {@link AddressEntity}s
     */
    @Singular("address")
    private List<AddressEntity> addresses;
    /**
     * Delivery types
     */
    private Integer[] codes;
}
