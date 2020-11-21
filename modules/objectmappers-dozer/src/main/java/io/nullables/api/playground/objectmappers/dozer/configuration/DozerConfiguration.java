package io.nullables.api.playground.objectmappers.dozer.configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.classmap.RelationshipType;
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

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_PATTERN;

public class DozerConfiguration {

    private final TypeMappingOption[] TYPE_MAPPING_OPTIONS = {TypeMappingOptions.oneWay(), TypeMappingOptions.mapNull(),
                    TypeMappingOptions.trimStrings(), TypeMappingOptions.wildcardCaseInsensitive(true),
                    TypeMappingOptions.dateFormat(DATETIME_PATTERN)};

    public Mapper configureMapper(final String... mappingFileUrls) {
        return DozerBeanMapperBuilder.create().withEventListener(new CustomEventListener())
                        .withMappingFiles(mappingFileUrls).build();
    }

    public Mapper configureMapper() {
        final BeanMappingBuilder addressBuilder = new BeanMappingBuilder() {
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

        final BeanMappingBuilder deliveryBuilder = new BeanMappingBuilder() {
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
        return DozerBeanMapperBuilder.create().withEventListener(new CustomEventListener())
                        .withMappingBuilder(addressBuilder).withMappingBuilder(deliveryBuilder).build();
    }
}
