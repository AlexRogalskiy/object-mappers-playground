package io.nullables.api.playground.objectmappers.testflow.annotation;

import org.junit.jupiter.params.provider.ArgumentsSource;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(VariableArgumentsProvider.class)
@TypeQualifierDefault(ElementType.METHOD)
public @interface VariableSource {
    /**
     * The name of the static variable
     */
    String value();
}
