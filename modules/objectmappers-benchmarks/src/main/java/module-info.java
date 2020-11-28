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
open module io.nullables.api.playground.objectmappers.benchmarks {
    requires io.nullables.api.playground.objectmappers.testflow;
    requires io.nullables.api.playground.objectmappers.commons;
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
    requires com.remondis.remap;
    requires datus;
    requires bull.common;
    requires bull.bean.transformer;
    requires beanmapper;
    requires commons.beanutils;
}
