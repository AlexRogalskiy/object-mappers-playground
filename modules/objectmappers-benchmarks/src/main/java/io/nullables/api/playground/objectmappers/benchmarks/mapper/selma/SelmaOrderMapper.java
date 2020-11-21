package io.nullables.api.playground.objectmappers.benchmarks.mapper.selma;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;

@Mapper(withCustomFields = {@Field({"customer.name", "customerName"}),
                @Field({"customer.billingAddress.street", "billingStreetAddress"}),
                @Field({"customer.billingAddress.city", "billingCity"}),
                @Field({"customer.shippingAddress.street", "shippingStreetAddress"}),
                @Field({"customer.shippingAddress.city", "shippingCity"}),
                @Field({"customer.billingAddress.street", "billingStreetAddress"}),
                @Field({"customer.billingAddress.street", "billingStreetAddress"})})
public interface SelmaOrderMapper {

    OrderDto map(final OrderEntity source);

    ProductDto map(final ProductEntity product);
}
