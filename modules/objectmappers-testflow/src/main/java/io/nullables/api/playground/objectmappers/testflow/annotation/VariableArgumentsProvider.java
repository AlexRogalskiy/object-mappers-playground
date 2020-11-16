package io.nullables.api.playground.objectmappers.testflow.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.platform.commons.util.ReflectionUtils.tryToReadFieldValue;

@Slf4j
class VariableArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<VariableSource> {

    private String variableName;

    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext context) {
        return context.getTestClass()
            .map(this::getField)
            .map(this::getValue)
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
