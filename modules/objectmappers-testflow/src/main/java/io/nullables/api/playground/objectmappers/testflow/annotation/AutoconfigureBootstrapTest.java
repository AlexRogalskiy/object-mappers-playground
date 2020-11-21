package io.nullables.api.playground.objectmappers.testflow.annotation;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.*;
import java.lang.reflect.Method;

import static org.apache.commons.lang3.StringUtils.joinWith;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
@TypeQualifierDefault(ElementType.ANNOTATION_TYPE)
public @interface AutoconfigureBootstrapTest {
    /**
     * Underscore {@link DisplayNameGenerator} implementation
     */
    class UnderscoreDisplayNameGenerator extends DisplayNameGenerator.ReplaceUnderscores {
        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForClass(final Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForNestedClass(final Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForMethod(final Class<?> testClass, final Method testMethod) {
            final String name = joinWith(" > ", testMethod.getName(), testClass.getSimpleName());
            return name.replace('_', '.');
        }
    }

    /**
     * Camel case {@link DisplayNameGenerator} implementation
     */
    class CamelCaseDisplayNameGenerator extends DisplayNameGenerator.Standard {
        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForClass(final Class<?> testClass) {
            return replaceCamelCase(super.generateDisplayNameForClass(testClass));
        }

        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForNestedClass(final Class<?> nestedClass) {
            return replaceCamelCase(super.generateDisplayNameForNestedClass(nestedClass));
        }

        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForMethod(final Class<?> testClass, final Method testMethod) {
            return this.replaceCamelCase(testMethod.getName())
                            + DisplayNameGenerator.parameterTypesAsString(testMethod);
        }

        /**
         * Returns replaced {@link String} by input camel-cased {@link String} value
         *
         * @param value - initial input {@link String} value to replace
         * @return replaced {@link String}
         */
        private String replaceCamelCase(final String value) {
            final StringBuilder result = new StringBuilder();
            result.append(value.charAt(0));
            for (int i = 1; i < value.length(); i++) {
                if (Character.isUpperCase(value.charAt(i))) {
                    result.append(Character.SPACE_SEPARATOR);
                    result.append(Character.toLowerCase(value.charAt(i)));
                } else {
                    result.append(value.charAt(i));
                }
            }
            return result.toString();
        }
    }

    /**
     * Space {@link DisplayNameGenerator} implementation
     */
    class SpaceDisplayNameGenerator extends DisplayNameGenerator.ReplaceUnderscores {

        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForClass(final Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForNestedClass(final Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        /**
         * {@inheritDoc}
         *
         * @see ReplaceUnderscores
         */
        @Override
        public String generateDisplayNameForMethod(final Class<?> testClass, final Method testMethod) {
            final String name = testClass.getSimpleName() + StringUtils.SPACE + testMethod.getName();
            return name.replace("_", StringUtils.SPACE) + ".";
        }
    }
}
