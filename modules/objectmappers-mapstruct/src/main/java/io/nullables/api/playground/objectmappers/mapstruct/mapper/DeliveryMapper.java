package io.nullables.api.playground.objectmappers.mapstruct.mapper;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.mapstruct.mappings.Mappings;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {Mappings.class, Mappings.IdMappings.class})
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    @Mapping(source = "id", target = "id", qualifiedByName = {"IdTranslator", "IdToUuid"})
    @Mapping(source = "addresses", target = "addresses", qualifiedBy = Mappings.Address.class)
    @Mapping(source = "codes", target = "codes", qualifiedBy = Mappings.Code.class)
    @Named("toDeliveryEntity")
    DeliveryEntity deliveryDtoToDeliveryEntity(final DeliveryDto addressDto);

    @Mapping(source = "id", target = "id", qualifiedByName = {"IdTranslator", "UuidToId"})
    @InheritInverseConfiguration
    AddressDto deliveryEntityToDeliveryDto(final AddressEntity addressEntity);

    @IterableMapping(qualifiedByName = "toDeliveryEntity")
    List<DeliveryEntity> map(final List<DeliveryDto> addressDtos);
}
