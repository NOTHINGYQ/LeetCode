/**
 * 饿汉式，多线程安全
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }
}
