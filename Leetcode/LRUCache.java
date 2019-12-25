import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LRUCache {
    
    private int capacity;
    private Map<Integer, Integer> map;
    private Set<Integer> keySet;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
        this.keySet = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        int ans = map.getOrDefault(key, -1);
        if (ans != -1) {
            keySet.remove(key);
            keySet.add(key);
        }
        return ans;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // update the key
            map.put(key, value);
            keySet.remove(key);
            keySet.add(key);
        } else if (map.size() < capacity) {
            map.put(key, value);
            keySet.add(key);
        } else {            
            int removedKey = keySet.iterator().next();
            keySet.remove(removedKey);            
            keySet.add(key);
            map.remove(removedKey);
            map.put(key, value);
        }
    }
}