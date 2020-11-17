open module io.nullables.api.playground.objectmappers.mapstruct {
    exports io.nullables.api.playground.objectmappers.mapstruct.configuration;

    requires static lombok;
    requires jsr305;
    requires slf4j.api;
    requires io.nullables.api.playground.objectmappers.commons;
    requires org.mapstruct;
    requires java.compiler;
}
