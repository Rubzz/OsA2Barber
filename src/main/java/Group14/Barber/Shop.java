package Group14.Barber;

import javax.management.monitor.Monitor;

public class Shop extends Monitor {
    private static int customerLimit;
    private boolean barberChairAvailable;

    public Shop()   {
        barberChairAvailable = true;

    }

    public void addCustomer()    {
        new Customer();
        customerLimit++;
    }

    public void useBarberChair()    {
        if (barberChairAvailable)    {
            barberChairAvailable = false;
        }
        else System.out.println("Barber Chair unavailable");

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
