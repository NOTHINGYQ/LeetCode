/**
 * 懒汉式，线程不安全
 */
public class Singleton3 {
    public Singleton3(){
    }
    private static Singleton3 instance;
    public static Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
