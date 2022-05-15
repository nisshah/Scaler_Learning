package LLD.ReadWriteLock;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class LockStatistics {

    private AtomicInteger writeRequests = new AtomicInteger(0);
    private AtomicInteger writeAccesses = new AtomicInteger(0);
    private HashMap<Thread, Integer> readingThreads = new HashMap<>();
    private Thread writingThread = null;

    public AtomicInteger getWriteRequests() {
        return writeRequests;
    }

    public AtomicInteger getWriteAccesses() {
        return writeAccesses;
    }

    public HashMap<Thread, Integer> getReadingThreads() {
        return readingThreads;
    }

    public Thread getWritingThread() {
        return writingThread;
    }

    public void setReadingThreads(HashMap<Thread, Integer> readingThreads) {
        this.readingThreads = readingThreads;
    }

    public void setWritingThread(Thread writingThread) {
        this.writingThread = writingThread;
    }
}
