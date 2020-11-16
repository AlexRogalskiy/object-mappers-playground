package io.nullables.api.playground.objectmappers.modelmapper.propertymap;

import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.modelmapper.converter.StringToIntegerArrayConverter;
import io.nullables.api.playground.objectmappers.modelmapper.converter.StringToUuidConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;

/**
 * {@link DeliveryDto} to {@link DeliveryEntity} {@link PropertyMap} binding configuration
 */
@RequiredArgsConstructor
public class DeliveryDtoToDeliveryEntityPropertyMap extends PropertyMap<DeliveryDto, DeliveryEntity> {

    private final StringToUuidConverter stringToUuidConverter = new StringToUuidConverter();
    private final StringToIntegerArrayConverter stringToIntegerArrayConverter = new StringToIntegerArrayConverter();

    /**
     * {@link DeliveryEntity} {@link PropertyMap} configuration
     */
    @Override
    protected void configure() {
        // mapping destination properties
        this.map(this.source.getAddresses()).setAddresses(null);
        this.map(this.source.getCreatedAt()).setCreatedAt(null);
        this.map(this.source.getDescription()).setDescription(null);
        this.map(this.source.getDiscount()).setDiscount(null);
        this.map(this.source.getGid()).setGid(null);
        this.map(this.source.getStatus()).setStatus(null);
        this.map(this.source.getType()).setType(null);
        this.map(this.source.getUpdatedAt()).setUpdatedAt(null);

        this.map().setBalance(this.source.getBalance());

        // mapping destination properties
        this.using(this.stringToUuidConverter).map(this.source.getId()).setId(null);
        this.using(this.stringToIntegerArrayConverter).map(this.source.getCodes()).setCodes(null);
    }
}
