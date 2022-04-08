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

    /**
     * constructor for barber
     */
    public Barber() {
        lock = new ReentrantLock();
        state = new States[1];
        cond = new Condition[1];
        state[0] = States.waiting;
        cond[0] = lock.newCondition();

    }

    /**
     * runs in the background while the application is running to control the actions of the barber
     */
    @Override
    public void run()    {
        while (true) {
            lock.lock();
            try {
                    if (Customer.getCustomers() > 0) {

                        state[0] = States.cutting;
                        System.out.println("Customer getting hair cut");

                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000 + 1000));
                        System.out.println("Customer Pays and leaves");
                        Customer.setCustomers(Customer.getCustomers() - 1);
                        state[0] = States.waiting;
                    }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
