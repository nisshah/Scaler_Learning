package LLD.ReadWriteLock;

public class ReentrantReadLock implements Lock {

    private LockStatistics stats;

    public ReentrantReadLock(LockStatistics stats) {
        this.stats = stats;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        if (!canGrantReadAccess(currentThread)) {
            wait();
        }
        stats.getReadingThreads().put(currentThread, stats.getReadingThreads().getOrDefault(currentThread, 0) + 1);
    }

    @Override
    public synchronized void unlock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        if (!isCurrentThreadReading(currentThread)) {
            throw new IllegalMonitorStateException("Calling Thread does not" +
                    " hold a read lock on this ReadWriteLock");
        }
        Integer accessCount = stats.getReadingThreads().getOrDefault(currentThread, 0);
        if (accessCount == 1) stats.getReadingThreads().remove(currentThread);
        else stats.getReadingThreads().put(currentThread, accessCount - 1);
        notifyAll();
    }

    private boolean canGrantReadAccess(Thread thread) {
        if (isCurrentThreadWriting(thread)) return true;
        if (stats.getWritingThread() != null) return false;
        if (isCurrentThreadReading(thread)) return true;
        if (stats.getWriteRequests().get() > 0) return false;
        return true;
    }

    private boolean isCurrentThreadWriting(Thread thread) {
        return thread == stats.getWritingThread();
    }

    private boolean isCurrentThreadReading(Thread thread) {
        return stats.getReadingThreads().get(thread) != null;
    }
}
