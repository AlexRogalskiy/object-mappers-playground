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
     * Default delivery info ID
     */
    private String id;
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
    private String discount;
    /**
     * Default delivery status
     */
    private DeliveryStatus status;
    /**
     * Default address info {@link AddressDto} collection {@link List}
     */
    @Singular("address")
    private List<AddressDto> addresses;
    /**
     * Default types
     */
    private String[] codes;
}
