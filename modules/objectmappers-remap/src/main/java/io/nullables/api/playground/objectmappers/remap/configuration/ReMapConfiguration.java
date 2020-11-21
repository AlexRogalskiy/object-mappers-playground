package io.nullables.api.playground.objectmappers.remap.configuration;

import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;

import java.math.BigDecimal;

public class ReMapConfiguration {

    public Mapper<AddressDto, AddressEntity> addressMapper() {
        return Mapping.from(AddressDto.class).to(AddressEntity.class).replace(AddressDto::getId, AddressEntity::getId)
                        .with(StringUtils::convertToUuid).replace(AddressDto::getCity, AddressEntity::getCity)
                        .with(StringUtils::notEmptyOrNull).replace(AddressDto::getCountry, AddressEntity::getCountry)
                        .with(StringUtils::notEmptyOrNull).mapper();
    }

    public Mapper<DeliveryDto, DeliveryEntity> deliveryMapper() {
        return Mapping.from(DeliveryDto.class).to(DeliveryEntity.class).useMapper(this.addressMapper())
                        .replace(DeliveryDto::getCodes, DeliveryEntity::getCodes)
                        .with(StringUtils::convertToIntegerArray).replace(DeliveryDto::getId, DeliveryEntity::getId)
                        .with(StringUtils::convertToUuid)
                        .replace(DeliveryDto::getShippableDue, DeliveryEntity::getShippableDue)
                        .with(DateUtils::convertToLocalDateTime)
                        .replace(DeliveryDto::getDiscount, DeliveryEntity::getDiscount)
                        .withSkipWhenNull(BigDecimal::new).mapper();
    }
}
