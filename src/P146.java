import java.util.LinkedHashMap;
import java.util.Map;

public class P146 {

}

class LRUCache {
    private final int CAPACITY;
    LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int cap) {
        CAPACITY = cap;
        linkedHashMap = new LinkedHashMap<Integer, Integer>(cap, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }
}
