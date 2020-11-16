package io.nullables.api.playground.objectmappers.commons.model.entity;

import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
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
     * Default delivery info ID
     */
    private UUID id;
    /**
     * Default type
     */
    private Integer type;
    /**
     * Default description/comments
     */
    private String description;
    /**
     * Default global ID
     */
    private String gid;
    /**
     * Default created timestamp
     */
    private Date createdAt;
    /**
     * Default updated timestamp
     */
    private Date updatedAt;
    /**
     * Default balance
     */
    private double balance;
    /**
     * Default discount
     */
    private BigDecimal discount;
    /**
     * Default delivery status
     */
    private DeliveryStatus status;
    /**
     * Default address info {@link AddressDto} collection {@link List}
     */
    @Singular("address")
    private List<AddressEntity> addresses;
    /**
     * Default types
     */
    private Integer[] codes;
}
