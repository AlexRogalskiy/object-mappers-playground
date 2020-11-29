/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.beancp.configuration;

import com.github.erchu.beancp.BindingOption;
import com.github.erchu.beancp.Mapper;
import com.github.erchu.beancp.MapperBuilder;
import com.github.erchu.beancp.commons.CollectionConverters;
import com.github.erchu.beancp.commons.NameBasedMapConvention;
import com.github.erchu.beancp.commons.NumberConverters;
import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.DateUtils;
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public final class BeancpMapperBuilder {

    private static final Logger log = Logger.getLogger(BeancpMapperBuilder.class.getSimpleName());

    private final MapperBuilder mapperBuilder;

    private BeancpMapperBuilder() {
        this.mapperBuilder = new MapperBuilder()
            .addMapAnyByConvention(NameBasedMapConvention.get().failIfNotAllDestinationMembersMapped())
            .addConverter(CollectionConverters.getArrayToCollection(AddressDto.class))
            .addConverter(NumberConverters.get())
            .addConverter(String.class, LocalDateTime.class, DateUtils::convertToLocalDateTime)
            .addConverter(String.class, BigDecimal.class, (Function<String, BigDecimal>) BigDecimal::new)
            .addConverter(String[].class, Integer[].class,
                (Function<String[], Integer[]>) StringUtils::convertToIntegerArray);
    }

    public static BeancpMapperBuilder newBuilder() {
        return new BeancpMapperBuilder();
    }

    public BeancpMapperBuilder withDefaultMappings() {
        this.withAddressMapper(this.addressMapper());
        return this;
    }

    @SuppressWarnings("unchecked")
    public BeancpMapperBuilder withAddressMapper(final Mapper addressMapper) {
        this.mapperBuilder.addMap(DeliveryDto.class, DeliveryEntity.class, (conf, source, destination) -> conf
            .beforeMap(mapperRef -> log.info(">>> Starting mapping of DeliveryDto (id: " + source.getId()
                + ") to DeliveryEntity by mapper " + mapperRef))
            .bind(() -> StringUtils.convertToUuid(source.getId()), destination::setId)
            .bind(source::getBalance, destination::setBalance,
                BindingOption.mapWhen(() -> Double.compare(source.getBalance(), 0) >= 0))
            .bind(source::getCreatedAt, destination::setCreatedAt)
            .bind(source::getUpdatedAt, destination::setUpdatedAt)
            .bind(source::getDescription, destination::setDescription)
            .bind(source::getGid, destination::setGid).bind(source::getStatus, destination::setStatus)
            .bind(source::getType, destination::setType)
            .bind(() -> (source.getAddresses().stream()
                .map(value -> addressMapper.map(value, AddressEntity.class))
                .collect(Collectors.toList())), destination::setAddresses)
            .afterMap(() -> log.info(">>> Finished mapping of DeliveryDto (id: " + source.getId()
                + ") to DeliveryEntity")));
        return this;
    }

    public Mapper build() {
        return this.mapperBuilder.buildMapper();
    }

    @SuppressWarnings("unchecked")
    private Mapper addressMapper() {
        return new MapperBuilder().addMap(AddressDto.class, AddressEntity.class,
            (conf, source, destination) -> conf
                .beforeMap(mapperRef -> log.info(">>> Starting mapping of AddressDto (id: "
                    + source.getId() + ") to AddressEntity by mapper " + mapperRef))
                .bind(() -> StringUtils.convertToUuid(source.getId()), destination::setId)
                .bind(source::getCity, destination::setCity,
                    BindingOption.mapWhen(() -> isNotEmpty(source.getCity())))
                .bind(source::getCountry, destination::setCountry,
                    BindingOption.mapWhen(() -> isNotEmpty(source.getCountry())))
                .bind(source::getPostalCode, destination::setPostalCode,
                    BindingOption.withNullSubstitution("unknown"))
                .bind(source::getStateOrProvince, destination::setStateOrProvince,
                    BindingOption.withNullSubstitution("unknown"))
                .bind(source::getStreet, destination::setStreet)
                .afterMap(() -> log.info(">>> Finished mapping of AddressDto (id: "
                    + source.getId() + ") to AddressEntity")))
            .buildMapper();
    }
}
