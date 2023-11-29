import java.util.ArrayDeque;
import java.util.Queue;

public class Test {
    public static void main(String[] args){
        Queue<Product> queue = new ArrayDeque<>();
        int n = 10;
        for(int i = 0; i < n; i ++){
            new Thread(new Producer(queue,n)).start();
            new Thread(new Consumer(queue,n)).start();
        }
    }
}
