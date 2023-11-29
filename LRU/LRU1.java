import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class LRU1 extends LinkedHashMap {
    private int capacity;
    public LRU1(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    public int get(int key){
        return (int)super.getOrDefault(key,-1);
    }
    public void put(int key, int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }
}
