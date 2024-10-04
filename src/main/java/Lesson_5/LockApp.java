package Lesson_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockApp {
    static Lock lock = new ReentrantLock();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            write();
            checkAndRealize();
        });
        executorService.submit(() -> {
            write();
            checkAndRealize();
        });
        executorService.submit(() -> {
            write();
            checkAndRealize();
        });
        executorService.shutdown();


    }

    static void write() {
        System.out.println("Try to get " + lock.tryLock() + " " + Thread.currentThread().getName());
        lock.lock();
        list.add("Hello");
    }

    static void checkAndRealize() {
        System.out.println(list.contains("Hello"));
        lock.unlock();
    }
}
