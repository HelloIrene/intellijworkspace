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
        System.out.println(Thread.currentThread().getName() + "��һ����Ʒ�����˻��ܣ���ǰ��Ʒ��ĿΪ" + products.size());
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
        System.out.println(Thread.currentThread().getName() + "���߲�Ʒ����ǰ�������в�Ʒ��ĿΪ" + products.size());
        notifyAll();
    }
}
