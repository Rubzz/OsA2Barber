package Group14.Barber;

public class Barber implements Runnable{
    private boolean barberDone;
    private boolean barberReady;

    public Barber() {
        barberDone = false;
        barberReady = true;
    }

    @Override
    public void run() {

    }

    public boolean isBarberReady() {
        return barberReady;
    }

    public void setBarberReady(boolean barberReady) {
        this.barberReady = barberReady;
    }

    public boolean isBarberDone() {
        return barberDone;
    }

    public void setBarberDone(boolean barberDone) {
        this.barberDone = barberDone;
    }
}
