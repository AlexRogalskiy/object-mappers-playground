package io.nullables.api.playground.objectmappers.nomin.configuration;

import org.nomin.Mapping;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

public final class NominBuilder {

    private final NominMapper nominMapper;

    private NominBuilder() {
        this.nominMapper = new Nomin()
            .defaultIntrospector(Mapping.exploding)
            .disableCache()
            .enableAutomapping();
    }

    public NominBuilder withScripts(final String... mappingScripts) {
        this.nominMapper.parse(mappingScripts);
        return this;
    }

    public NominBuilder withFiles(final String... files) {
        this.nominMapper.parseFiles(files);
        return this;
    }

    public NominBuilder withDirectory(final String directory) {
        this.nominMapper.parseDirectory(directory);
        return this;
    }

    @SafeVarargs
    public final NominBuilder withMappings(final Class<? extends Mapping>... mappings) {
        this.nominMapper.parse(mappings);
        return this;
    }

    public static NominBuilder newBuilder() {
        return new NominBuilder();
    }

    public NominMapper build() {
        return this.nominMapper;
    }
}
