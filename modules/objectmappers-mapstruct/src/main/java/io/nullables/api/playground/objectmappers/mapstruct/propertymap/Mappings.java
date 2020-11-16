package io.nullables.api.playground.objectmappers.mapstruct.propertymap;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mappings {

    @Named("IdTranslator")
    public static class IdMappings {

        @Named("IdToUuid")
        public UUID convertIdToUuid(final String id) {
            return Optional.ofNullable(id).map(UUID::fromString).orElse(null);
        }

        @Named("UuidToId")
        public String convertUuidToId(final UUID uuid) {
            return Optional.ofNullable(uuid).map(UUID::toString).orElse(null);
        }
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Address {
    }

    @Code
    public Integer[] code(final String[] value) {
        return Arrays.stream(value)
            .map(Integer::valueOf)
            .toArray(Integer[]::new);
    }

    @Address
    public List<AddressEntity> address(final List<AddressDto> value) {
        return value.stream().map(this.mapAddressToEntity()).collect(Collectors.toList());
    }

    private Function<AddressDto, AddressEntity> mapAddressToEntity() {
        return value -> AddressEntity.builder()
            .id(UUID.fromString(value.getId()))
            .city(value.getCity())
            .country(value.getCountry())
            .postalCode(value.getPostalCode())
            .stateOrProvince(value.getStateOrProvince())
            .street(value.getStreet())
            .build();
    }
}
