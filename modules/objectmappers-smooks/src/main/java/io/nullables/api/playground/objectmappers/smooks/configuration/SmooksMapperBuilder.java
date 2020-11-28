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
package io.nullables.api.playground.objectmappers.smooks.configuration;

import org.milyn.Smooks;
import org.milyn.delivery.Visitor;
import org.xml.sax.SAXException;

import java.io.IOException;

public final class SmooksMapperBuilder {

    private final Smooks mapper;

    private SmooksMapperBuilder() {
        this.mapper = new Smooks();
    }

    public static SmooksMapperBuilder newBuilder() {
        return new SmooksMapperBuilder();
    }

    public SmooksMapperBuilder withConfiguration(final String resource) {
        try {
            this.mapper.addConfigurations(resource);
        } catch (IOException | SAXException e) {
            throw new IllegalArgumentException(e);
        }
        return this;
    }

    public SmooksMapperBuilder withVisitor(final Visitor visitor) {
        this.mapper.addVisitor(visitor);
        return this;
    }

    public Smooks build() {
        return this.mapper;
    }
}
