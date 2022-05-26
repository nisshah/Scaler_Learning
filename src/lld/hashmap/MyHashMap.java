package lld.hashmap;

@SuppressWarnings("ALL")
public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private final int capacity;
    private final Entry[] table;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        int hash = hash(key);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> curr = table[hash];
            Entry<K, V> prev = null;
            while (curr != null && curr.next != null) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = newEntry;
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hash = hash(key);
        if (table[hash] != null) {
            Entry<K, V> curr = table[hash];
            while (curr != null) {
                if (curr.key == key) {
                    return curr.value;
                }
                curr = curr.next;
            }
        }
        return null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
