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
package io.nullables.api.playground.objectmappers.doov;

import static io.nullables.api.playground.objectmappers.testflow.utils.ModelMockTestUtils.deliveryDtoMock;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import io.doov.core.dsl.mapping.MappingRegistry;
import io.doov.core.dsl.runtime.RuntimeModel;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.commons.utils.ArrayUtils;
import io.nullables.api.playground.objectmappers.doov.configuration.DoovMapperConfiguration;
import io.nullables.api.playground.objectmappers.doov.model.AddressDtoFieldModel;
import io.nullables.api.playground.objectmappers.doov.model.AddressEntityFieldModel;
import io.nullables.api.playground.objectmappers.doov.model.DeliveryDtoFieldModel;
import io.nullables.api.playground.objectmappers.doov.model.DeliveryEntityFieldModel;
import io.nullables.api.playground.objectmappers.testflow.annotation.SimpleTest;
import io.nullables.api.playground.objectmappers.testflow.annotation.VariableSource;

@SimpleTest
class DoovMapperTest {

	public static final Stream<Arguments> deliveryDtoValues = IntStream.iterate(0, n -> n + 1)
			.limit(ThreadLocalRandom.current().nextInt(1, 10)).mapToObj(v -> deliveryDtoMock().val())
			.map(Arguments::of);

	private MappingRegistry mappingRegistry;

	@BeforeEach
	void before() {
		this.mappingRegistry = DoovMapperConfiguration.newBuilder().configureAddressMappings()
				.configureDeliveryMappings().build();
	}

	@ParameterizedTest
	@VariableSource("deliveryDtoValues")
	void testCheckDeliveryDtoConversion(@Nonnull final DeliveryDto source) {
		// when
		final List<AddressEntity> addresses = source.getAddresses().stream().map(addressDto -> {
			final AddressEntity addressTarget = new AddressEntity();
			this.mappingRegistry.executeOn(new RuntimeModel<>(AddressDtoFieldModel.newInstance(), addressDto),
					new RuntimeModel<>(AddressEntityFieldModel.newInstance(), addressTarget));
			return addressTarget;
		}).collect(Collectors.toList());

		final DeliveryEntity target = new DeliveryEntity();
		this.mappingRegistry.executeOn(new RuntimeModel<>(DeliveryDtoFieldModel.newInstance(), source),
				new RuntimeModel<>(DeliveryEntityFieldModel.newInstance(), target));
		target.setAddresses(addresses);

		// then
		assertAll("Should DeliveryDto field values match target DeliveryEntity values", () -> Assertions
				.assertThat(target.getAddresses()).isNotNull()
				.extracting(v -> v.getId().toString(), AddressEntity::getCity, AddressEntity::getCountry,
						AddressEntity::getPostalCode, AddressEntity::getStateOrProvince, AddressEntity::getStreet)
				.containsExactlyInAnyOrder(source.getAddresses().stream()
						.map(c -> tuple(c.getId(), c.getCity(), c.getCountry(), c.getPostalCode(),
								c.getStateOrProvince(), c.getStreet()))
						.toArray(Tuple[]::new)),
				() -> Assertions.assertThat(target).isNotNull()
						.<String[]>usingComparatorForFields(ArrayUtils::compare, "codes")
						.<String>usingComparatorForFields(StringUtils::compare, "id")
						.<String>usingComparatorForFields(StringUtils::compare, "discount")
						.hasFieldOrPropertyWithValue("type", source.getType())
						.hasFieldOrPropertyWithValue("description", source.getDescription())
						.hasFieldOrPropertyWithValue("gid", source.getGid())
						.hasFieldOrPropertyWithValue("createdAt", source.getCreatedAt())
						.hasFieldOrPropertyWithValue("updatedAt", source.getUpdatedAt())
						.hasFieldOrPropertyWithValue("balance", source.getBalance())
						.hasFieldOrPropertyWithValue("status", source.getStatus()));
	}

}
