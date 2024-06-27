import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {
    @ParameterizedTest
    @MethodSource("generator")
    void swapCase(String description, String str, String expected) {
        String result = WordUtilities.swapCase(str);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(Arguments.of("Test Swap Case With Null String", null, null),
                Arguments.of("Test Swap Case With Empty String", "", ""),
                Arguments.of("Test Swap Case With All Upper Case", "HELLO", "hello"),
                Arguments.of("Test Swap Case With All Lower Case", "hello", "HELLO"),
                Arguments.of("Test Swap Case With Mixed Case", "HeLLo WoRLD", "hEllO wOrld"),
                Arguments.of("Test Swap Case With Whitespace", " hello  world ", " HELLO  WORLD "),
                Arguments.of("Test Swap Case With Title Case", "Hello World", "hELLO wORLD"),
                Arguments.of("Test Swap Case With Special Characters", "hello123 WORLD!", "HELLO123 world!")
                
        );
    }
}