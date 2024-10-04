import Lesson7.SimpleTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleTaskApp {

    SimpleTask simpleTask;

    @BeforeEach
    void init() {
        simpleTask = new SimpleTask();
    }

    @Test
    @DisplayName("Отрицательный максимум")
    void negativeMax() {
        int[] array = {-1, -2, -3};
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> simpleTask.findMax(array));
        assertEquals("Максимальное значение элемента массива отрицательное", illegalStateException.getMessage());
    }

    @Test
    @DisplayName("Нормальный сценарий")
    void positiveMax() {
        int[] array = {-1, -2, 3};
        assertEquals(3, simpleTask.findMax(array));
    }
}
