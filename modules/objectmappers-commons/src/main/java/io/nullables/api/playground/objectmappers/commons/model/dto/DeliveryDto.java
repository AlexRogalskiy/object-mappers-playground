package io.nullables.api.playground.objectmappers.commons.model.dto;

import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto implements Serializable {
    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 8170421693292671905L;

    /**
     * Delivery identifier
     */
    private String id;
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
    private String shippableDue;
    /**
     * Balance
     */
    private double balance;
    /**
     * Discount
     */
    private String discount;
    /**
     * Delivery status
     */
    private DeliveryStatus status;
    /**
     * {@link List} collection of {@link AddressDto}s
     */
    @Singular("address")
    private List<AddressDto> addresses;
    /**
     * Delivery types
     */
    private String[] codes;
}
