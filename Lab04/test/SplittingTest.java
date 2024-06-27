import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


class SplittingTest {

    @ParameterizedTest
    @MethodSource("generator")
    void canBalance(String description, int[] nums, boolean expected) {
        boolean result = Splitting.canBalance(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(Arguments.of("Test Can Balance With Null Array", null, false),
                Arguments.of("Test Can Balance With Zero Array", new int[0], false),
                Arguments.of("Test Can Balance With Single Element Array", new int[]{1}, false),
                Arguments.of("Test Can Balance With Double Element Array", new int[]{1, 1}, true),
                Arguments.of("Test Can Balance With Triple Element Array", new int[]{1, 1, 2}, true),
                Arguments.of("Test Can Balance With Even Sum And Splittable", new int[]{1, 1, 1, 1, 1, 1, 4, 2}, true),
                Arguments.of("Rest Can Balance With Even Sum And Not Splittable", new int[]{1, 1, 1, 1, 4, 3}, false),
                Arguments.of("Test Can Balance With Odd Sum", new int[]{1, 1, 1, 1, 1}, false),
                Arguments.of("Test Can Balance With Splittable At Middle", new int[]{2, 2, 2, 2, 2, 2}, true),
                Arguments.of("Test Can Balance With Negative Numbers", new int[]{-1, 1, -1, 1, 0}, true),
                Arguments.of("Test Can Balance With Zeros", new int[]{0, 0, 0, 0}, true),
                Arguments.of("Test Can Balance With All Positive Numbers", new int[]{10, 20, 30, 40, 50, 60}, false),
                Arguments.of("Test Can Balance With All Negative Numbers", new int[]{-10, -20, -30, -40, -50, -60}, false),
                Arguments.of("Test Can Balance With Mixed Numbers", new int[]{10, -10, 20, -20, 30, -30}, true)

        );
    }
}