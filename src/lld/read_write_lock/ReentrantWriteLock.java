package lld.read_write_lock;

public class ReentrantWriteLock implements Lock {

    private LockStatistics stats;

    public ReentrantWriteLock(LockStatistics stats) {
        this.stats = stats;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        stats.getWriteRequests().getAndIncrement();
        Thread currentThread = Thread.currentThread();
        while (!canGrantWriteAccess(currentThread)) {
            wait();
        }
        stats.setWritingThread(currentThread);
        stats.getWriteAccesses().getAndIncrement();
        stats.getWriteRequests().getAndDecrement();
    }

    @Override
    public synchronized void unlock() throws InterruptedException {
        if(!isCurrentThreadWriting(Thread.currentThread())){
            throw new IllegalMonitorStateException("Calling Thread does not" +
                    " hold the write lock on this ReadWriteLock");
        }
        stats.getWriteAccesses().getAndDecrement();
        if (stats.getWriteAccesses().get() == 0) {
            stats.setWritingThread(null);
        }
        notifyAll();
    }

    private boolean canGrantWriteAccess(Thread currentThread) {
        if (isOnlyReader(currentThread)) return true;
        if (!stats.getReadingThreads().isEmpty()) return false;
        if (stats.getWritingThread() == null) return true;
        if (!isCurrentThreadWriting(currentThread)) return false;
        return true;
    }

    private boolean isCurrentThreadWriting(Thread thread) {
        return thread == stats.getWritingThread();
    }

    private boolean isOnlyReader(Thread currentThread) {
        return stats.getReadingThreads().size() == 1 && stats.getReadingThreads().get(currentThread) != null;
    }
}
