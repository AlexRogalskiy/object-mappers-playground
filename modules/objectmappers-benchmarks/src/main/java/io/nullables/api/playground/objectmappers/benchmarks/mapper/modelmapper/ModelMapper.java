package io.nullables.api.playground.objectmappers.benchmarks.mapper.modelmapper;

import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
import org.modelmapper.PropertyMap;

public class ModelMapper implements OrderMapper {

    private final org.modelmapper.ModelMapper modelMapper;

    public ModelMapper() {
        this.modelMapper = new org.modelmapper.ModelMapper();
        this.modelMapper.addMappings(new PropertyMap<OrderEntity, OrderDto>() {
            @Override
            protected void configure() {
                map().setBillingStreetAddress(source.getCustomer().getBillingAddress().getStreet());
                map().setBillingCity(source.getCustomer().getBillingAddress().getCity());
                map().setShippingStreetAddress(source.getCustomer().getShippingAddress().getStreet());
                map().setShippingCity(source.getCustomer().getShippingAddress().getCity());
            }
        });
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.modelMapper.map(source, OrderDto.class);
    }
}
