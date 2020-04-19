import java.util.Random;

public class BeerProducer extends Thread{
    BeerHouse house;
    Random r ;
    public BeerProducer(BeerHouse houser)
    {
        this.house = houser;
        this.r =  new Random();
    }

    public int product(){
        int low = 50;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        return result;
    }

    public void run(){
        int q = product();
        this.house.setBeer(q);
        System.out.println("Se recargo: "+q+" Cervezas");
    }
}
