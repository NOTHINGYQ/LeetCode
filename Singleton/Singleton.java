/**
    双重检查模式，线程安全
 */
public class Singleton {
    //1 volatile修饰
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) { //2 减少不必要同步，优化性能
            //3 同步，线程安全
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton(); //4传教single对象
                }
            }
        }
        return singleton;
    }
}