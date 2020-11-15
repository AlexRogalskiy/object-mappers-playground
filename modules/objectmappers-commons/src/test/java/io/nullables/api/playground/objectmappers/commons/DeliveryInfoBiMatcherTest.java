package io.nullables.api.playground.objectmappers.commons;

import io.nullables.api.playground.objectmappers.commons.model.DeliveryInfo;
import io.nullables.api.playground.objectmappers.commons.testflow.annotation.SimpleTest;
import io.nullables.api.playground.objectmappers.commons.testflow.helper.BaseModelTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SimpleTest
class DeliveryInfoBiMatcherTest extends BaseModelTest {

    /**
     * Default date format pattern
     */
    private final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    /**
     * Default number format pattern
     */
    private static final String DEFAULT_NUMBER_REGEX = "-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?";
    /**
     * Default {@link DeliveryInfo} gid prefix
     */
    private final String DEFAULT_GID_PREFIX = "TEST";
    /**
     * Default {@link DeliveryInfo} type
     */
    public static final int DEFAULT_TYPE = 5;

    /**
     * Default {@link DeliveryInfo} model
     */
    private DeliveryInfo deliveryInfo;

    @BeforeEach
    void setUp() {
        this.deliveryInfo = this.getDeliveryInfoMock().val();
    }

    @Test
    @DisplayName("Test non-equal delivery info entities by custom comparator")
    void test_nonEqual_deliveryInfo_by_andMatcher() {
        // given
        // when
        // then
    }
}
