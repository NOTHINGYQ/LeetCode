public class Method2 {
    private static int count = 0;
    private static final Object object = new Object();
    public static void main(String[] args){
        new Thread(new Printer()).start();
        new Thread(new Printer()).start();
    }
    static class Printer implements Runnable{

        @Override
        public void run() {
            while(count <= 10){
                synchronized (object){
                    if((count&1) == 0){
                        System.out.println("a");
                    }else{
                        System.out.println("b");
                    }
                    count++;
                    object.notify();
                    if(count < 10){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

}
