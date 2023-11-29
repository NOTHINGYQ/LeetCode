/**
 * 静态内部类：也是懒加载，线程安全，效率高
 */
public class Singleton5 {
    public Singleton5(){

    }
    public static Singleton5 getInstance(){
        return InnerClass.Instance;
    }
    private static class InnerClass{
        private final static Singleton5 Instance = new Singleton5();
    }
}
