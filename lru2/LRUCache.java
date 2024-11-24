import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        // 设置一个适当的负载因子以减少rehash操作
        // 第三个参数true表明LinkedHashMap按照访问顺序来排序，最近访问的在头部，最老访问的在尾部
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当Map中数据量大于指定缓存个数的时候，返回true，自动删除最老的数据
        return size() > capacity;
    }

    // 提供get和put方法
    public V get(Object key) {
        return super.get(key);
    }

    public V put(K key, V value) {
        return super.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(5); // 缓存最大容量为 5
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);
        cache.put("D", 4);
        cache.put("E", 5);
        System.out.println(cache);
        // 现在缓存已满
        cache.get("A"); // 访问元素 A，它会被移动到链表的末尾
        cache.put("F", 6); // 插入新元素 F，最久未使用的元素 B 会被移除
        System.out.println(cache); // 输出: {C=3, D=4, E=5, A=1, F=6}
    }
}