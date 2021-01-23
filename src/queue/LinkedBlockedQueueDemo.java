package queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockedQueueDemo {
    private static BlockingDeque<String> bq = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                //通过阻塞队列获取数据
                try {
                    //创建消费者线程
                    System.out.println("消费者线程准备从阻塞列队中获取数据...");
                    String data = bq.take();
                    System.out.println("消费者线程获取到了"+data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //启动消费者线程
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //让main线程充当生产者线程
        try {
            System.out.println("生产者线程向阻塞队列添加了数据");
            bq.put("asdadasd");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
