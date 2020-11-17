package io.nullables.api.playground.objectmappers.mapstruct.mappings;

import org.mapstruct.Named;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

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
    public @interface Decode {
    }

    @Code
    public Integer[] code(final String[] value) {
        return Arrays.stream(value)
            .map(Integer::valueOf)
            .toArray(Integer[]::new);
    }

    @Decode
    public String[] decode(final Integer[] value) {
        return Arrays.stream(value)
            .map(Object::toString)
            .toArray(String[]::new);
    }
}
