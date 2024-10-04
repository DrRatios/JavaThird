import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class checkArrayContainsOneOrFourTest {

    public static Stream<Arguments> subSource() {
        List<Arguments> args = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= 4; i++) {
            int[] x = new int[rand.nextInt(10) + 1];
            for (int j = 0; j < x.length; j++) {
                x[j] = rand.nextInt(10);
            }
            args.add(Arguments.of(x));
        }
        return args.stream();
    }

    @ParameterizedTest
    @MethodSource("subSource")
    public void checkArrayContainsOneOrFour(int[] x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            list.add(x[i]);
        }
        assertTrue(list.contains(1) && list.contains(4),"array must contain 1 or 4");
    }
}
