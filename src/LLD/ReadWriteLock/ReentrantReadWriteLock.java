package LLD.ReadWriteLock;

public class ReentrantReadWriteLock implements ReadWriteLock {

    private LockStatistics stats;

    public ReentrantReadWriteLock(LockStatistics stats) {
        this.stats = stats;
    }

    @Override
    public Lock getReadLock() {
        return new ReentrantReadLock(stats);
    }

    @Override
    public Lock getWriteLock() {
        return new ReentrantWriteLock(stats);
    }
}
