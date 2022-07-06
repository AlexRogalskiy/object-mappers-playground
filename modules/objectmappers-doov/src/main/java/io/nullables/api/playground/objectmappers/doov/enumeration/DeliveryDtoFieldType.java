package io.nullables.api.playground.objectmappers.doov.enumeration;

import io.doov.core.FieldId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeliveryDtoFieldType implements FieldId {

	ID("id"), TYPE("type"), DESCRIPTION("description"), GID("gid"), CREATE_AT("createdAt"), UPDATE_AT("updatedAt"),
	SHIPPABLE_DUE("shippableDue"), BALANCE("balance"), DISCOUNT("discount"), STATUS("status"), ADDRESSES("addresses"),
	CODES("codes");

	private final String name;

	@Override
	public String code() {
		return this.getName();
	}

}
