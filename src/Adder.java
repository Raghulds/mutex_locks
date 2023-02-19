import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {

    int limit = 10000;
    ReentrantLock lock;
    Counter adderCount;
    Adder(Counter counter, ReentrantLock lock) {
        this.adderCount = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0;i<this.limit;i++) {
            lock.lock();
            System.out.println("Adder - Thread " + Thread.currentThread().getName() + " i = " + i);
            this.adderCount.count += i;
            lock.unlock();
        }
    }
}
