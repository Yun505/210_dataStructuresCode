/*
 * Copyright 2023 Marc Liberatore.
 */
package hashmaps;

import java.util.Set;



/**
 * An implementation of a SimpleMap, built using the ChainingHashTable and 
 * SimpleMapEntry classes. This class should behave similarly to the built-in
 * java.util.HashMap, though it is much simpler!
 */
public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    public SimpleHashMap() {
    }

    @Override
    public int size() {
        return -1;
    }

    @Override
    public void put(K k, V v) {
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public V getOrDefault(K k, V defaultValue) {
        return null;
    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public Set<K> keys() {
        return null;
    }    
}
