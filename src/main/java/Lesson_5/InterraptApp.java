package Lesson_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterraptApp {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread.sleep(1500);
        thread.interrupt();

    }
    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
//            boolean interrapted = false;
            for (int i = 0; i < 10; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
//                    interrapted = true;
                }
            }
        }
    }
}
