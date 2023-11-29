import java.util.HashMap;
import java.util.Map;

public class LRU2 {
    int size;
    int capacity;
    private Map<Integer, DoubleLinkedNode> map;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    public LRU2(int capacity){
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        DoubleLinkedNode node = map.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value){
        DoubleLinkedNode node = map.get(key);
        if(node == null){
            node = new DoubleLinkedNode(key, value);
            map.put(key,node);
            size++;
            addNode(node);
            if(size > capacity){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    class DoubleLinkedNode{
        DoubleLinkedNode next;
        DoubleLinkedNode prev;
        int key;
        int value;
        public DoubleLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private void moveToHead(DoubleLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    private void removeNode(DoubleLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(DoubleLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
}
