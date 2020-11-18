open module io.nullables.api.playground.objectmappers.benchmarks {
    requires io.nullables.api.playground.objectmappers.testflow;
    requires io.nullables.api.playground.objectmappers.commons;
    requires io.nullables.api.playground.objectmappers.modelmapper;
    requires io.nullables.api.playground.objectmappers.dozer;

    requires org.apache.commons.lang3;
    requires modelmapper;
    requires static lombok;
    requires slf4j.api;
    requires jmh.core;
    requires selma;
    requires orika.core;
    requires org.mapstruct;
    requires jmapper.core;
    requires dozer.core;
    requires java.sql;
    requires jsr305;
    requires java.compiler;
}
