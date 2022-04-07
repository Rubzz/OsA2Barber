package Group14.Barber;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shop {

    public Shop()   {

    }

    public static void main(String[] args) {
        Monitor m = new Monitor();

        while(true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100)); // Sleep until next person gets in
            } catch (InterruptedException e) {
            }

            System.out.println("Customer walks in");

            if (m.getCustomers() < m.getCustomerLimit()) {
                new Thread(new Customer()).start();
            } else {
                System.out.println("Customer walks out, as no seats are available");
            }
        }
    }
}
