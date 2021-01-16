/**
 * Defines the Language Model, Annotation Processing, and Java Compiler APIs.
 * <p>
 * These APIs model declarations and types of the Java programming language,
 * and define interfaces for tools such as compilers which can be invoked
 * from a program.
 * <p>
 * This module is upgradeable.
 *
 * @since 9
 */
open module io.nullables.api.playground.objectmappers.beancp {
    requires io.nullables.api.playground.objectmappers.commons;

    requires static lombok;
    requires jsr305;
    requires beancp;
    requires org.apache.commons.lang3;
    requires java.logging;
}

