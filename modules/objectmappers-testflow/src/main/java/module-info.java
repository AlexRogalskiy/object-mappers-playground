open module io.nullables.api.playground.objectmappers.testflow {
    exports io.nullables.api.playground.objectmappers.testflow.annotation;
    exports io.nullables.api.playground.objectmappers.testflow.utils;

    requires org.apache.commons.lang3;
    requires jsr305;
    requires lombok;
    requires org.slf4j;
    requires org.junit.jupiter.api;
    requires mockito.junit.jupiter;
    requires org.mockito;
    requires org.junit.jupiter.params;
    requires mockneat;
    requires io.nullables.api.playground.objectmappers.commons;
}
