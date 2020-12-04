package io.nullables.api.playground.objectmappers.doov.enumeration;

import io.doov.core.FieldId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AddressEntityFieldType implements FieldId {
    ID("id"),
    CITY("city"),
    COUNTRY("country"),
    STATE("stateOrProvince"),
    POSTAL_CODE("postalCode"),
    STREET("street");

    private final String name;

    @Override
    public String code() {
        return this.getName();
    }
}
