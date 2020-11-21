package io.nullables.api.playground.objectmappers.orika.mapping;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToString;
import static io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid;

public class IdToUuidCustomMapper extends CustomMapper<AddressDto, AddressEntity> {

    @Override
    public void mapAtoB(final AddressDto a, final AddressEntity b, final MappingContext context) {
        b.setId(convertToUuid(a.getId()));
    }

    @Override
    public void mapBtoA(final AddressEntity b, final AddressDto a, final MappingContext context) {
        a.setId(convertToString(b.getId()));
    }
}
