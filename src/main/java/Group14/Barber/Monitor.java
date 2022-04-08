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



    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
