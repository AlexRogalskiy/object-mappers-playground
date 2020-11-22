package io.nullables.api.playground.objectmappers.beanmapper.configuration;

import io.beanmapper.BeanMapper;
import io.beanmapper.config.BeanMapperBuilder;
import io.beanmapper.core.collections.CollectionHandler;
import io.beanmapper.core.converter.BeanConverter;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class BeanMapperConfigBuilder {

    private final BeanMapperBuilder mapperBuilder;

    private BeanMapperConfigBuilder() {
        this.mapperBuilder = new BeanMapperBuilder()
            .withoutDefaultConverters()
            .setUseNullValue();
    }

    public static BeanMapperConfigBuilder newBuilder() {
        return new BeanMapperConfigBuilder();
    }

    public BeanMapperConfigBuilder withConverter(final BeanConverter converter) {
        this.mapperBuilder.addConverter(converter);
        return this;
    }

    public BeanMapperConfigBuilder withCollectionHandler(final CollectionHandler<?> collectionHandler) {
        this.mapperBuilder.addCollectionHandler(collectionHandler);
        return this;
    }

    public BeanMapperConfigBuilder withSourceFields(final String... includeSourceFields) {
        this.mapperBuilder.downsizeSource(Arrays.stream(includeSourceFields).collect(Collectors.toList()));
        return this;
    }

    public BeanMapperConfigBuilder withTargetFields(final String... includeTargetFields) {
        this.mapperBuilder.downsizeTarget(Arrays.stream(includeTargetFields).collect(Collectors.toList()));
        return this;
    }

    public BeanMapper build() {
        return this.mapperBuilder.build();
    }
}
