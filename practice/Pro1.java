import java.util.Queue;

public class Pro1 implements Runnable{
    public Queue<Integer> q;
    public int capacity;
    public Pro1(int capacity, Queue<Integer> q){
        this.capacity = capacity;
        this.q = q;
    }

    @Override
    public void run() {
        synchronized (q){
            while(q.size() == capacity){
                try {
                    System.out.println("生产者"+Thread.currentThread().getName() + "等待中，queue已达到最大产量，无法生产");
                    q.wait();
                    System.out.println("生产者" + Thread.currentThread().getName() + "退出等待");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(q.size() == 0){
                q.notifyAll();
            }
            int num = 1;
            q.add(1);
            System.out.println("生产者" + Thread.currentThread().getName() + "生产了产品：" + num);


        }
    }
}
