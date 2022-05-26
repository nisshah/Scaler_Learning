package lld.read_write_lock;

public interface ReadWriteLock {

    Lock getReadLock();

    Lock getWriteLock();
}
