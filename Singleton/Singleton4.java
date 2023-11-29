/**
 * 懒汉式，线程安全
 */
public class Singleton4 {
    public Singleton4(){}
    private static Singleton4 instance;
    public synchronized static Singleton4 getInstance(){
        if(instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
