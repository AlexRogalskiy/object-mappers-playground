package io.nullables.api.playground.objectmappers.mapstruct.mapper;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.mapstruct.mappings.Mappings;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
//    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
//    config = IgnoreUnmappedConfig.class,
    uses = {Mappings.class, Mappings.IdMappings.class}
)
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    @Mapping(source = "id", target = "id", qualifiedByName = {"IdTranslator", "IdToUuid"})
    @Mapping(source = "codes", target = "codes", qualifiedBy = Mappings.Code.class)
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "updatedAt", source = "updatedAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
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
    @Mapping(source = "codes", target = "codes", qualifiedBy = Mappings.Decode.class)
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
