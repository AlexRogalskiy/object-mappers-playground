open module io.nullables.api.playground.objectmappers.dozer {
    exports io.nullables.api.playground.objectmappers.dozer.configuration;

    requires static lombok;
    requires jsr305;
    requires slf4j.api;
    requires dozer.core;
    requires org.apache.commons.lang3;
}
