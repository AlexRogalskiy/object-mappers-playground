package io.nullables.api.playground.objectmappers.dozer.converter;

import com.github.dozermapper.core.ConfigurableCustomConverter;

public class MathOperationConverter implements ConfigurableCustomConverter {

    private String param;

    @Override
    public void setParameter(final String param) {
        this.param = param;
    }

    @Override
    public Object convert(final Object destinationFieldValue,
                          final Object sourceFieldValue,
                          final Class<?> destinationClass,
                          final Class<?> sourceClass) {
        final Integer source = (Integer) sourceFieldValue;
        final Integer destination = (Integer) destinationFieldValue;
        if ("+".equals(this.param)) {
            return destination + source;
        }
        if ("-".equals(this.param)) {
            return destination - source;
        }
        return null;
    }
}
