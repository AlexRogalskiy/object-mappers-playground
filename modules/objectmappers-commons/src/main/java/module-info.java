open module io.nullables.api.playground.objectmappers.commons {
    exports io.nullables.api.playground.objectmappers.commons.model.dto;
    exports io.nullables.api.playground.objectmappers.commons.model.entity;
    exports io.nullables.api.playground.objectmappers.commons.enumeration;
    exports io.nullables.api.playground.objectmappers.commons.utils;

    requires static lombok;
    requires jsr305;
    requires org.apache.commons.lang3;
}
