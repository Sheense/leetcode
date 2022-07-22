package sheen.leetcode.test;

/**
 * @Classname Test5
 * @Date 2022/4/13 10:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class Test5 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Test5.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Test5.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test5.print3();
            }
        }).start();
    }

    public static synchronized void print1() throws InterruptedException {
        System.out.println("加锁方法1");
        Thread.sleep(100 * 1000);
    }

    public static void print2() throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println("未加锁方法2");
        }
    }

    public static synchronized void print3() {
        System.out.println("加锁方法3");
    }
}
