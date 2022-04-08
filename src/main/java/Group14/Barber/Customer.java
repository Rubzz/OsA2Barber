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

    /**
     * constructor for customer
     */
    public Customer() {
        lock = new ReentrantLock();
        state = new States[1];
        cond = new Condition[1];
        state[0] = States.waiting;
        cond[0] = lock.newCondition();
        customers += 1;

    }

    /**
     * returns the amount of customers as an integer
     * @return the amount of customers
     */
    public static int getCustomers() {
        return customers;
    }

    /**
     * sets the amount of customers as an integer
     * @param customerAmount amount of customers to set
     */
    public static void setCustomers(int customerAmount) {
        customers = customerAmount;
    }

    /**
     * returns the limit on how many customers can be in the shop at a time
     * @return the limit on customers
     */
    public static int getCustomerLimit() {
        return customerLimit;
    }
}
