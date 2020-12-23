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
package io.nullables.api.playground.objectmappers.testflow.annotation;

import static org.junit.platform.commons.util.ReflectionUtils.tryToReadFieldValue;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class VariableArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<VariableSource> {

    private String variableName;

    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext context) {
        return context.getTestClass().map(this::getField).map(this::getValue)
                        .orElseThrow(() -> new IllegalArgumentException("Failed to load test arguments"));
    }

    @Override
    public void accept(final VariableSource variableSource) {
        this.variableName = variableSource.value();
    }

    private Field getField(final Class<?> clazz) {
        try {
            return clazz.getDeclaredField(this.variableName);
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private Stream<Arguments> getValue(final Field field) {
        try {
            return (Stream<Arguments>) tryToReadFieldValue(field).toOptional().orElseGet(Stream::empty);
        } catch (Exception ex) {
            log.error("Cannot access value of a field {}, message: {}", field.getName(), ex.getMessage());
            throw new IllegalArgumentException(ex);
        }
    }
}
