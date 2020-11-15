//package io.nullables.api.playground.objectmappers.commons;
//
//import com.sensiblemetrics.api.ws.web2docs.testflow.commons.annotation.SimpleTest;
//import com.sensiblemetrics.api.ws.web2docs.testflow.commons.annotation.VariableSource;
//import com.sensiblemetrics.api.ws.web2docs.testflow.commons.model.TestTag;
//import org.apache.commons.lang3.EnumUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.hamcrest.CustomTypeSafeMatcher;
//import org.hamcrest.Matcher;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.function.Function;
//import java.util.stream.Stream;
//
//import static com.sensiblemetrics.api.ws.web2docs.commons.enumeration.ErrorTemplateType.*;
//import static java.lang.String.format;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.startsWith;
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@SimpleTest
//@Tag(TestTag.ENUMERATION)
//class ErrorTemplateTypeTest {
//
//    private static final Stream<Arguments> errorTemplateTypeValues = Stream.of(
//        Arguments.of(INVALID_DATA, createTypeMatcher("error-0020", "error.data.invalid")),
//        Arguments.of(SERVICE_UNAVAILABLE, createTypeMatcher("error-0030", "error.service.unavailable")),
//        Arguments.of(SERVICE_OPERATION_ERROR, createTypeMatcher("error-0040", "error.service.operation.invalid")),
//        Arguments.of(BAD_REQUEST, createTypeMatcher("error-0050", "error.request.invalid")),
//        Arguments.of(DOCUMENT_PROCESSING_ERROR, createTypeMatcher("error-0060", "error.document.processing.invalid")),
//        Arguments.of(INVALID_ENDPOINT_CONFIGURATION, createTypeMatcher("error-0070", "error.endpoint.configuration.invalid")),
//        Arguments.of(INVALID_ENDPOINT_SECURITY_CONFIGURATION, createTypeMatcher("error-0080", "error.endpoint.security.configuration.invalid"))
//    );
//
//    @ParameterizedTest
//    @VariableSource("errorTemplateTypeValues")
//    void testCheckErrorTemplateTypeByCodeAndDescription(final ErrorTemplateType enumType,
//                                                        final Matcher<ErrorTemplateType> matcher) {
//        // then
//        assertThat(enumType, matcher);
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    void testCheckErrorTemplateTypeByName(final ErrorTemplateType enumType,
//                                          final Matcher<String> matcher) {
//        // then
//        assertThat(enumType.getCode(), matcher);
//    }
//
//    private static Stream<Arguments> testCheckErrorTemplateTypeByName() {
//        return Stream.of(
//            Arguments.of(INVALID_DATA, equalTo("error-0020")),
//            Arguments.of(SERVICE_UNAVAILABLE, equalTo("error-0030")),
//            Arguments.of(SERVICE_OPERATION_ERROR, equalTo("error-0040")),
//            Arguments.of(BAD_REQUEST, equalTo("error-0050")),
//            Arguments.of(DOCUMENT_PROCESSING_ERROR, equalTo("error-0060")),
//            Arguments.of(INVALID_ENDPOINT_CONFIGURATION, equalTo("error-0070")),
//            Arguments.of(INVALID_ENDPOINT_SECURITY_CONFIGURATION, equalTo("error-0080"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    void testCheckErrorTemplateTypeByFormattedString(final ErrorTemplateType enumType,
//                                                     final Matcher<String> matcher) {
//        // then
//        assertThat(enumType.toString(), matcher);
//    }
//
//    private static Stream<Arguments> testCheckErrorTemplateTypeByFormattedString() {
//        return Stream.of(
//            Arguments.of(INVALID_DATA, equalTo(getFormattedString("error-0020", "error.data.invalid"))),
//            Arguments.of(SERVICE_UNAVAILABLE, equalTo(getFormattedString("error-0030", "error.service.unavailable"))),
//            Arguments.of(SERVICE_OPERATION_ERROR, equalTo(getFormattedString("error-0040", "error.service.operation.invalid"))),
//            Arguments.of(BAD_REQUEST, equalTo(getFormattedString("error-0050", "error.request.invalid"))),
//            Arguments.of(DOCUMENT_PROCESSING_ERROR, equalTo(getFormattedString("error-0060", "error.document.processing.invalid"))),
//            Arguments.of(INVALID_ENDPOINT_CONFIGURATION, equalTo(getFormattedString("error-0070", "error.endpoint.configuration.invalid"))),
//            Arguments.of(INVALID_ENDPOINT_SECURITY_CONFIGURATION, equalTo(getFormattedString("error-0080", "error.endpoint.security.configuration.invalid")))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    void testCheckErrorTemplateTypeByValue(final String enumName,
//                                           final Matcher<ErrorTemplateType> matcher) {
//        // then
//        assertThat(EnumUtils.getEnum(ErrorTemplateType.class, enumName), matcher);
//    }
//
//    private static Stream<Arguments> testCheckErrorTemplateTypeByValue() {
//        return Stream.of(
//            Arguments.of("INVALID_DATA", equalTo(INVALID_DATA)),
//            Arguments.of("SERVICE_UNAVAILABLE", equalTo(SERVICE_UNAVAILABLE)),
//            Arguments.of("SERVICE_OPERATION_ERROR", equalTo(SERVICE_OPERATION_ERROR)),
//            Arguments.of("BAD_REQUEST", equalTo(BAD_REQUEST)),
//            Arguments.of("DOCUMENT_PROCESSING_ERROR", equalTo(DOCUMENT_PROCESSING_ERROR)),
//            Arguments.of("INVALID_ENDPOINT_CONFIGURATION", equalTo(INVALID_ENDPOINT_CONFIGURATION)),
//            Arguments.of("INVALID_ENDPOINT_SECURITY_CONFIGURATION", equalTo(INVALID_ENDPOINT_SECURITY_CONFIGURATION))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    void testCheckErrorTemplateTypeByValueOfWithClass(final String enumName,
//                                                      final Matcher<ErrorTemplateType> matcher) {
//        // then
//        assertThat(ErrorTemplateType.valueOf(ErrorTemplateType.class, enumName), matcher);
//    }
//
//    private static Stream<Arguments> testCheckErrorTemplateTypeByValueOfWithClass() {
//        return Stream.of(
//            Arguments.of("INVALID_DATA", equalTo(INVALID_DATA)),
//            Arguments.of("SERVICE_UNAVAILABLE", equalTo(SERVICE_UNAVAILABLE)),
//            Arguments.of("SERVICE_OPERATION_ERROR", equalTo(SERVICE_OPERATION_ERROR)),
//            Arguments.of("BAD_REQUEST", equalTo(BAD_REQUEST)),
//            Arguments.of("DOCUMENT_PROCESSING_ERROR", equalTo(DOCUMENT_PROCESSING_ERROR)),
//            Arguments.of("INVALID_ENDPOINT_CONFIGURATION", equalTo(INVALID_ENDPOINT_CONFIGURATION)),
//            Arguments.of("INVALID_ENDPOINT_SECURITY_CONFIGURATION", equalTo(INVALID_ENDPOINT_SECURITY_CONFIGURATION))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    void testCheckErrorTemplateTypeWhenPassedCode(final String enumCode,
//                                                  final Matcher<ErrorTemplateType> matcher) {
//        // then
//        assertThat(ErrorTemplateType.findByCode(enumCode), matcher);
//    }
//
//    private static Stream<Arguments> testCheckErrorTemplateTypeWhenPassedCode() {
//        return Stream.of(
//            Arguments.of("error-0020", equalTo(INVALID_DATA)),
//            Arguments.of("error-0030", equalTo(SERVICE_UNAVAILABLE)),
//            Arguments.of("error-0040", equalTo(SERVICE_OPERATION_ERROR)),
//            Arguments.of("error-0050", equalTo(BAD_REQUEST)),
//            Arguments.of("error-0060", equalTo(DOCUMENT_PROCESSING_ERROR)),
//            Arguments.of("error-0070", equalTo(INVALID_ENDPOINT_CONFIGURATION)),
//            Arguments.of("error-0080", equalTo(INVALID_ENDPOINT_SECURITY_CONFIGURATION))
//        );
//    }
//
//    @Test
//    void testCheckErrorTemplateType_whenPassedNonExistedType() {
//        // given
//        final String errorMessage = "No enum constant";
//
//        // when
//        final IllegalArgumentException thrown = assertThrows(
//            IllegalArgumentException.class,
//            () -> ErrorTemplateType.valueOf("NON_EXISTED")
//        );
//
//        // then
//        assertThat(thrown.getMessage(), startsWith(errorMessage));
//    }
//
//    private static String getFormattedString(final String errorCode,
//                                             final String errorMessage) {
//        return String.format("Code: {%s}, message: {%s}", errorCode, errorMessage);
//    }
//
//    private static CustomTypeSafeMatcher<ErrorTemplateType> createTypeMatcher(final String code,
//                                                                              final String message) {
//        return new CustomTypeSafeMatcher<ErrorTemplateType>(format("Comparing error code={%s} and description message={%s}", code, message)) {
//            /**
//             * Subclasses should implement this. The item will already have been checked for
//             * the specific type and will never be null.
//             *
//             * @param item - initial input {@link ErrorTemplateType} to operate by
//             */
//            @Override
//            protected boolean matchesSafely(final ErrorTemplateType item) {
//                return StringUtils.equals(item.getCode(), code)
//                    && StringUtils.equals(item.getMessage(), message);
//            }
//        };
//    }
//
//    private static Function<ErrorTemplateType, CustomTypeSafeMatcher<ErrorTemplateType>> createTypeMatcher() {
//        return value -> new CustomTypeSafeMatcher<ErrorTemplateType>(format("Comparing error template type={%s}", value)) {
//            /**
//             * Subclasses should implement this. The item will already have been checked for
//             * the specific type and will never be null.
//             *
//             * @param item - initial input {@link ErrorTemplateType} to operate by
//             */
//            @Override
//            protected boolean matchesSafely(final ErrorTemplateType item) {
//                return item.ordinal() == value.ordinal()
//                    && StringUtils.equals(item.name(), value.name())
//                    && StringUtils.equals(item.getCode(), value.getCode())
//                    && StringUtils.equals(item.getMessage(), value.getMessage());
//            }
//        };
//    }
//}
