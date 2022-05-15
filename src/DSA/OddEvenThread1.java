package DSA;

import java.util.ArrayList;
import java.util.List;

public class OddEvenThread1 {
    public static int threadCnt = 3;
    private static int counter = 1;
    private static final int N = 20;
    private static Object lock = new Object();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCnt; i++) {
            threads.add(new Thread(new Printer((i + 1) % threadCnt), (i + 1) + "-Thread"));
        }
        threads.stream().forEach(t -> t.start());
    }

    static class Printer implements Runnable {
        private final int remainder;

        public Printer(int remainder) {
            this.remainder = remainder;
        }

        public void run() {
            synchronized (lock) {
                while (counter <= N) {
                    while (counter % threadCnt != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    print();
                }
            }
        }

        private void print() {
            System.out.println(Thread.currentThread().getName() + " " + counter++);
            lock.notifyAll();
        }
    }
}

