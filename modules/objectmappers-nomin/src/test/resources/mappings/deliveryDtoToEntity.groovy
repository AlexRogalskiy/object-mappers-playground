package mappings

import io.nullables.api.playground.objectmappers.commons.model.dto.DeliveryDto
import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils

import java.time.LocalDateTime
import java.util.logging.Logger

import static io.nullables.api.playground.objectmappers.commons.utils.DateUtils.DATETIME_FORMATTER

mappingFor a: DeliveryDto, b: DeliveryEntity
introspector exploding

a.id = b.id
convert to_a: { it -> StringUtils.convertToString(it) }, to_b: { it -> StringUtils.convertToUuid(it) }

a.type = b.type
a.description = b.description
a.gid = b.gid
a.createdAt = b.createdAt
a.updatedAt = b.updatedAt

a.shippableDue = b.shippableDue
convert to_a: { it -> DATETIME_FORMATTER.format(it) }, to_b: { it -> LocalDateTime.parse(it, DATETIME_FORMATTER) }

a.balance = b.balance
a.discount = b.discount
a.status = b.status

a.addresses = b.addresses

a.codes = b.codes
convert to_a: { it -> String.valueOf(it) }, to_b: { it -> Integer.valueOf(it) }

beforeAtoB {
  Logger.getLogger("mappings").info(">>> Conversion from [deliveryDto] -> [deliveryEntity] started")
  this.metaPropertyValues.forEach({ i -> Logger.getLogger("mappings").info(i.getName() + " : " + i.getValue()) })
}

beforeBtoA {
  Logger.getLogger("mappings").info(">>> Conversion from [deliveryEntity] -> [deliveryDto] started")
}

afterAtoB {
  Logger.getLogger("mappings").info(">>> Conversion from [deliveryDto] -> [deliveryEntity] completed")
}

afterBtoA {
  Logger.getLogger("mappings").info(">>> Conversion from [deliveryEntity] -> [deliveryDto] completed")
}
