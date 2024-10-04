import Lesson7.MarkingAnnotation;
import Lesson_6.HWLesson6;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class afterFourArrayTest {

    HWLesson6 array = new HWLesson6();

    @BeforeEach
    @AfterEach
    @Test
    @BeforeAll
    @AfterAll

    public static Stream<Arguments> subSource() {
        List<Arguments> args = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(20);
            }
            arr[arr.length - random.nextInt(7) - 1] = 4;
            List<Integer> listExpected = new LinkedList<>();
            for (int ii : arr) {
                listExpected.add(ii);
                if (ii == 4) {
                    listExpected.clear();
                }
            }

            args.add(Arguments.of(arr, listExpected));
        }
        return args.stream();
    }

    @ParameterizedTest
    @MethodSource("subSource")
    void afterFourArray(int[] arr, List<Integer> expected) {
        assertEquals(expected, array.afterFourArray(arr));
//        assertThrows(RuntimeException.class,()-> array.afterFourArray(arr).contains(4));
//        assertThrows(RuntimeException.class, () -> array.afterFourArray(arr).isEmpty());
    }

}
