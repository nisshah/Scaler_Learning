package os.multithreading.AdderSubtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Object> {

    private Counter counter;

    Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Object call() {
        for (int i = 0; i < 100000; i++) {
            this.counter.value.getAndIncrement();
        }
        return null;
    }
}
