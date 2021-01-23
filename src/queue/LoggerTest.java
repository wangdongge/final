package queue;

import java.io.FileNotFoundException;

/**
 * @author wangdongge
 */
public class LoggerTest {
    public static void main(String[] args) throws FileNotFoundException {
        Logger logger = new Logger();
        logger.open();
        logger.log("hello");
        logger.log("hehe...");
        logger.log("emmm...");
        logger.log("test");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.close();
    }
}
