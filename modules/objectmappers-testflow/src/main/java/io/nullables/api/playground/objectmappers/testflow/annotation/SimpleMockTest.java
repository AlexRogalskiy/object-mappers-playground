package io.nullables.api.playground.objectmappers.testflow.annotation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AutoconfigureBootstrapTest
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
@TypeQualifierDefault(ElementType.TYPE)
public @interface SimpleMockTest {
}
