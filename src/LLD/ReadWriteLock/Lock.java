package LLD.ReadWriteLock;

public interface Lock {

    void lock() throws InterruptedException;

    void unlock() throws InterruptedException;
}
