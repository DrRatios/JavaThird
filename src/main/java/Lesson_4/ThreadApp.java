package Lesson_4;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadApp {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
        System.out.println("from " + Thread.currentThread().getName());
        Thread thread3 = new MyThread();
        thread3.start();
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("from AnonClass " + Thread.currentThread().getName());
            }
        });
        thread4.start();

        Thread thread5 = new Thread(() -> System.out.println("from lambda " + Thread.currentThread().getName()));
        thread5.start();

        printDoubledString(new SimpleInterface() {
            @Override
            public String doubleString(String string) {
                return string+string;
            }
        },"TestString");

        printDoubledString(string -> string+string,"TestString");

        testDouble((s1, s2) -> s1+" "+s2);

//        IntHolder intHolder = new IntHolder();

        AtomicInteger intHolder = new AtomicInteger(); //CAS - compare and swap,
        // то есть перед выполнением метода мы проверяем изменялось ли
        // значение относительно нашим условиям по увеличению переменной (надо увеличить нам ровно на 10 000)
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                intHolder.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 10000; i++) {
                intHolder.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(intHolder.get());

    }
    private static void testDouble(DoubleParamInterface doubleParamInterface) {
        System.out.println(doubleParamInterface.concat("Лёлик","Болик"));
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("from " + Thread.currentThread().getName());
        }
    }

    public static void printDoubledString(SimpleInterface simpleInterface, String string){
        System.out.println(simpleInterface.doubleString(string));
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("from " + Thread.currentThread().getName());
        }
    }
    private static class IntHolder{
        int integer;

        public IntHolder() {
            this.integer = 0;
        }
        public int getInteger() {
            return integer;
        }
        public void inc(){
            integer++;
        }
        public void dec(){
            integer--;
        }
    }
}
