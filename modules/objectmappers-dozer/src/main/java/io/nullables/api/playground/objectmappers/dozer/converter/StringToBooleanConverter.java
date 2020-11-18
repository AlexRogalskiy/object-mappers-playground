package io.nullables.api.playground.objectmappers.dozer.converter;

import com.github.dozermapper.core.DozerConverter;

public class StringToBooleanConverter extends DozerConverter<String, Boolean> {

    public StringToBooleanConverter() {
        super(String.class, Boolean.class);
    }

    public Boolean convertTo(final String source, final Boolean destination) {
        if ("yes".equals(source)) {
            return Boolean.TRUE;
        } else if ("no".equals(source)) {
            return Boolean.FALSE;
        }
        throw new IllegalStateException("Unknown value!");
    }

    public String convertFrom(final Boolean source, final String destination) {
        if (Boolean.TRUE.equals(source)) {
            return "yes";
        } else if (Boolean.FALSE.equals(source)) {
            return "no";
        }
        throw new IllegalStateException("Unknown value!");
    }
}
