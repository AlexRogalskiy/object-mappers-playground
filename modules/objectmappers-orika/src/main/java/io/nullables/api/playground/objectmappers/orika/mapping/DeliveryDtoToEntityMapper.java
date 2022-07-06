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
package io.nullables.api.playground.objectmappers.orika.mapping;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.orika.converter.StringToIntegerArrayConverter;
import io.nullables.api.playground.objectmappers.orika.converter.StringToLocalDateTimeConverter;
import io.nullables.api.playground.objectmappers.orika.converter.StringToUuidConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.NullFilter;
import ma.glasnost.orika.constructor.SimpleConstructorResolverStrategy;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.JavassistCompilerStrategy;
import ma.glasnost.orika.metadata.CaseInsensitiveClassMapBuilder;
import ma.glasnost.orika.property.IntrospectorPropertyResolver;
import ma.glasnost.orika.unenhance.BaseUnenhancer;

public class DeliveryDtoToEntityMapper extends ConfigurableMapper {

	@Override
	public void configureFactoryBuilder(final DefaultMapperFactory.Builder builder) {
		builder.classMapBuilderFactory(new CaseInsensitiveClassMapBuilder.Factory())
				.constructorResolverStrategy(new SimpleConstructorResolverStrategy())
				.propertyResolverStrategy(new IntrospectorPropertyResolver())
				.compilerStrategy(new JavassistCompilerStrategy()).unenhanceStrategy(new BaseUnenhancer())
				.useAutoMapping(true).useBuiltinConverters(true);
	}

	@Override
	protected void configure(final MapperFactory factory) {
		final ConverterFactory converterFactory = factory.getConverterFactory();
		converterFactory.registerConverter("stringToUuidConverter", new StringToUuidConverter());
		converterFactory.registerConverter("stringToLocalDateTimeConverter", new StringToLocalDateTimeConverter());
		converterFactory.registerConverter("stringToIntegerArrayConverter", new StringToIntegerArrayConverter());

		factory.registerFilter(new NullFilter<>());

		factory.classMap(AddressDto.class, AddressEntity.class).mapNulls(true).mapNullsInReverse(true)
				.fieldMap("id", "id").converter("stringToUuidConverter").add().field("city", "city")
				.field("country", "country").field("stateOrProvince", "stateOrProvince")
				.field("postalCode", "postalCode").field("street", "street").register();

		factory.classMap(DeliveryDto.class, DeliveryEntity.class).mapNulls(true).mapNullsInReverse(true)
				.customize(new ShippableDateTimeCustomMapper()).fieldMap("id", "id").converter("stringToUuidConverter")
				.add().fieldMap("codes", "codes").converter("stringToIntegerArrayConverter").add()
				.fieldMap("shippableDue", "shippableDue").converter("stringToLocalDateTimeConverter").add()
				.field("type", "type").field("description", "description").field("gid", "gid")
				.field("createdAt", "createdAt").field("updatedAt", "updatedAt").field("balance", "balance")
				.field("discount", "discount").field("status", "status").byDefault().register();
	}

}
