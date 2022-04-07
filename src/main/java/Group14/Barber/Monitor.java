package Group14.Barber;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor extends javax.management.monitor.Monitor {
    private final int customerLimit = 5;
    private int customers;
    private final Lock lock;


    public Monitor()   {
        this.customers = 0;
        lock = new ReentrantLock();
    }

    public void tryCutting()    {
        Barber b = new Barber();
        Customer c = new Customer();
        lock.lock();
        try {
            if (b.isBarberReady() && c.isCustomerReady())   {
                c.setCustomerDone(false);
                b.setBarberReady(false);
                c.setCustomerReady(false);
                wait(1000);
                customers = customers - 1;
                c.setCustomerDone(true);
                b.setBarberReady(true);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
