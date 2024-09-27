package Lesson_5;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            int ii = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread: " + ii + " in front of semaphore");
                    semaphore.acquire();
                    System.out.println("Thread: " + ii + " after of semaphore");
                    Thread.sleep(500);

                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                finally {
                    System.out.println("Thread: " + ii + " realized semaphore");
                    semaphore.release();
                }
            }).start();
        }
    }
}
