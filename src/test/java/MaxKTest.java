import Lesson_6.LoggerApp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MaxKTest {

    @Test
    void maxKTestMoreThanK(){
        List<String> actual = LoggerApp.maxK();
        assertNotNull(actual);
        assertEquals(7, actual.size());
        assertEquals(actual,List.of("14","15","16","17","18","19","20"));
    }
}
