/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
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
            .setApplyStrictMappingConvention(false)
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
