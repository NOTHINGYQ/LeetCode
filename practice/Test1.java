import java.util.ArrayDeque;
import java.util.Queue;

public class Test1 {
    public static void main(String[] ars){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i =0 ; i < 10; i ++){
            new Thread(new Pro1(10,q)).start();
            new Thread(new Consumer1(10,q)).start();
        }
    }
}
