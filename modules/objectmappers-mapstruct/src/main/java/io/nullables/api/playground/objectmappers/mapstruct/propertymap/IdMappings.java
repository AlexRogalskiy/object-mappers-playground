package io.nullables.api.playground.objectmappers.mapstruct.propertymap;

import org.mapstruct.Named;

import java.util.Optional;
import java.util.UUID;

@Named("IdTranslator")
public class IdMappings {

    @Named("IdToUuid")
    public UUID convertIdToUuid(final String id) {
        return Optional.ofNullable(id).map(UUID::fromString).orElse(null);
    }

    @Named("UuidToId")
    public String convertUuidToId(final UUID uuid) {
        return Optional.ofNullable(uuid).map(UUID::toString).orElse(null);
    }
}
