import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ComplexNumbersTest {
    @ParameterizedTest
    @MethodSource("generator")
    void complexAdd(String description, int a, int b, int expected) {
        int result = ComplexNumbers.complexAdd(a, b);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(Arguments.of("testComplexAddWhenALessThanTwo", 1, 5, -6), /* Kills replaced integer addition with subtraction and replaced int return with 0 mutations in the return (a+b) * -1 line */
                Arguments.of("testComplexAddWhenAEqualsTwo", 2, 5, 7), /* Kills negated conditional, changed boundary conditional, replaced integer addition with subtraction and replaced int return with 0 mutations in the if(a<2) and return a+b lines */
                Arguments.of("testComplexAddWhenAGreaterThanTwo", 3, 5, 8) /* Kills replaced integer addition with subtraction and replaced int return with 0 mutations in the return a+b line */
        );
    }
    // Are you able to achieve 100% mutation coverage?
    // Through the test suite above, yes, we are able to achieve full mutation coverage.
}
