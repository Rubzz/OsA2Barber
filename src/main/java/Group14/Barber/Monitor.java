package Group14.Barber;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    private final int customerLimit = 5;
    private int customers;
    private final Lock lock;
    private boolean customerReady;
    private boolean barberReady;
    private boolean customerDone;
    private boolean barberDone;

    public Monitor()   {
        this.customers = 0;
        lock = new ReentrantLock();
        customerReady = false;
        barberReady = true;
        customerDone = false;
        barberDone = false;
    }

    public void tryCutting()    {
        try {
            if (barberReady && customerReady)   {
                barberDone = false;
                customerDone = false;
                barberReady = false;
                customerReady = false;
                wait(1000);
                customers = customers - 1;
                barberDone = true;
                customerDone = true;
                barberReady = true;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCustomers() {
        return customers;
    }

    public int getCustomerLimit() {
        return customerLimit;
    }
}
