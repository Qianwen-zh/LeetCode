package juc;

//创建两个线程交替打印 1 到 100
class TurnsPrintRunnable implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (num <= 100) {
            synchronized (this) {
                notify();
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class TurnsPrint {
    public static void main(String[] args) {
        TurnsPrintRunnable num = new TurnsPrintRunnable();
        Thread thread1 = new Thread(num);
        Thread thread2 = new Thread(num);
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }

}

