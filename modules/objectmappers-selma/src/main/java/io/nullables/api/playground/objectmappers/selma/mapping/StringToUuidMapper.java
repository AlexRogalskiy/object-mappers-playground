package io.nullables.api.playground.objectmappers.selma.mapping;

import java.util.UUID;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToString;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;

public class StringToUuidMapper {

    public UUID stringToUuid(final String value) {
        return convertToUuid(value);
    }

    public String uuidToString(final UUID value) {
        return convertToString(value);
    }
}
