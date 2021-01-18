package niuke.thread;

class MultiThread extends Thread{
    @Override
    public void run(){
        System.out.println("MultiThread");
    }
}
class MultiRunable implements Runnable{
    @Override
    public void run(){
        System.out.println("MultiRunable");
    }
}