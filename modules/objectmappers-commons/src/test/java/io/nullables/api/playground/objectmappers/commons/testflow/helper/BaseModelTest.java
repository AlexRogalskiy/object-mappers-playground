package io.nullables.api.playground.objectmappers.commons.testflow.helper;

import io.nullables.api.playground.objectmappers.commons.enumeration.DeliveryStatus;
import io.nullables.api.playground.objectmappers.commons.model.AddressInfo;
import io.nullables.api.playground.objectmappers.commons.model.DeliveryInfo;
import net.andreinc.mockneat.abstraction.MockUnit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.andreinc.mockneat.unit.objects.Filler.filler;
import static net.andreinc.mockneat.unit.types.Ints.ints;

public abstract class BaseModelTest extends BaseTest {

    /**
     * Default number of {@link AddressInfo} items
     */
    public static final int DEFAULT_ADDRESS_INFO_COUNT = 5;
    /**
     * Default {@link DeliveryStatus} collection {@link List}
     */
    public static final List<DeliveryStatus> DELIVERY_STATUS_LIST = Collections.unmodifiableList(Arrays.asList(DeliveryStatus.values()));

    /**
     * Default {@link DeliveryInfo} {@link MockUnit}
     *
     * @return {@link DeliveryInfo} {@link MockUnit}
     */
    protected MockUnit<DeliveryInfo> getDeliveryInfoMock() {
        return this.getDeliveryInfoMock(DEFAULT_ADDRESS_INFO_COUNT);
    }

    /**
     * Default delivery info mock unit instance {@link MockUnit}
     *
     * @return delivery info mock unit instance {@link MockUnit}
     */
    protected MockUnit<DeliveryInfo> getDeliveryInfoMock(int addressInfoCount) {
        return filler(DeliveryInfo::new)
            .setter(DeliveryInfo::setId, getLongMock())
            .setter(DeliveryInfo::setType, getIntMock())
            .setter(DeliveryInfo::setGid, getAlphaNumericStringMock())
            .setter(DeliveryInfo::setDescription, getLettersStringMock())
            .setter(DeliveryInfo::setCreatedAt, getLocalDateMock().toUtilDate())
            .setter(DeliveryInfo::setUpdatedAt, getLocalDateMock().toUtilDate())
            .setter(DeliveryInfo::setBalance, getDoubleMock())
            .setter(DeliveryInfo::setStatus, generateStatus())
            .setter(DeliveryInfo::setDiscount, generateDiscount(1.5, 20.5))
            .setter(DeliveryInfo::setCodes, generateInts(10, 100, 200))
            .setter(DeliveryInfo::setAddresses, getAddressInfoMock().list(addressInfoCount));
    }

    /**
     * Returns {@link DeliveryStatus} {@link MockUnit}
     *
     * @return {@link DeliveryStatus} {@link MockUnit}
     */
    protected MockUnit<DeliveryStatus> generateStatus() {
        return ints().bound(DELIVERY_STATUS_LIST.size()).map(DELIVERY_STATUS_LIST::get);
    }

    /**
     * Returns delivery info discount {@link MockUnit} by initial input range (lower / upper bounds)
     *
     * @return delivery info discount {@link MockUnit}
     */
    protected MockUnit<BigDecimal> generateDiscount(double lowerBound, double upperBound) {
        return this.getMock().doubles().range(lowerBound, upperBound).map(BigDecimal::valueOf);
    }

    /**
     * Default {@link AddressInfo} {@link MockUnit}
     *
     * @return {@link AddressInfo} {@link MockUnit}
     */
    protected MockUnit<AddressInfo> getAddressInfoMock() {
        return filler(AddressInfo::new)
            .setter(AddressInfo::setId, getLongMock())
            .setter(AddressInfo::setCity, getLettersStringMock())
            .setter(AddressInfo::setCountry, getLettersStringMock())
            .setter(AddressInfo::setPostalCode, getAlphaNumericStringMock())
            .setter(AddressInfo::setStateOrProvince, getLettersStringMock())
            .setter(AddressInfo::setStreet, getLettersStringMock());
    }
}
