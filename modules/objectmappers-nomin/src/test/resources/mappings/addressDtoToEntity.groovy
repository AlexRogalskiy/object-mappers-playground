package mappings

import io.nullables.api.playground.objectmappers.commons.model.dto.AddressDto
import io.nullables.api.playground.objectmappers.commons.model.entity.AddressEntity
import io.nullables.api.playground.objectmappers.commons.utils.StringUtils

mappingFor a: AddressDto, b: AddressEntity

a.id = b.id
convert to_a: { it -> StringUtils.convertToString(it) }, to_b: { it -> StringUtils.convertToUuid(it) }

a.city = b.city
a.country = b.country
a.stateOrProvince = b.stateOrProvince
a.postalCode = b.postalCode
a.street = b.street
