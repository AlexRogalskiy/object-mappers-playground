package mappings

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils
import org.apache.commons.lang3.ArrayUtils

mappingFor a: AddressDto, b: AddressEntity
introspector exploding

def isEmpty = { it -> ArrayUtils.isEmpty(it) }

a.id = b.id
convert to_a: { it -> StringUtils.convertToString(it) }, to_b: { it -> StringUtils.convertToUuid(it) }

a.city = b.city
convert to_a: { it -> isEmpty(it) ? null : it }, to_b: { it -> isEmpty(it) ? null : it }

a.country = b.country
convert to_a: { it -> isEmpty(it) ? null : it }, to_b: { it -> isEmpty(it) ? null : it }

a.stateOrProvince = b.stateOrProvince
a.postalCode = b.postalCode
a.street = b.street
