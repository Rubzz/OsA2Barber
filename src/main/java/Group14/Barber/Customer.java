package Group14.Barber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Customer{
    private static final int customerLimit = 5;
    private static int customers;
    private enum States {cutting, waiting};
    private States[] state;
    private Condition[] cond;
    final Lock lock;

    public Customer() {
        lock = new ReentrantLock();
        state = new States[1];
        cond = new Condition[1];
        state[0] = States.waiting;
        cond[0] = lock.newCondition();
        customers += 1;

    }

    public static int getCustomers() {
        return customers;
    }

    public static void setCustomers(int i) {
        customers = i;
    }

    public static int getCustomerLimit() {
        return customerLimit;
    }
}
