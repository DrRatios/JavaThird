package Lesson_5;

import java.util.concurrent.*;

public class ExecutorApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService SingleExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2);
//        ExecutorService CachedExecutorService = Executors.newCachedThreadPool();

        fixedExecutorService.execute(() -> System.out.println("ABC"));
        Future<?> abc = fixedExecutorService.submit(() -> System.out.println("ABC"));
        Future<String> submit = fixedExecutorService.submit(() -> "Callable String");

        Object object = abc.get();
        String string = submit.get();

        Future<Integer> intFurute = fixedExecutorService.submit(() -> 10/0);
        try {
            intFurute.get();
        } catch (ExecutionException e){
//            e.getCause().printStackTrace();
            throw new RuntimeException(e.getCause());
        } finally {
            fixedExecutorService.shutdown();
        }




    }
}
