package io.nullables.api.playground.objectmappers.jmapper.configuration;

import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.api.JMapperAPI;
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity;
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;

import static com.googlecode.jmapper.api.JMapperAPI.*;

public class JMapperConfiguration {

    public JMapperAPI addressMappingApi() {
        return new JMapperAPI()
            .add(mappedClass(AddressEntity.class).add(global())
                .add(conversion("id")
                    .from("id").to("id").avoidSet(false)
                    .type(JMapConversion.Type.DYNAMIC)
                    .body("return io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid(${source});"))
                .add(attribute("city").value("city"))
                .add(attribute("country").value("country"))
                .add(attribute("stateOrProvince").value("stateOrProvince"))
                .add(attribute("postalCode").value("postalCode"))
                .add(attribute("street").value("street")));
    }

    public JMapperAPI deliveryMappingApi() {
        return new JMapperAPI()
            .add(mappedClass(DeliveryEntity.class).add(global())
                .add(conversion("id")
                    .from("id").to("id").avoidSet(false)
                    .type(JMapConversion.Type.DYNAMIC)
                    .body("return io.nullables.api.playground.objectmappers.commons.utils.StringUtils.convertToUuid(${source});"))
                .add(attribute("type").value("type"))
                .add(attribute("description").value("description"))
                .add(attribute("gid").value("gid"))
                .add(attribute("createdAt").value("createdAt"))
                .add(attribute("updatedAt").value("updatedAt"))
                .add(conversion("shippableDue")
                    .from("shippableDue").to("shippableDue").avoidSet(false)
                    .type(JMapConversion.Type.DYNAMIC)
                    .body("return java.time.LocalDateTime.parse(${source}, io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_FORMATTER);"))
                .add(attribute("balance").value("balance"))
                .add(attribute("discount").value("discount"))
                .add(attribute("status").value("status"))
                .add(attribute("addresses").value("addresses"))
                .add(attribute("codes").value("codes")));
    }
}
