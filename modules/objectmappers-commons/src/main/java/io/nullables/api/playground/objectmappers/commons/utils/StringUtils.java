package io.nullables.api.playground.objectmappers.commons.utils;

import lombok.experimental.UtilityClass;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@UtilityClass
public class StringUtils {

    public Integer[] convertToIntegerArray(final String... value) {
        return Arrays.stream(value)
            .map(Integer::valueOf)
            .toArray(Integer[]::new);
    }

    public String[] convertToStringArray(final Integer... value) {
        return Arrays.stream(value)
            .map(Object::toString)
            .toArray(String[]::new);
    }

    @Nullable
    public UUID convertToUuid(final String value) {
        return Optional.ofNullable(value)
            .map(UUID::fromString)
            .orElse(null);
    }

    @Nullable
    public String convertToString(final UUID value) {
        return Optional.ofNullable(value)
            .map(UUID::toString)
            .orElse(null);
    }
}
