/*
 * Copyright 2023 Marc Liberatore.
 */
package hashmaps;

import java.util.HashSet;
import java.util.Set;

import hashtables.ChainingHashTable;



/**
 * An implementation of a SimpleMap, built using the ChainingHashTable and 
 * SimpleMapEntry classes. This class should behave similarly to the built-in
 * java.util.HashMap, though it is much simpler!
 */
public class SimpleHashMap<K, V> implements SimpleMap<K, V> {
    private ChainingHashTable<SimpleMapEntry<K, V>> table;

    public SimpleHashMap() {
        table = new ChainingHashTable<>();
    }

    @Override
    public int size() {
        return table.size();
    }

 
    @Override
    public void put(K k, V v) {
        SimpleMapEntry<K, V> entry = new SimpleMapEntry<>(k, v);
        if (table.contains(entry)) table.remove(entry);
        table.add(entry);
    }

    @Override
    public V get(K k) {
        for (SimpleMapEntry<K, V> entry : table) {
            if (entry.k.equals(k)) {
                return entry.v;
            }
        }
        return null;
    }

    @Override
    public V getOrDefault(K k, V defaultValue) {
        for (SimpleMapEntry<K, V> entry : table) {
            if (entry.k.equals(k)) {
                return entry.v;
            }
        }
        return defaultValue;
    }

    @Override
    public V remove(K k) {
        for (SimpleMapEntry<K, V> entry : table) {
            if (entry.k.equals(k)) {
                table.remove(entry);
                return entry.v;
            }
        }
        return null;
    }

    @Override
    public Set<K> keys() {
        Set<K> keySet = new HashSet<>();
        for (SimpleMapEntry<K, V> entry : table) {
            keySet.add(entry.k);
        }
        return keySet;
    }  
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (SimpleMapEntry<K, V> entry : table) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.toString());
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
