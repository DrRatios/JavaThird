import Lesson_6.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc;

    public static Stream<Arguments> subSource() {
        List<Arguments> args = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int result = a - b;
            args.add(Arguments.of(a, b, result));
        }
        return args.stream();
    }

    //где All, те методы тестов должны быть статическими
    @BeforeAll
    static void beforeAll() {
        System.out.println("Перед всеми");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("После всех");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Создали калькулятор");
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Почистили ресурсики");
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "10,15,25",
            "10,25,35"
    })
    @DisplayName("Проверяет корректность сложения, параметризованный тест")
    void testAdditionParam(int a, int b, int result) {
        System.out.println("Проверили корректность сложения параметризованным тестом");

        assertEquals(result, calc.sum(a, b), "Sum should be 15");
    }

    @Test
    @DisplayName("Проверяет корректность сложения")
    void testAddition() {
        System.out.println("Проверили корректность сложения");
        int sum = calc.sum(5, 10);
        assertEquals(15, sum, "Sum should be 15");
    }

    @Test
    @DisplayName("Проверяет корректность вычитания")
    void testSubtraction() {
        System.out.println("Проверили корректность вычитания");
        int sub = calc.sub(10, 5);
        assertTrue(sub == 5, "Sub should be 5");
    }

    @ParameterizedTest
    @MethodSource("subSource")
    @DisplayName("Проверяет корректность вычитания, параметризованный тест с сгенерированными ресурсами")
    void testSubtractionParam(int a, int b, int result) {
        System.out.println("Проверили корректность вычитания, параметризованный тест с сгенерированными ресурсами");
        assertEquals(result, calc.sub(a, b));
    }

    @Test
    @DisplayName("Проверяет разрешённый таймаут")
    @Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
    void testTimeout() {
        System.out.println("Проверили корректность выполнения таймаута");
        assertEquals(9, calc.lazySum(3, 6));
    }

    @Test
    @DisplayName("Проверяет деление на ноль")
    void testDivByZero(){
        System.out.println("Проверили корректность выброса исключения деления на ноль");
        //то есть мы ожидаем конкретное исключение, если оно не произошло, то будет провал теста.
        assertThrows(ArithmeticException.class, ()->calc.div(4,0));
    }


}
