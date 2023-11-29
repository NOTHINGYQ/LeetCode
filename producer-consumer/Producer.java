import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable{
    private Queue<Product> queue;
    private int maxCapacity;

    public Producer(Queue queue, int maxCapacity){
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }
    @Override
    public void run() {
        synchronized (queue){
            //必须用while而不是if
            while(queue.size() == maxCapacity){
                try {
                    System.out.println("生产者"+Thread.currentThread().getName() + "等待中，queue已达到最大产量，无法生产");
                    queue.wait();
                    System.out.println("生产者" + Thread.currentThread().getName() + "退出等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //队列中的产品从无到有，需要通知消费者
            if (queue.size() == 0){
                queue.notifyAll();
            }
            Random random = new Random();
            Integer i = random.nextInt();
            queue.offer(new Product("产品" + i.toString()));
            System.out.println("生产者" + Thread.currentThread().getName() + "生产了产品：" + i.toString());
        }
    }
}
