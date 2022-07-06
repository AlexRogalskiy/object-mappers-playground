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
package io.nullables.api.playground.objectmappers.modelmapper.configuration;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;

public final class ModelMapperBuilder {

	private final ModelMapper modelMapper;

	private ModelMapperBuilder() {
		this.modelMapper = new ModelMapper();
		this.modelMapper.getConfiguration().setDestinationNameTransformer(NameTransformers.builder("with"))
				.setDestinationNamingConvention(NamingConventions.builder("with"))
				.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
				.setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PUBLIC)
				.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR)
				.setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
				.setMatchingStrategy(MatchingStrategies.STRICT).setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
				.setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE).setAmbiguityIgnored(true)
				.setSkipNullEnabled(true).setFieldMatchingEnabled(true).setFullTypeMatchingRequired(true)
				.setImplicitMappingEnabled(true);
	}

	public ModelMapperBuilder withConverter(final Converter<?, ?> converter) {
		this.modelMapper.addConverter(converter);
		return this;
	}

	public ModelMapperBuilder withPropertyMap(final PropertyMap<?, ?> propertyMap) {
		this.modelMapper.addMappings(propertyMap);
		return this;
	}

	public static ModelMapperBuilder newBuilder() {
		return new ModelMapperBuilder();
	}

	public ModelMapper build() {
		return this.modelMapper;
	}

}
