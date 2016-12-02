package adityajoshee.java8;

import java.util.LinkedHashMap;

/**
 * Created by aditya on 9/22/16.
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {

    private static long serialVersionUID = 1L;
    private int capacity = 100;

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        // Remove the eldest element whenever size of cache exceeds the capacity
        return (size() > this.capacity);
    }

    public LRU(int capacity) {
        // Call constructor of LinkedHashMap with accessOrder set to true to
        // achieve LRU Cache behavior
        super(capacity + 1, 1.0f, true);
        this.capacity = capacity;
    }
    public void set(K key, V value) {
        super.put(key, value);
    }
    public V find(K key) {
        return super.get(key);
    }
    public static void main(String[] args) {
        // Create the cache with capacity 2
        LRU<Integer, Integer> cache = new LRU<>(2);

        cache.set(2, 1); // Will add an element with key as 2 and value as 1
        cache.set(3, 2); // Will add an element with key as 3 and value as 2

        // Will add an element with key as 4 and value as 3. Also will remove
        // the element with key 2 as it was added least recently and cache can
        // just have two elements at a time
        cache.set(4, 3);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.find(2));

        // It will return value 2 and move the element with key 3 to the head.
        // After this point, element with key 4 will be least recently accessed
        System.out.println(cache.find(3));

        // Will add an element with key as 5 and value as 4. Also will remove
        // the element with key 4 as it was accessed least recently and cache
        // can just have two elements at a time
        cache.set(5, 4);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.find(4));
    }

}
