package lld.read_write_lock;

public interface Lock {

    void lock() throws InterruptedException;

    void unlock() throws InterruptedException;
}
