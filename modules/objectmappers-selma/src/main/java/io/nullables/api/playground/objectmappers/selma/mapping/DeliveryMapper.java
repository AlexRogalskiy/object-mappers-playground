package io.nullables.api.playground.objectmappers.selma.mapping;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;

import static fr.xebia.extras.selma.CollectionMappingStrategy.ALLOW_GETTER;

@Mapper(
    withIgnoreMissing = IgnoreMissing.ALL,
    withCollectionStrategy = ALLOW_GETTER,
    withCustomFields = {
        @Field(value = {"id", "id"}, withCustom = StringToUuidMapper.class),
        @Field({"type", "type"}),
        @Field({"description", "description"}),
        @Field({"gid", "gid"}),
        @Field({"createdAt", "createdAt"}),
        @Field({"updatedAt", "updatedAt"}),
        @Field(value = {"shippableDue", "shippableDue"}, withCustom = StringToLocalDateTimeMapper.class),
        @Field({"balance", "balance"}),
        @Field(value = {"discount", "discount"}, withCustom = StringToBigDecimalMapper.class),
        @Field({"status", "status"}),
        @Field({"addresses", "addresses"}),
        @Field(value = {"codes", "codes"}, withCustom = StringToIntegerArrayMapper.class)
    }
)
public interface DeliveryMapper {
    /**
     * Returns converted {@link DeliveryEntity} by input {@link DeliveryDto}
     *
     * @param in initial input {@link DeliveryDto} to convert from
     * @return converted {@link DeliveryEntity}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    DeliveryEntity toDeliveryEntity(final DeliveryDto in);

    /**
     * Returns converted {@link DeliveryDto} by input {@link DeliveryEntity} and {@link DeliveryDto}
     *
     * @param in initial input {@link DeliveryEntity} to convert from
     * @return converted {@link DeliveryDto}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    DeliveryDto toDeliveryDto(final DeliveryEntity in);
}
