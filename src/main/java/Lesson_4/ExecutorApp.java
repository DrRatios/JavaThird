package Lesson_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> System.out.println("Hello World!"));
        executorService.shutdown();
    }
}
