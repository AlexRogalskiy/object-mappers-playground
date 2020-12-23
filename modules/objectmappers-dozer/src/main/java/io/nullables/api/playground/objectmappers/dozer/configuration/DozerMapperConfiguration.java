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
package io.nullables.api.playground.objectmappers.dozer.configuration;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_PATTERN;

import javax.annotation.Nonnull;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.classmap.RelationshipType;
import com.github.dozermapper.core.events.EventListener;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.FieldsMappingOptions;
import com.github.dozermapper.core.loader.api.TypeMappingOption;
import com.github.dozermapper.core.loader.api.TypeMappingOptions;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.dozer.converter.StringToIntegerArrayConvertor;
import io.nullables.api.playground.objectmappers.dozer.converter.StringToLocaleDateTimeConvertor;
import io.nullables.api.playground.objectmappers.dozer.converter.StringToUuidConvertor;
import lombok.experimental.UtilityClass;

public final class DozerMapperConfiguration {

    private final DozerBeanMapperBuilder mapperBuilder;

    private DozerMapperConfiguration() {
        this.mapperBuilder = DozerBeanMapperBuilder.create();
    }

    @Nonnull
    public static DozerMapperConfiguration newBuilder() {
        return new DozerMapperConfiguration();
    }

    public DozerBeanMapperBuilder configureMapper(final String... mappingFileUrls) {
        return this.mapperBuilder.withMappingFiles(mappingFileUrls);
    }

    public DozerBeanMapperBuilder configureListener(final EventListener eventListener) {
        return this.mapperBuilder.withEventListener(eventListener);
    }

    public DozerBeanMapperBuilder configureDeliveryMapper() {
        return this.mapperBuilder
            .withEventListener(new CustomEventListener())
            .withMappingBuilder(DozerConfiguration.ADDRESS_MAPPING)
            .withMappingBuilder(DozerConfiguration.DELIVERY_MAPPING);
    }

    public Mapper build() {
        return this.mapperBuilder.build();
    }

    @UtilityClass
    private static class DozerConfiguration {
        /**
         * Default collection of {@link TypeMappingOption}s
         */
        private static final TypeMappingOption[] TYPE_MAPPING_OPTIONS = {
            TypeMappingOptions.oneWay(), TypeMappingOptions.mapNull(),
            TypeMappingOptions.trimStrings(), TypeMappingOptions.wildcardCaseInsensitive(true),
            TypeMappingOptions.dateFormat(DATETIME_PATTERN)
        };

        /**
         * Address {@link BeanMappingBuilder} configuration
         */
        private static final BeanMappingBuilder ADDRESS_MAPPING = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                this.mapping(AddressDto.class, AddressEntity.class, TYPE_MAPPING_OPTIONS)
                    .fields(field("id").accessible(), field("id").accessible(),
                        FieldsMappingOptions.customConverter(StringToUuidConvertor.class))
                    .fields("city", "city").fields("country", "country")
                    .fields("stateOrProvince", "stateOrProvince").fields("postalCode", "postalCode")
                    .fields("street", "street");
            }
        };

        /**
         * Delivery {@link BeanMappingBuilder} configuration
         */
        private static final BeanMappingBuilder DELIVERY_MAPPING = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                this.mapping(DeliveryDto.class, DeliveryEntity.class, TYPE_MAPPING_OPTIONS)
                    .fields(field("id").accessible(), field("id").accessible(),
                        FieldsMappingOptions.customConverter(StringToUuidConvertor.class))
                    .fields("shippableDue", "shippableDue",
                        FieldsMappingOptions
                            .customConverter(StringToLocaleDateTimeConvertor.class))
                    .fields("codes", "codes", FieldsMappingOptions.oneWay(),
                        FieldsMappingOptions.hintA(String[].class),
                        FieldsMappingOptions.hintB(Integer[].class),
                        FieldsMappingOptions
                            .customConverter(StringToIntegerArrayConvertor.class),
                        FieldsMappingOptions.collectionStrategy(true,
                            RelationshipType.NON_CUMULATIVE))
                    .fields("type", "type").fields("description", "description").fields("gid", "gid")
                    .fields("createdAt", "createdAt").fields("updatedAt", "updatedAt")
                    .fields("balance", "balance").fields("discount", "discount").fields("status", "status")
                    .fields("addresses", "addresses");
            }
        };
    }
}
