package io.nullables.api.playground.objectmappers.mapstruct.configuration;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.mapstruct.mapping.BaseMappings;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_PATTERN;

@Mapper(
    config = IgnoreUnmappedConfiguration.class,
    uses = {BaseMappings.class, BaseMappings.IdMappings.class},
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface DeliveryMapperConfiguration {

    DeliveryMapperConfiguration INSTANCE = Mappers.getMapper(DeliveryMapperConfiguration.class);

    @Mapping(source = "id", target = "id", qualifiedByName = {"IdTranslator", "IdToUuid"})
    @Mapping(source = "codes", target = "codes", qualifiedBy = BaseMappings.Code.class)
    @Mapping(target = "shippableDue", source = "shippableDue", dateFormat = DATETIME_PATTERN)
    @Named("toDeliveryEntity")
    DeliveryEntity deliveryDtoToDeliveryEntity(final DeliveryDto deliveryDto);

    @Mapping(
        source = "id",
        target = "id",
        qualifiedByName = {"IdTranslator", "IdToUuid"}
    )
    @Mapping(source = "postalCode", target = "postalCode", qualifiedByName = "postalCodeToSanitize")
    @Named("toAddressEntity")
    AddressEntity addressDtoToAddressEntity(final AddressDto addressDto);

    @Mapping(
        source = "id",
        target = "id",
        qualifiedByName = {"IdTranslator", "UuidToId"},
        defaultExpression = "java(java.util.UUID.randomUUID().toString())"
    )
    @InheritInverseConfiguration
    AddressDto addressEntityToAddressDto(final AddressEntity addressEntity);

    @Mapping(
        target = "id",
        source = "id",
        qualifiedByName = {"IdTranslator", "UuidToId"},
        defaultExpression = "java(java.util.UUID.randomUUID().toString())"
    )
    @Mapping(source = "codes", target = "codes", qualifiedBy = BaseMappings.Decode.class)
    @InheritInverseConfiguration
    DeliveryDto deliveryEntityToDeliveryDto(final DeliveryEntity deliveryEntity);

    @IterableMapping(qualifiedByName = "toDeliveryEntity")
    List<DeliveryEntity> mapDeliveryDtoToEntityList(final List<DeliveryDto> deliveryDtos);

    @IterableMapping(qualifiedByName = "toAddressEntity")
    List<AddressEntity> mapAddressDtoToEntityList(final List<AddressDto> addressDtos);

    @Named("postalCodeToUpperCase")
    default String convertPostalCodeToUpperCase(final String postalCode) {
        return String.valueOf(postalCode).toUpperCase();
    }

    @Named("postalCodeToSanitize")
    default String convertPostalCodeToSanitize(final String postalCode) {
        return String.valueOf(postalCode).replaceAll("[^A-Za-z0-9]", "");
    }
}
