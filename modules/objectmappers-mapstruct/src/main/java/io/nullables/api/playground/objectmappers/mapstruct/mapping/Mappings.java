package io.nullables.api.playground.objectmappers.mapstruct.mapping;

import org.mapstruct.Named;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.*;

public class Mappings {

    @Named("IdTranslator")
    public static class IdMappings {

        @Named("IdToUuid")
        public UUID convertIdToUuid(final String id) {
            return convertToUuid(id);
        }

        @Named("UuidToId")
        public String convertUuidToId(final UUID uuid) {
            return convertToString(uuid);
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
        return convertToIntegerArray(value);
    }

    @Decode
    public String[] decode(final Integer[] value) {
        return convertToStringArray(value);
    }
}
