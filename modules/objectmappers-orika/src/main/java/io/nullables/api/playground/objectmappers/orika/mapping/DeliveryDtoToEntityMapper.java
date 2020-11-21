package io.nullables.api.playground.objectmappers.orika.mapping;

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto;
import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import io.nullables.api.playground.objectmappers.orika.converter.StringToIntegerArrayConverter;
import io.nullables.api.playground.objectmappers.orika.converter.StringToLocalDateTimeConverter;
import io.nullables.api.playground.objectmappers.orika.converter.StringToUuidConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.NullFilter;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class DeliveryDtoToEntityMapper extends ConfigurableMapper {

    @Override
    public void configureFactoryBuilder(final DefaultMapperFactory.Builder builder) {
        // builder.classMapBuilderFactory(new ScoringClassMapBuilder.Factory())
        // .constructorResolverStrategy(new SimpleConstructorResolverStrategy())
        // .propertyResolverStrategy(new IntrospectorPropertyResolver())
        // .compilerStrategy(new JavassistCompilerStrategy())
        // .unenhanceStrategy(new BaseUnenhancer())
        // .useAutoMapping(true)
        // .useBuiltinConverters(true);
    }

    @Override
    protected void configure(final MapperFactory factory) {
        final ConverterFactory converterFactory = factory.getConverterFactory();
        converterFactory.registerConverter("stringToUuidConverter", new StringToUuidConverter());
        converterFactory.registerConverter("stringToLocalDateTimeConverter", new StringToLocalDateTimeConverter());
        converterFactory.registerConverter("stringToIntegerArrayConverter", new StringToIntegerArrayConverter());

        factory.registerFilter(new NullFilter<>());

        factory.classMap(AddressDto.class, AddressEntity.class).mapNulls(true).mapNullsInReverse(true)
                        .fieldMap("id", "id").converter("stringToUuidConverter").add().field("city", "city")
                        .field("country", "country").field("stateOrProvince", "stateOrProvince")
                        .field("postalCode", "postalCode").field("street", "street").register();

        factory.classMap(DeliveryDto.class, DeliveryEntity.class).mapNulls(true).mapNullsInReverse(true)
                        .customize(new ShippableDateTimeCustomMapper()).fieldMap("id", "id")
                        .converter("stringToUuidConverter").add().fieldMap("codes", "codes")
                        .converter("stringToIntegerArrayConverter").add().fieldMap("shippableDue", "shippableDue")
                        .converter("stringToLocalDateTimeConverter").add().field("type", "type")
                        .field("description", "description").field("gid", "gid").field("createdAt", "createdAt")
                        .field("updatedAt", "updatedAt").field("balance", "balance").field("discount", "discount")
                        .field("status", "status").byDefault().register();
    }
}
