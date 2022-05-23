public class HashMa<K, V> {

    //Hashmap implements// https://dzone.com/articles/custom-hashmap-implementation-in-java

    private Entry<K, V>[] buckets;
    private static final int INIT_CAPCITY = 1 << 4;

    private int size = 0;
    private double lf = 0.75;
    private int capacity = 16;

    public HashMa() {
        this(INIT_CAPCITY);
    }
    public HashMa(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[capacity];
    }


    // Put 
    public void put(K key, V value){

        if (size == lf * INIT_CAPCITY){
            // rehash
            Entry<K, V>[] old = buckets;
            capacity *= 2;
            size = 0;
            buckets = new Entry[capacity];

            for (Entry<K, V> entry : old){
                while(entry != null){
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }

        Entry<K, V> entry = new Entry(key, value, null);

        int bucket = getHash(key) % getBucketSize();

        Entry<K, V> existingBucket = buckets[bucket];

        if (existingBucket == null){
            buckets[bucket] = entry;
            size++;
        } else {
            
            while(existingBucket.next != null){
                if (existingBucket.key.equals(key)) {
                    existingBucket.value = value;
                    return;
                }
                existingBucket = existingBucket.next;
            }
            if (existingBucket.key.equals(key)){
                existingBucket.value = value;
            } else{
                existingBucket.next = entry;
                size++;
            }
        }
    }
    // Get
    public V get(K key) {

        Entry<K, V> entry = buckets[getHash(key)%getBucketSize()];

        while(entry != null){
            if (entry.key ==  key){
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }


    public int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    public int getBucketSize() {
        return buckets.length;
    }
}


class Entry<K,V> {
    final K key;
    V value;
    Entry<K,V> next;

    public Entry(K key, V value, Entry<K, V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
}