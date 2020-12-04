package io.nullables.api.playground.objectmappers.doov.model;

import io.doov.core.dsl.runtime.RuntimeField;
import io.doov.core.dsl.runtime.RuntimeFieldRegistry;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.doov.core.dsl.runtime.FieldChainBuilder.from;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressDtoFieldType.*;
import static io.nullables.api.playground.objectmappers.doov.enumeration.AddressEntityFieldType.ID;

public class AddressEntityFieldModel extends RuntimeFieldRegistry<AddressEntity> {

    /**
     * Collection of {@link RuntimeField}s
     */
    private static final List<RuntimeField<AddressEntity, Object>> ALL = new ArrayList<>();

    /**
     * Collection of {@link AddressEntity} {@link RuntimeField}s
     */
    public static RuntimeField<AddressEntity, UUID> ID_TARGET = from(AddressEntity.class, ID)
        .readable("address identifier")
        .field(AddressEntity::getId, AddressEntity::setId, UUID.class)
        .register(ALL);
    public static RuntimeField<AddressEntity, String> CITY_TARGET = from(AddressEntity.class, CITY)
        .readable("address city")
        .field(AddressEntity::getCity, AddressEntity::setCity, String.class)
        .register(ALL);
    public static RuntimeField<AddressEntity, String> COUNTRY_TARGET = from(AddressEntity.class, COUNTRY)
        .readable("address country")
        .field(AddressEntity::getCountry, AddressEntity::setCountry, String.class)
        .register(ALL);
    public static RuntimeField<AddressEntity, String> STATE_TARGET = from(AddressEntity.class, STATE)
        .readable("address state")
        .field(AddressEntity::getStateOrProvince, AddressEntity::setStateOrProvince, String.class)
        .register(ALL);
    public static RuntimeField<AddressEntity, String> POSTAL_CODE_TARGET = from(AddressEntity.class, POSTAL_CODE)
        .readable("address postal code")
        .field(AddressEntity::getPostalCode, AddressEntity::setPostalCode, String.class)
        .register(ALL);
    public static RuntimeField<AddressEntity, String> STREET_TARGET = from(AddressEntity.class, STREET)
        .readable("address street")
        .field(AddressEntity::getStreet, AddressEntity::setStreet, String.class)
        .register(ALL);

    /**
     * Default private {@link AddressEntityFieldModel} constructor
     */
    private AddressEntityFieldModel() {
        super(ALL);
    }

    @Nonnull
    public static AddressEntityFieldModel newInstance() {
        return new AddressEntityFieldModel();
    }
}
