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
package io.nullables.api.playground.objectmappers.nomin.configuration;

import org.nomin.Mapping;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

public final class NominMapperBuilder {

    private final NominMapper nominMapper;

    private NominMapperBuilder() {
        this.nominMapper = new Nomin().defaultIntrospector(Mapping.exploding).disableCache().enableAutomapping();
    }

    public NominMapperBuilder withScripts(final String... mappingScripts) {
        this.nominMapper.parse(mappingScripts);
        return this;
    }

    public NominMapperBuilder withFiles(final String... files) {
        this.nominMapper.parseFiles(files);
        return this;
    }

    public NominMapperBuilder withDirectory(final String directory) {
        this.nominMapper.parseDirectory(directory);
        return this;
    }

    @SafeVarargs
    public final NominMapperBuilder withMappings(final Class<? extends Mapping>... mappings) {
        this.nominMapper.parse(mappings);
        return this;
    }

    public static NominMapperBuilder newBuilder() {
        return new NominMapperBuilder();
    }

    public NominMapper build() {
        return this.nominMapper;
    }
}
