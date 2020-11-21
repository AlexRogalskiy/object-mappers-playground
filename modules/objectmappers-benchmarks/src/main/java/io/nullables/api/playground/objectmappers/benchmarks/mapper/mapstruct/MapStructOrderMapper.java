package io.nullables.api.playground.objectmappers.benchmarks.mapper.mapstruct;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    injectionStrategy = InjectionStrategy.FIELD
)
public interface MapStructOrderMapper extends OrderMapper {

    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "customer.billingAddress.street", target = "billingStreetAddress")
    @Mapping(source = "customer.billingAddress.city", target = "billingCity")
    @Mapping(source = "customer.shippingAddress.street", target = "shippingStreetAddress")
    @Mapping(source = "customer.shippingAddress.city", target = "shippingCity", defaultExpression = "java(null)")
    OrderDto map(final OrderEntity source);

    @Mapping(source = "name", target = "name")
    ProductDto productToProductDTO(final ProductEntity product);
}
