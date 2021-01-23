package queue;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable{
    private BlockingDeque<Integer> bq;

    public Consumer(BlockingDeque<Integer> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true){
            try {
                int number = bq.take();
                System.out.println("消费者线程获取到了一个随机数:"+number);
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
