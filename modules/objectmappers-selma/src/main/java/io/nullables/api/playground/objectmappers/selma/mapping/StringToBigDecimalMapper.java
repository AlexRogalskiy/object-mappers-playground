package io.nullables.api.playground.objectmappers.selma.mapping;

import java.math.BigDecimal;
import java.util.Optional;

public class StringToBigDecimalMapper {

    public BigDecimal stringToBigDecimal(final String value) {
        return Optional.ofNullable(value).map(BigDecimal::new).orElse(null);
    }

    public String bigDecimalToString(final BigDecimal value) {
        return Optional.ofNullable(value).map(BigDecimal::toString).orElse(null);
    }
}
