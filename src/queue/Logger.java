package queue;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wangdongge
 */
public class Logger {
    //bq 用于存放日志
    private BlockingQueue<String> bq;
    private PrintWriter out;

    /**
     * 为记日志做准备工作
     * 1.创建一个阻塞队列
     * 2.创建一个指向日志文件的输出流
     * 3.启动日志的线程
     */
    public void open() throws FileNotFoundException {
        bq = new LinkedBlockingQueue<>(1000);
        out = new PrintWriter("log.txt");
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //从阻塞队列中获取日志
                        String info = bq.take();
                        //将日志写入文件
                        out.println(info);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        /**
         * 用户线程：默认情况下，创建的线程都是用户线程，只要用户线程
         * 守护线程：JVM如果发现只有守护线程在运行，则立即结束
         */
        //将记日志线程设置为守护线程
        t.setDaemon(true);
        //启动日志线程
        t.start();
    }

    /**
     * 记日志
     *
     * @param info
     */
    public void log(String info) {
        try {
            bq.put(info);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (out != null) {
            out.close();
        }
    }
}
