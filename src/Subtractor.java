import java.util.concurrent.locks.ReentrantLock;

public class Subtractor implements Runnable {

    int limit = 10000;
    ReentrantLock lock;
    Counter subtractorCounter;

    Subtractor(Counter counter, ReentrantLock lock) {
        this.subtractorCounter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0;i<this.limit;i++) {
            lock.lock();
            System.out.println("Subtractor - Thread " + Thread.currentThread().getName() + " i = " + i);
            this.subtractorCounter.count -= i;
            lock.unlock();
        }
    }
}
