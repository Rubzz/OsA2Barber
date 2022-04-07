package Group14.Barber;

import java.util.concurrent.ThreadLocalRandom;

public class Barber implements Runnable{
    private boolean barberReady;

    public Barber() {
        barberReady = true;
    }

    @Override
    public void run() {
        while(true){
            try {
                cavailable.acquire();

                // Space freed up in waiting area
                System.out.println("Customer getting hair cut");

                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000 + 1000)); // Sleep to imitate length of time to cut hair
                System.out.println("Customer Pays and leaves");
                bavailable.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean isBarberReady() {
        return barberReady;
    }

    public void setBarberReady(boolean barberReady) {
        this.barberReady = barberReady;
    }

}
