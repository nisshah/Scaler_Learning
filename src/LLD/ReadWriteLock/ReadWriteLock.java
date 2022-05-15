package LLD.ReadWriteLock;

public interface ReadWriteLock {

    Lock getReadLock();

    Lock getWriteLock();
}
