public class BeerConsumer extends Thread {
    BeerHouse house;

    public BeerConsumer(BeerHouse house) {
        super();
        this.house = house;
    }

    public void run(){
        while(true){
            int consume = house.getBeer();
            System.out.println("Se ha consumido "+ consume+" cervezas");
        }
    }
}
