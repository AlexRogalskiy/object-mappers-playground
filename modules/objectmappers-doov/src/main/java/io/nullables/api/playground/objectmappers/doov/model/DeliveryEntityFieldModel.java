package io.nullables.api.playground.objectmappers.doov.model;

import io.doov.core.dsl.runtime.RuntimeField;
import io.doov.core.dsl.runtime.RuntimeFieldRegistry;
import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static io.doov.core.dsl.runtime.FieldChainBuilder.from;
import static io.nullables.api.playground.objectmappers.doov.enumeration.DeliveryEntityFieldType.*;

public class DeliveryEntityFieldModel extends RuntimeFieldRegistry<DeliveryEntity> {

    /**
     * Collection of {@link DeliveryEntity} {@link RuntimeField}s
     */
    private static final List<RuntimeField<DeliveryEntity, Object>> ALL = new ArrayList<>();

    public static final RuntimeField<DeliveryEntity, UUID> ID_TARGET = from(DeliveryEntity.class, ID)
        .readable("delivery identifier")
        .field(DeliveryEntity::getId, DeliveryEntity::setId, UUID.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, Integer> TYPE_TARGET = from(DeliveryEntity.class, TYPE)
        .readable("delivery type")
        .field(DeliveryEntity::getType, DeliveryEntity::setType, Integer.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, String> DESCRIPTION_TARGET = from(DeliveryEntity.class, DESCRIPTION)
        .readable("delivery description")
        .field(DeliveryEntity::getDescription, DeliveryEntity::setDescription, String.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, String> GID_TARGET = from(DeliveryEntity.class, GID)
        .readable("delivery globa identifier")
        .field(DeliveryEntity::getGid, DeliveryEntity::setGid, String.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, Date> CREATED_TARGET = from(DeliveryEntity.class, CREATE_AT)
        .readable("delivery created date")
        .field(DeliveryEntity::getCreatedAt, DeliveryEntity::setCreatedAt, Date.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, Date> UPDATED_TARGET = from(DeliveryEntity.class, UPDATE_AT)
        .readable("delivery update date")
        .field(DeliveryEntity::getUpdatedAt, DeliveryEntity::setUpdatedAt, Date.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, LocalDateTime> SHIPPABLE_TARGET = from(DeliveryEntity.class, SHIPPABLE_DUE)
        .readable("delivery shippable date")
        .field(DeliveryEntity::getShippableDue, DeliveryEntity::setShippableDue, LocalDateTime.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, Double> BALANCE_TARGET = from(DeliveryEntity.class, BALANCE)
        .readable("delivery balance")
        .field(DeliveryEntity::getBalance, DeliveryEntity::setBalance, Double.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, BigDecimal> DISCOUNT_TARGET = from(DeliveryEntity.class, DISCOUNT)
        .readable("delivery discount")
        .field(DeliveryEntity::getDiscount, DeliveryEntity::setDiscount, BigDecimal.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, DeliveryStatus> STATUS_TARGET = from(DeliveryEntity.class, STATUS)
        .readable("delivery status")
        .field(DeliveryEntity::getStatus, DeliveryEntity::setStatus, DeliveryStatus.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, List> ADDRESSES_TARGET = from(DeliveryEntity.class, ADDRESSES)
        .readable("delivery addresses")
        .field(DeliveryEntity::getAddresses, DeliveryEntity::setAddresses, List.class)
        .register(ALL);
    public static final RuntimeField<DeliveryEntity, Integer[]> CODES_TARGET = from(DeliveryEntity.class, CODES)
        .readable("delivery codes")
        .field(DeliveryEntity::getCodes, DeliveryEntity::setCodes, Integer[].class)
        .register(ALL);

    /**
     * Default private {@link DeliveryEntityFieldModel} constructor
     */
    private DeliveryEntityFieldModel() {
        super(ALL);
    }

    @Nonnull
    public static DeliveryEntityFieldModel newInstance() {
        return new DeliveryEntityFieldModel();
    }
}
