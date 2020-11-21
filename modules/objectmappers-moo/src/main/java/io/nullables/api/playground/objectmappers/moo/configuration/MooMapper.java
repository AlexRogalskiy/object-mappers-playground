package io.nullables.api.playground.objectmappers.moo.configuration;

import com.codiform.moo.curry.Translate;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class MooMapper {

    public DeliveryEntity translate(final DeliveryDto value) {
        return Translate.to(DeliveryEntity.class).withVariable("id", StringUtils.convertToUuid(value.getId()))
                        .withVariable("type", value.getType()).withVariable("description", value.getDescription())
                        .withVariable("gid", value.getGid()).withVariable("createdAt", value.getCreatedAt())
                        .withVariable("updatedAt", value.getUpdatedAt())
                        .withVariable("shippableDue", DateUtils.convertToLocalDateTime(value.getShippableDue()))
                        .withVariable("balance", value.getBalance())
                        .withVariable("discount", new BigDecimal(value.getDiscount()))
                        .withVariable("status", value.getStatus())
                        .withVariable("addresses",
                                        Optional.ofNullable(value.getAddresses()).orElseGet(Collections::emptyList)
                                                        .stream().map(this::translate).collect(Collectors.toList()))
                        .withVariable("codes", StringUtils.convertToIntegerArray(value.getCodes())).from(value);
    }

    public AddressEntity translate(final AddressDto value) {
        return Translate.to(AddressEntity.class).withVariable("id", StringUtils.convertToUuid(value.getId()))
                        .withVariable("city", value.getCity()).withVariable("country", value.getCountry())
                        .withVariable("stateOrProvince", value.getStateOrProvince())
                        .withVariable("postalCode", value.getPostalCode()).withVariable("street", value.getStreet())
                        .from(value);
    }
}
