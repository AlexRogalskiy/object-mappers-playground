package io.nullables.api.playground.objectmappers.doov.model;

import io.doov.core.dsl.runtime.RuntimeField;
import io.doov.core.dsl.runtime.RuntimeFieldRegistry;
import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.doov.core.dsl.runtime.FieldChainBuilder.from;
import static io.nullables.api.playground.objectmappers.doov.enumeration.DeliveryDtoFieldType.*;

public class DeliveryDtoFieldModel extends RuntimeFieldRegistry<DeliveryDto> {

    /**
     * Collection of {@link DeliveryDto} {@link RuntimeField}s
     */
    private static final List<RuntimeField<DeliveryDto, Object>> ALL = new ArrayList<>();

    public static final RuntimeField<DeliveryDto, String> ID_SOURCE = from(DeliveryDto.class, ID)
        .readable("delivery identifier")
        .field(DeliveryDto::getId, DeliveryDto::setId, String.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, Integer> TYPE_SOURCE = from(DeliveryDto.class, TYPE)
        .readable("delivery type")
        .field(DeliveryDto::getType, DeliveryDto::setType, Integer.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, String> DESCRIPTION_SOURCE = from(DeliveryDto.class, DESCRIPTION)
        .readable("delivery description")
        .field(DeliveryDto::getDescription, DeliveryDto::setDescription, String.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, String> GID_SOURCE = from(DeliveryDto.class, GID)
        .readable("delivery globa identifier")
        .field(DeliveryDto::getGid, DeliveryDto::setGid, String.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, Date> CREATED_SOURCE = from(DeliveryDto.class, CREATE_AT)
        .readable("delivery created date")
        .field(DeliveryDto::getCreatedAt, DeliveryDto::setCreatedAt, Date.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, Date> UPDATED_SOURCE = from(DeliveryDto.class, UPDATE_AT)
        .readable("delivery update date")
        .field(DeliveryDto::getUpdatedAt, DeliveryDto::setUpdatedAt, Date.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, String> SHIPPABLE_SOURCE = from(DeliveryDto.class, SHIPPABLE_DUE)
        .readable("delivery shippable date")
        .field(DeliveryDto::getShippableDue, DeliveryDto::setShippableDue, String.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, Double> BALANCE_SOURCE = from(DeliveryDto.class, BALANCE)
        .readable("delivery balance")
        .field(DeliveryDto::getBalance, DeliveryDto::setBalance, Double.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, String> DISCOUNT_SOURCE = from(DeliveryDto.class, DISCOUNT)
        .readable("delivery discount")
        .field(DeliveryDto::getDiscount, DeliveryDto::setDiscount, String.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, DeliveryStatus> STATUS_SOURCE = from(DeliveryDto.class, STATUS)
        .readable("delivery status")
        .field(DeliveryDto::getStatus, DeliveryDto::setStatus, DeliveryStatus.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, List> ADDRESSES_SOURCE = from(DeliveryDto.class, ADDRESSES)
        .readable("delivery addresses")
        .field(DeliveryDto::getAddresses, DeliveryDto::setAddresses, List.class)
        .register(ALL);
    public static final RuntimeField<DeliveryDto, String[]> CODES_SOURCE = from(DeliveryDto.class, CODES)
        .readable("delivery codes")
        .field(DeliveryDto::getCodes, DeliveryDto::setCodes, String[].class)
        .register(ALL);

    /**
     * Default private {@link DeliveryDtoFieldModel} constructor
     */
    private DeliveryDtoFieldModel() {
        super(ALL);
    }

    @Nonnull
    public static DeliveryDtoFieldModel newInstance() {
        return new DeliveryDtoFieldModel();
    }
}
