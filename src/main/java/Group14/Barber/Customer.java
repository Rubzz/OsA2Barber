package Group14.Barber;

public class Customer implements Runnable {
    private boolean customerReady;
    private boolean customerDone;

    public Customer()   {

    }

    @Override
    public void run() {

    }

    public boolean isCustomerReady() {
        return customerReady;
    }

    public void setCustomerReady(boolean customerReady) {
        this.customerReady = customerReady;
    }

    public boolean isCustomerDone() {
        return customerDone;
    }

    public void setCustomerDone(boolean customerDone) {
        this.customerDone = customerDone;
    }
}
