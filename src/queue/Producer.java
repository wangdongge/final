package queue;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Producer implements Runnable{
    private BlockingDeque<Integer> bq;

    public Producer(BlockingDeque<Integer> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(true){
            int number = r.nextInt(9999);
            try {
                bq.put(number);
                System.out.println(
                        "生产者线程向阻塞队列中添加了一个随机数:"
                                + number);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
