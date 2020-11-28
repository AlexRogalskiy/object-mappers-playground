/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
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
