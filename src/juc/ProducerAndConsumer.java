package juc;

// 多线程实现一个简单的生产者、消费者怎么实现
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 生产者线程
 */
class Producer implements Runnable{
    private List list;
    public Producer(List list){
        this.list=list;
    }
    @Override
    public void run() {
        while(true){
            Random random=new Random();
            synchronized(list){
                if(list.size()>0){ //表明集合中有元素，此线程等待
                    //可以是while
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(random.nextInt(100));//0-99的随机数；
                System.out.println(Thread.currentThread().getName()+"  "+list.get(0));
                list.notify(); //通知消费者，集合中已有元素。
            }
        }
    }
}
/*
 *  消费者线程
 */
class Consumer implements Runnable{
    private List list;
    public Consumer(List list){
        this.list=list;
    }
    @Override
    public void run() {
        while(true){
            synchronized (list){
                if(list.size()<1){//可以是while
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"  "+list.remove(0));
                list.notify();
            }
        }
    }
}
public class ProducerAndConsumer {
    public static void main(String[] args) {
        List list=new ArrayList();
        Thread thread1=new Thread(new Producer(list));
        thread1.setName("Producer");
        Thread thread2=new Thread(new Consumer(list));
        thread2.setName("......Consumer");
        thread2.start();
        thread1.start();
    }
}
