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
package io.nullables.api.playground.objectmappers.jmapper.configuration;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.conversion;
import static com.googlecode.jmapper.api.JMapperAPI.global;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.api.JMapperAPI;

import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;

public class JMapperConfiguration {

	public JMapperAPI addressMappingApi() {
		return new JMapperAPI().add(mappedClass(AddressEntity.class).add(global()).add(conversion("id").from("id")
				.to("id").avoidSet(false).type(JMapConversion.Type.DYNAMIC)
				.body("return io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid(${source});"))
				.add(attribute("city").value("city")).add(attribute("country").value("country"))
				.add(attribute("stateOrProvince").value("stateOrProvince"))
				.add(attribute("postalCode").value("postalCode")).add(attribute("street").value("street")));
	}

	public JMapperAPI deliveryMappingApi() {
		return new JMapperAPI().add(mappedClass(DeliveryEntity.class).add(global()).add(conversion("id").from("id")
				.to("id").avoidSet(false).type(JMapConversion.Type.DYNAMIC)
				.body("return io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid(${source});"))
				.add(attribute("type").value("type")).add(attribute("description").value("description"))
				.add(attribute("gid").value("gid")).add(attribute("createdAt").value("createdAt"))
				.add(attribute("updatedAt").value("updatedAt"))
				.add(conversion("shippableDue").from("shippableDue").to("shippableDue").avoidSet(false)
						.type(JMapConversion.Type.DYNAMIC)
						.body("return io.nullables.api.playground.objectmappers.commons.utils.DateUtils.convertToLocalDateTime(${source});"))
				.add(attribute("balance").value("balance")).add(attribute("discount").value("discount"))
				.add(attribute("status").value("status")).add(attribute("addresses").value("addresses"))
				.add(attribute("codes").value("codes")));
	}

}
