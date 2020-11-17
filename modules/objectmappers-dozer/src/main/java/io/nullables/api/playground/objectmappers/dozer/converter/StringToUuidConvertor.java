package io.nullables.api.playground.objectmappers.dozer.converter;

import com.github.dozermapper.core.DozerConverter;

import java.util.UUID;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToString;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;

public class StringToUuidConvertor extends DozerConverter<String, UUID> {

    public StringToUuidConvertor() {
        super(String.class, UUID.class);
    }

    @Override
    public UUID convertTo(final String s, final UUID uuid) {
        return convertToUuid(s);
    }

    @Override
    public String convertFrom(final UUID uuid, final String s) {
        return convertToString(uuid);
    }
}
