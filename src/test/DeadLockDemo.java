package test;

/**
 * @author wangdongge
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        MyThread th1 = new MyThread(user1, user2);
        MyThread th2 = new MyThread(user2, user1);
        th1.start();
        th2.start();
    }
}

class MyThread extends Thread {
    private User user1;
    private User user2;

    public MyThread(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    @Override
    public void run() {
        synchronized (user1) {
            System.out.println(Thread.currentThread().getName() + "执行第一步操作。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (user2) {
                System.out.println(Thread.currentThread().getName() + "执行第二步操作。。。");
            }
        }
    }
}

class User {
}