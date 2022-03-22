package Group14.Barber;

public class Shop {
    private static int customerLimit;

    public Shop()   {

    }

    public void addCustomer()    {
        new Customer();
        customerLimit++;
    }
}
