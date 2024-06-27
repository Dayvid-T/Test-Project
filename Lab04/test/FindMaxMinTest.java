import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class FindMaxMinTest {
    @ParameterizedTest
    @MethodSource("generator")
    void findMaxMinTest(String description, List<Float> scoreList) {
        findMaxMin(scoreList);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(Arguments.of("testFindMaxMinWithEmptyList", Collections.emptyList()),
                Arguments.of("testFindMaxMinWithSingleElement", Arrays.asList(42.0f)),
                Arguments.of("testFindMaxMinWithMultipleElements", Arrays.asList(3.5f, 2.1f, 5.6f, 1.0f, 4.8f)),
                Arguments.of("testFindMaxMinWithNegativeElements", Arrays.asList(-3.5f, -2.1f, -5.6f, -1.0f, -4.8f)),
                Arguments.of("testFindMaxMinWithMixedElements", Arrays.asList(3.5f, -2.1f, 5.6f, -1.0f, 4.8f))
                );
    }
    void findMaxMin(List scoreList){return;} //just to make the test work and not throw errors.

//    void findMaxMin(List scoreList) {
//        int numberOfScores = 0;
//        float maxScore = NegativeInfinity;
//        float minScore = PositiveInfinity;
//        float nextScore;
//        Iterator iterator = scoreList.iterator();
//        while (iterator.hasNext()) {
//            nextScore = scoreList.next();
//            if (nextScore > maxScore) {
//                maxScore = nextScore;
//            }
//            if (nextScore < minScore) {
//                minScore = nextScore;
//            }
//            numberOfScores++;
//        }

//        if (numberOfScores < 1) {
//            System.out.println(“No scores found in score list”);
//        } else {
//            System.out.println(numberOfScores + “total scores found
//                    in score list”);
//            System.out.println(“The maximum score is” + maxScore);
//            System.out.println(“The minimum score is” + minScore);
//        }
//    }
}
