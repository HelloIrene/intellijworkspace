package Custom;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private int max;
    private List<Product> products;

    Shelf(int max) {
        this.max = max;
        products = new ArrayList<>();
    }

    public synchronized void in(Product product) {
        while (products.size() >= max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products.add(product);
        System.out.println(Thread.currentThread().getName() + "将一个产品放在了货架，当前产品数目为" + products.size());
        notifyAll();
    }

    public synchronized void out() {
        while (products.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products.remove(0);
        System.out.println(Thread.currentThread().getName() + "买走产品，当前货架上有产品数目为" + products.size());
        notifyAll();
    }
}
