package io.nullables.api.playground.objectmappers.orika.mapping;

import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime;
import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToString;

public class ShippableDateTimeCustomMapper extends CustomMapper<DeliveryDto, DeliveryEntity> {

    @Override
    public void mapAtoB(final DeliveryDto a,
                        final DeliveryEntity b,
                        final MappingContext context) {
        b.setShippableDue(convertToLocalDateTime(a.getShippableDue()));
    }

    @Override
    public void mapBtoA(final DeliveryEntity b,
                        final DeliveryDto a,
                        final MappingContext context) {
        a.setShippableDue(convertToString(b.getShippableDue()));
    }
}
