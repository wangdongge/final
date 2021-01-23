package queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) {
        BlockingDeque<Integer> bq = new LinkedBlockingDeque<>(10);
        Producer p = new Producer(bq);
        Consumer c = new Consumer(bq);
        new Thread(p).start();
        new Thread(c).start();
    }
}
