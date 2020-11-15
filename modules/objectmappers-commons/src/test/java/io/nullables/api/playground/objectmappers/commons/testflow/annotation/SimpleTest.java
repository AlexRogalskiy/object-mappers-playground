package io.nullables.api.playground.objectmappers.commons.testflow.annotation;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AutoconfigureBootstrapTest
@TypeQualifierDefault(ElementType.TYPE)
public @interface SimpleTest {
}
