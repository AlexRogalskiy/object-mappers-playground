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
