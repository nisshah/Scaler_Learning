package os.multithreading;

public class OddEvenThread {
    int counter = 1;
    private static final int N = 10;
    private Object lock = new Object();

    public static void main(String[] args) {
        OddEvenThread obj = new OddEvenThread();
        obj.print();
    }

    private void print() {
        Thread t1 = new Thread(new OddPrinter(), "T1-Thread");
        Thread t2 = new Thread(new EvenPrinter(), "T2-Thread");
        t2.start();
        t1.start();
    }

    class OddPrinter implements Runnable {
        public void run() {
            while (counter < N) {
                synchronized (lock) {
                    while (counter % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.err.println("Exception occurred !!!");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + counter++);
                    lock.notify();
                }
            }
        }
    }

    class EvenPrinter implements Runnable {
        public void run() {
            while (counter <= N) {
                synchronized (lock) {
                    while (counter % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.err.println("Exception occurred !!!");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + counter++);
                    lock.notify();
                }
            }
        }
    }
}
