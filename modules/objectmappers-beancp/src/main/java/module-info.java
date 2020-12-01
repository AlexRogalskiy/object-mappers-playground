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
/**
 * Defines the Language Model, Annotation Processing, and Java Compiler APIs.
 * <p>
 * These APIs model declarations and types of the Java programming language,
 * and define interfaces for tools such as compilers which can be invoked
 * from a program.
 * <p>
 * This module is upgradeable.
 *
 * @since 9
 */
open module io.nullables.api.playground.objectmappers.beancp {
    requires io.nullables.api.playground.objectmappers.commons;

    requires static lombok;
    requires jsr305;
    requires beancp;
    requires org.apache.commons.lang3;
    requires java.logging;
}

