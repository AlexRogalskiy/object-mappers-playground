// package io.nullables.api.playground.objectmappers.benchmarks.mapper.jmapper;
//
// import com.googlecode.jmapper.JMapper;
// import com.googlecode.jmapper.api.JMapperAPI;
// import io.nullables.api.playground.objectmappers.benchmarks.mapper.OrderMapper;
// import io.nullables.api.playground.objectmappers.benchmarks.model.dto.OrderDto;
// import io.nullables.api.playground.objectmappers.benchmarks.model.dto.ProductDto;
// import io.nullables.api.playground.objectmappers.benchmarks.model.entity.OrderEntity;
//
// import static com.googlecode.jmapper.api.JMapperAPI.attribute;
// import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;
//
// public class JMapperMapper implements OrderMapper {
//
// private final JMapper<OrderDto, OrderEntity> mapper;
//
// public JMapperMapper() {
// final JMapperAPI api = new JMapperAPI()
// .add(mappedClass(OrderDto.class)
// .add(attribute("shippingStreetAddress").value("${customer.shippingAddress.street}"))
// .add(attribute("shippingCity").value("${customer.shippingAddress.city}"))
// .add(attribute("billingStreetAddress").value("${customer.billingAddress.street}"))
// .add(attribute("billingCity").value("${customer.billingAddress.city}"))
// .add(attribute("products").value("products")))
// .add(mappedClass(ProductDto.class)
// .add(attribute("name").value("name")));
//
// this.mapper = new JMapper<>(OrderDto.class, OrderEntity.class, api);
// }
// @Override
// public OrderDto map(final OrderEntity source) {
// return this.mapper.getDestination(source);
// }
// }
