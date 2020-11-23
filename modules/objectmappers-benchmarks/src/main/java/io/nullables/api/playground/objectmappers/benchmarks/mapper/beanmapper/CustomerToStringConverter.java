package io.nullables.api.playground.objectmappers.benchmarks.mapper.beanmapper;

import io.beanmapper.core.converter.SimpleBeanConverter;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.CustomerEntity;

public class CustomerToStringConverter extends SimpleBeanConverter<CustomerEntity, String> {

    /**
     * Construct a new bean converter, manually declaring the source and target class.
     */
    public CustomerToStringConverter() {
        super(CustomerEntity.class, String.class);
    }

    @Override
    public String doConvert(final CustomerEntity value) {
        return value.getName();
    }
}
