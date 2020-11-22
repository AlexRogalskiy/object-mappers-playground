package io.nullables.api.playground.objectmappers.benchmarks.mapper.bull;

import com.hotels.beans.BeanUtils;
import com.hotels.beans.transformer.BeanTransformer;
import com.hotels.transformer.model.FieldMapping;
import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;

import java.util.stream.Stream;

public class BullMapper implements OrderMapper {

    private final BeanTransformer transformer;

    public BullMapper() {
        final FieldMapping<String, String>[] fieldMappings = Stream.of(
            new FieldMapping<>("customer.name", "customerName"),
            new FieldMapping<>("customer.billingAddress.city", "billingCity"),
            new FieldMapping<>("customer.billingAddress.street", "billingStreetAddress"),
            new FieldMapping<>("customer.shippingAddress.city", "shippingCity"),
            new FieldMapping<>("customer.shippingAddress.street", "shippingStreetAddress")
        ).<FieldMapping<String, String>>toArray(FieldMapping[]::new);
        this.transformer = new BeanUtils().getTransformer().withFieldMapping(fieldMappings);
    }

    @Override
    public OrderDto map(final OrderEntity source) {
        return this.transformer.transform(source, OrderDto.class);
    }
}
