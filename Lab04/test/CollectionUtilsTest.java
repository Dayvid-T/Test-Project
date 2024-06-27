import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


class CollectionUtilsTest {
    @ParameterizedTest
    @MethodSource("generator")
    void containsAny(String description, Collection<?> coll1, Collection<?> coll2, boolean expected) {
        boolean result = CollectionUtils.containsAny(coll1, coll2);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(Arguments.of("Test Contains Any With Intersection In First Collection", Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), true),
                Arguments.of("Test Contains Smaller First Collection With Intersection", Arrays.asList(1, 2), Arrays.asList(2, 4, 5), true),
                Arguments.of("Test Contains Smaller First Collection Without Intersection", Arrays.asList(1, 6), Arrays.asList(2, 4, 5), false),
                Arguments.of("Test Contains Smaller Second Collection With Intersection", Arrays.asList(2, 4, 5), Arrays.asList(1, 2), true),
                Arguments.of("Test Contains Smaller Second Collection Without Intersection",  Arrays.asList(3, 4, 5),Arrays.asList(1, 2), false),
                Arguments.of("Test Contains Any With Intersection In Second Collection", Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 6, 7, 8), true),
                Arguments.of("Test Contains Any With No Intersection", Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), false),
                Arguments.of("Test Contains Any With First Collection Empty",Collections.emptyList(),Arrays.asList(1, 2, 3), false),
                Arguments.of("Test Contains Any With Second Collection Empty", Arrays.asList(1, 2, 3), Collections.emptyList(), false),
                Arguments.of("Test Contains Any With Both Collections Empty", Collections.emptyList(), Collections.emptyList(), false),
                Arguments.of("Test Contains Any With Same Collection", Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), true)
           
        );
    }
}