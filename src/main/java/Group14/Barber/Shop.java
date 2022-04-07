package Group14.Barber;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shop extends javax.management.monitor.Monitor {
    private final int customerLimit = 5;
    private int customers;

    public Shop()   {
        this.customers = 0;

    }

    public static void main(String[] args) {
        Shop s = new Shop();
        s.start();

        while(true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100)); // Sleep until next person gets in
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("Customer walks in");

            if (s.getCustomers() < s.getCustomerLimit()) {
                new Thread(new Customer()).start();
                s.setCustomers(s.getCustomers() + 1);
            } else {
                System.out.println("Customer walks out, as no seats are available");
            }
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public int getCustomerLimit() {
        return customerLimit;
    }


}
