public class Main {
    public static void main(String[] args) {
        BeerHouse house = new BeerHouse();
        BeerProducer producer = new BeerProducer(house);
        BeerConsumer consumer = new BeerConsumer(house);

        System.out.println("empezo!");
        producer.start();
        consumer.start();
    }
}
