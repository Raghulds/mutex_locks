import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter mainCounter = new Counter();
        ReentrantLock lock = new ReentrantLock();
        Adder adderInstance = new Adder(mainCounter, lock);
        Subtractor subtractorInstance = new Subtractor(mainCounter, lock);

        Thread t1 = new Thread(adderInstance);
        Thread t2 = new Thread(subtractorInstance);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value is " + mainCounter.count);
    }
}