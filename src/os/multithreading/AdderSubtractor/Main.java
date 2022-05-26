package os.multithreading.AdderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);

        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Object> adderFuture = service.submit(adder);
        Future<Object> subtractorFuture = service.submit(subtractor);

        try {
            adderFuture.get();
            subtractorFuture.get();
        } catch(Exception e) {
            System.err.println("Something wrong happened !!!");
        }

        System.out.println(counter.value);
        service.shutdown();

        if(!service.awaitTermination(100,TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}
