package Lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclingBarrierApp {

    public static void main(String[] args) {

        int threadCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int ii = i;
            new Thread(()->{

                try {
                    System.out.println("Thread " + ii + " is getting ready");
                    Thread.sleep(500 + 500 * ii);
                    System.out.println("Thread " + ii + " is ready");
                    cyclicBarrier.await();
                    Thread.sleep(500 + 500 * ii);
                    cyclicBarrier.await();
                    System.out.println("Thread " + ii + " is finished");
                    cyclicBarrier.await();
                    System.out.println("All Finished");

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
