package Group14.Barber;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barber implements Runnable{
    private enum States {sleeping, cutting, waiting};
    private States [] state;
    private Condition[] cond;
    final Lock lock;

    public Barber() {
        lock = new ReentrantLock();
        state = new States[1];
        cond = new Condition[1];
        state[0] = States.waiting;
        cond[0] = lock.newCondition();

    }

    @Override
    public void run()    {
        while (true) {
            lock.lock();
            try {

                    state[0] = States.waiting;
                    // Space freed up in waiting area
                    System.out.println("Customer getting hair cut");

                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000 + 1000)); // Sleep to imitate length of time to cut hair
                    System.out.println("Customer Pays and leaves");
                    Customer.setCustomers(Customer.getCustomers() - 1);
                    state[0] = States.waiting;

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public States[] getState() {
        return state;
    }
}
