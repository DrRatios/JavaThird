package Lesson_5;

import java.util.concurrent.CountDownLatch;

public class SimpleCDL {

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(threadCount);

        System.out.println("Begin");
        for (int i = 0; i < threadCount; i++) {
            int ii = i;
            new Thread(()->{
                try {
                    Thread.sleep(500 + 200 * ii);
                    latch.countDown();

                    System.out.println("Thread " + ii + " is ready");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
        latch.await();
        System.out.println("Competed " + threadCount + " threads");
    }
}
