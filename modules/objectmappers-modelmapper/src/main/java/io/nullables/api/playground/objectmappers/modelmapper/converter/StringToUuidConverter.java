package io.nullables.api.playground.objectmappers.modelmapper.converter;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.UUID;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;

/**
 * {@link String} to {@link UUID} {@link Converter} implementation
 */
@Slf4j
public class StringToUuidConverter implements Converter<String, UUID> {
    /**
     * Returns converted {@link UUID} from {@link String} by input {@link MappingContext}
     *
     * @param context - initial input {@link MappingContext} to operate by
     * @return converted {@link UUID}
     */
    @Override
    public UUID convert(final MappingContext<String, UUID> context) {
        try {
            return convertToUuid(context.getSource());
        } catch (RuntimeException ex) {
            log.error("Cannot convert input source: {} to UUID format", context.getSource(), ex);
            return null;
        }
    }
}
