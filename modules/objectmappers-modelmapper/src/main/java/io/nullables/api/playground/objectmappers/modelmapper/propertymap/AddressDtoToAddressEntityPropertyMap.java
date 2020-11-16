package io.nullables.api.playground.objectmappers.modelmapper.propertymap;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.modelmapper.converter.StringToUuidConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;

/**
 * {@link AddressDto} to {@link AddressEntity} {@link PropertyMap} binding configuration
 */
@RequiredArgsConstructor
public class AddressDtoToAddressEntityPropertyMap extends PropertyMap<AddressDto, AddressEntity> {

    private final StringToUuidConverter stringToUuidConverter = new StringToUuidConverter();

    /**
     * {@link AddressEntity} {@link PropertyMap} configuration
     */
    @Override
    protected void configure() {
        // mapping destination properties
        this.map(this.source.getCity()).setCity(null);
        this.map(this.source.getCountry()).setCountry(null);
        this.map(this.source.getPostalCode()).setPostalCode(null);
        this.map(this.source.getStateOrProvince()).setStateOrProvince(null);
        this.map(this.source.getStreet()).setStreet(null);

        // mapping destination properties
        this.using(this.stringToUuidConverter).map(this.source.getId()).setId(null);
    }
}
