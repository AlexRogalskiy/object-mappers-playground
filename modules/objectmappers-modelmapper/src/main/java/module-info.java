open module io.nullables.api.playground.objectmappers.modelmapper {
    exports io.nullables.api.playground.objectmappers.modelmapper.propertymap;
    exports io.nullables.api.playground.objectmappers.modelmapper.configuration;

    requires static lombok;
    requires jsr305;
    requires slf4j.api;
    requires modelmapper;
    requires io.nullables.api.playground.objectmappers.commons;
}
