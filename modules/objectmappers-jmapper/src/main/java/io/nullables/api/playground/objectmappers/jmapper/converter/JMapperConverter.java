/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this
 * program. If not, see https\\://www.gnu.org/licenses/.
 */
// package io.nullables.api.playground.objectmappers.jmapper.converter;
//
// import com.googlecode.jmapper.JMapper;
// import com.googlecode.jmapper.api.JMapperAPI;
// import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
// import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
//
// import java.time.LocalDateTime;
// import java.util.UUID;
//
// public class JMapperConverter {
//
// private final JMapper<AddressEntity, AddressDto> addressJMapper;
// private final JMapper<Integer[], String[]> codeJMapper;
// private final JMapper<UUID, String> idJMapper;
// private final JMapper<LocalDateTime, String> shippableDateJMapper;
//
// public JMapperConverter() {
// final JMapperAPI addressJMapperApi = new
// JMapperAPI().add(JMapperAPI.mappedClass(AddressEntity.class));
// this.addressJMapper = new JMapper<>(AddressEntity.class, AddressDto.class,
// addressJMapperApi);
//
// final JMapperAPI codeJMapperApi = new
// JMapperAPI().add(JMapperAPI.mappedClass(Integer[].class));
// this.codeJMapper = new JMapper<>(Integer[].class, String[].class, codeJMapperApi);
//
// final JMapperAPI idJMapperApi = new
// JMapperAPI().add(JMapperAPI.mappedClass(UUID.class));
// this.idJMapper = new JMapper<>(UUID.class, String.class, idJMapperApi);
//
// final JMapperAPI shippableDateJMapperApi = new
// JMapperAPI().add(JMapperAPI.mappedClass(LocalDateTime.class));
// this.shippableDateJMapper = new JMapper<>(LocalDateTime.class, String.class,
// shippableDateJMapperApi);
// }
//
// public AddressEntity convertAddress(final AddressDto sourceOrder) {
// return this.addressJMapper.getDestination(sourceOrder);
// }
//
// public Integer[] convertCodes(final String[] sourceCode) {
// return this.codeJMapper.getDestination(sourceCode);
// }
//
// public UUID convertId(final String sourceCode) {
// return this.idJMapper.getDestination(sourceCode);
// }
//
// public LocalDateTime convertShippableDate(final String sourceCode) {
// return this.shippableDateJMapper.getDestination(sourceCode);
// }
// }
