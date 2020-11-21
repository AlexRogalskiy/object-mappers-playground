package io.nullables.api.playground.objectmappers.commons.utils;

import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@UtilityClass
public class StringUtils {

    @Nonnull
    public Integer[] convertToIntegerArray(final String... value) {
        return Optional.ofNullable(value).map(Arrays::stream).orElse(Stream.empty()).map(Integer::valueOf)
                        .toArray(Integer[]::new);
    }

    @Nonnull
    public String[] convertToStringArray(final Integer... value) {
        return Optional.ofNullable(value).map(Arrays::stream).orElse(Stream.empty()).map(String::valueOf)
                        .toArray(String[]::new);
    }

    @Nullable
    public UUID convertToUuid(final String value) {
        return Optional.ofNullable(value).map(UUID::fromString).orElse(null);
    }

    @Nullable
    public String convertToString(final UUID value) {
        return Optional.ofNullable(value).map(UUID::toString).orElse(null);
    }

    @Nullable
    public String notEmptyOrNull(final String value) {
        return Optional.ofNullable(value).filter(org.apache.commons.lang3.StringUtils::isNotEmpty).orElse(null);
    }
}
