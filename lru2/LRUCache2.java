import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache2<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> order;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new LinkedList<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        order.remove(key);
        order.addFirst(key);
        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            order.remove(key);
            order.addFirst(key);
        } else {
            if (cache.size() == capacity) {
                K removed = order.removeLast();
                cache.remove(removed);
            }
            cache.put(key, value);
            order.addFirst(key);
        }
    }
}

