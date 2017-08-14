package Custom;

public class Customer extends Thread {
    private Shelf shelf;
    private int amout;

    public Customer(String name, Shelf shelf, int amout) {
        super(name);
        this.shelf = shelf;
        this.amout = amout;
    }

    @Override
    public void run(){
        for (int i = 1; i <=amout ; i++) {
            shelf.out();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
