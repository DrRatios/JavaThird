package Lesson_4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WaitNotifyApp {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        int listSize = 10;
        List<String> list = new CopyOnWriteArrayList<>();

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (list.size() >= listSize) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                list.add("string");
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock) {
                    String s = list.remove(0);
                    System.out.println(s);
                    if (list.isEmpty()) {
                        lock.notifyAll();
                    }
                }
            }
        });
        consumer.start();
        producer.start();
        while (true) {
            Thread.sleep(1000);
            System.out.println("List size: " + list.size());
        }

    }
}
