import java.util.Random;

public class BeerHouse {
    private int beerq = 100;
    private boolean available = false;
    Random r = new Random();

    public synchronized void setBeer(int beer)
    {
        while(available)
        {
            try {
                wait();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Recargando");
        this.beerq = beer;
        this.available = true;
        notifyAll();
    }

    public synchronized int getBeer()
    {
        while(!available)
        {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("entra al get beer");
        int low = 1;
        int high = 10;
        int result = r.nextInt(high-low) + low;
        int beerConsume = result;
        if(beerq < beerConsume)
        {
            available =false;
            notifyAll();
        }else {
            beerq -= beerConsume;
            System.out.println("El stock de BeerHouse es : " + beerq);
        }
        return beerConsume;
    }
}
