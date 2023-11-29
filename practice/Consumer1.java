import java.util.Queue;

public class Consumer1 implements Runnable{
    public  Queue<Integer> q;
    public int capacity;

    public Consumer1(int capacity, Queue<Integer> q){
        this.capacity = capacity;
        this.q = q;
    }

    @Override
    public void run() {
        synchronized (q){
            while(q.isEmpty()){
                System.out.println("消费者" + Thread.currentThread().getName() + "等待中... Queue 已缺货，无法消费");
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("消费者" + Thread.currentThread().getName() + "退出等待");

            }
            if(q.size() == capacity){
                q.notifyAll();
            }
            int num = q.poll();
            System.out.println("消费者" + Thread.currentThread().getName() + "消费了：" + num);

        }
    }
}
