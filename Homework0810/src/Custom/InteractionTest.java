package Custom;

public class InteractionTest {
    public static void main(String[] args) {
        Shelf shelf = new Shelf(3);

        Factory factory1 = new Factory("AA",shelf,30);
        Factory factory2 = new Factory("BB",shelf,30);
        Factory factory3 = new Factory("CC",shelf,30);

        Customer customer1 =new Customer("¹Ë¿Í¼×",shelf,45);
        Customer customer2 =new Customer("¹Ë¿ÍÒÒ",shelf,45);

        factory1.start();
        factory2.start();
        factory3.start();

        customer1.start();
        customer2.start();

    }
}
