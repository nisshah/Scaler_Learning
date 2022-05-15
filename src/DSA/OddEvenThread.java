package DSA;

public class OddEvenThread {
    int counter = 1;
    private static final int N = 10;

    public static void main(String[] args) {
        OddEvenThread obj = new OddEvenThread();

        Thread t1 = new Thread(obj::printOdd, "T1-Thread");
        Thread t2 = new Thread(obj::printEven, "T2-Thread");
        t2.start();
        t1.start();
    }

    private void printOdd() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.err.println("Exception occurred !!!");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                notify();
            }
        }
    }

    private synchronized void printEven() {
        synchronized (this) {
            while (counter <= N) {
                while (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.err.println("Exception occurred !!!");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                notify();
            }
        }
    }
}
