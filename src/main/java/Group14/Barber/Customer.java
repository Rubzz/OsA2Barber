package Group14.Barber;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Customer implements Runnable {
    private enum States {cutting, waiting}

    ;
    private States[] state;
    private Condition[] cond;
    final Lock lock;

    public Customer() {
        lock = new ReentrantLock();
        state = new States[1];
        cond = new Condition[1];
        state[0] = States.waiting;
        cond[0] = lock.newCondition();

    }

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                state[0] = States.cutting;
                // Space freed up in waiting area
                System.out.println("Customer getting hair cut");

                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000 + 1000)); // Sleep to imitate length of time to cut hair
                System.out.println("Customer Pays and leaves");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
