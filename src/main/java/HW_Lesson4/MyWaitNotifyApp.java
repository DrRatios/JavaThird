package HW_Lesson4;

public class MyWaitNotifyApp {

    private final Object lock = new Object();
    private volatile char currentChar = 'A';

    public static void main(String[] args) throws InterruptedException {
        MyWaitNotifyApp app = new MyWaitNotifyApp();

        Thread t1 = new Thread(app::printA);
        Thread t2 = new Thread(app::printB);
        Thread t3 = new Thread(app::printC);
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentChar != 'A') {
                        lock.wait();
                    }
                    System.out.print("A");
                    currentChar = 'B';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentChar != 'B') {
                        lock.wait();
                    }
                    System.out.print("B");
                    currentChar = 'C';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentChar != 'C') {
                        lock.wait();
                    }
                    System.out.print("C");
                    currentChar = 'A';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



