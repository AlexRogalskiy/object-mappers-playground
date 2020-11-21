package io.nullables.api.playground.objectmappers.orika.converter;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.util.UUID;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToString;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;

public class StringToUuidConverter extends BidirectionalConverter<String, UUID> {

    @Override
    public UUID convertTo(final String source, final Type<UUID> destinationType, final MappingContext mappingContext) {
        return convertToUuid(source);
    }

    @Override
    public String convertFrom(final UUID source, final Type<String> destinationType,
                    final MappingContext mappingContext) {
        return convertToString(source);
    }
}
