public class Method1{
    private static final Object object = new Object();
    private static int count;
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count < 10){
                    synchronized (object){
                        if((count&1)==0){
                            System.out.println("a");
                            count++;
                        }

                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 10){
                    if((count&1)==1){
                        synchronized (object){
                            System.out.println("b");
                            count++;
                        }
                    }

                }

            }
        }).start();
    }
}
