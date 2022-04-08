package Group14.Barber;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shop extends javax.management.monitor.Monitor {


    public Shop()   {

    }

    public static void main(String[] args) {
        Shop s = new Shop();
        s.start();
        Barber barber = new Barber();
        System.out.println("Opening up shop");
        new Thread(barber).start();

        while(true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(200, 1000 + 200)); // Sleep until next person gets in
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("Customer walks in");

            if (Customer.getCustomers() < Customer.getCustomerLimit()) {
                Customer.setCustomers(Customer.getCustomers() + 1);
            } else {
                System.out.println("Customer walks out, as no seats are available");
            }
        }
    }

    @Override
    public void start() {
        Customer.setCustomers(0);

    }

    @Override
    public void stop() {

    }


}
