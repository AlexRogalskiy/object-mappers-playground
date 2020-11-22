package io.nullables.api.playground.objectmappers.benchmarks.mapper.datus;

import com.github.roookeee.datus.api.Datus;
import com.github.roookeee.datus.api.Mapper;
import com.github.roookeee.datus.functions.Fn1;
import com.github.roookeee.datus.immutable.ConstructorParameter;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.CustomerEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.ProductEntity;

public class DatusMapper implements OrderMapper {

    private static final Mapper<ProductEntity, ProductDto> productMapper = Datus.forTypes(ProductEntity.class, ProductDto.class)
        .immutable((Fn1<String, ProductDto>) ProductDto::new)
        .from(ProductEntity::getName).to(ConstructorParameter::bind)
        .build();

    private static final Mapper<OrderEntity, OrderDto> mapper = Datus.forTypes(OrderEntity.class, OrderDto.class)
        .mutable(OrderDto::new)
        .from(OrderEntity::getCustomer).nullsafe()
        .map(CustomerEntity::getName).into(OrderDto::setCustomerName)
        .from(OrderEntity::getCustomer).nullsafe()
        .map(CustomerEntity::getBillingAddress).map(AddressEntity::getCity).into(OrderDto::setBillingCity)
        .from(OrderEntity::getCustomer).nullsafe()
        .map(CustomerEntity::getBillingAddress).map(AddressEntity::getStreet).into(OrderDto::setBillingStreetAddress)
        .from(OrderEntity::getCustomer).nullsafe()
        .map(CustomerEntity::getShippingAddress).map(AddressEntity::getCity).into(OrderDto::setShippingCity)
        .from(OrderEntity::getCustomer).nullsafe()
        .map(CustomerEntity::getShippingAddress).map(AddressEntity::getStreet).into(OrderDto::setShippingStreetAddress)
        .from(OrderEntity::getProducts).nullsafe()
        .map(productMapper::convert).into(OrderDto::setProducts)
        .build();

    @Override
    public OrderDto map(final OrderEntity source) {
        return mapper.convert(source);
    }
}
