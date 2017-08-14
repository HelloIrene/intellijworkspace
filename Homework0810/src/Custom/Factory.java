package Custom;

public class Factory extends Thread {
    private Shelf shelf;
    private int amout;

    public Factory(String name, Shelf shelf, int amout) {
        super(name);
        this.shelf = shelf;
        this.amout = amout;
    }

    @Override
    public void run() {
        for (int i = 1; i <= amout; i++) {
            Product product = new Product();
            shelf.in(product);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
