package OS.AdderSubtractor;

import java.util.concurrent.Callable;

public class Subtractor implements Callable {

    private Counter counter;

    Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Object call() {
        for (int i = 0; i < 100000; i++) {
            this.counter.value.getAndDecrement();
        }
        return null;
    }
}
