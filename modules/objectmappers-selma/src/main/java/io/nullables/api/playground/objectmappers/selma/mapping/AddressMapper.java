package io.nullables.api.playground.objectmappers.selma.mapping;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL,
                withCustomFields = {@Field(value = {"id", "id"}, withCustom = StringToUuidMapper.class),
                                @Field({"city", "city"}), @Field({"country", "country"}),
                                @Field({"stateOrProvince", "stateOrProvince"}), @Field({"street", "street"})})
public interface AddressMapper {
    /**
     * Returns converted {@link AddressEntity} by input {@link AddressDto}
     *
     * @param in initial input {@link AddressDto} to convert from
     * @return converted {@link AddressEntity}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    AddressEntity toAddressEntity(final AddressDto in);

    /**
     * Returns converted {@link AddressDto} by input {@link AddressEntity} and {@link AddressDto}
     *
     * @param in initial input {@link AddressEntity} to convert from
     * @return converted {@link AddressDto}
     */
    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    AddressDto toAddressDto(final AddressEntity in);
}
