package hashtables;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * An implementation of HashTable.
 * 
 * This implementation uses chaining to resolve collisions. Chaining means 
 * the underlying array stores references to growable structures (like 
 * LinkedLists) that we expect to remain small in size. When there is a 
 * collision, the element is added to the end of the growable structure. It
 * must search the entire growable structure whenever checking membership
 * or removing elements.
 * 
 * This implementation maintains a capacity equal to 2^n - 1 for some positive
 * integer n. When the load factor exceeds 0.75, the next add() triggers a
 * resize by incrementing n (by one). For example, when n=3, then capacity=7.
 * When size=6, then load factor ~=0.86. The addition of the seventh item would
 * trigger a resize, increasing the capacity of the array to 15.
 */
public class ChainingHashTable<E> implements HashTable<E> {
    private LinkedList<E>[] table;
    private int size;
    private int capacity;
    /**
     * Instantiate a new hash table. The initial capacity should be 7.
     */
    public ChainingHashTable() {
        this(7);
    }

    /**
     * Instantiate a new hash table. The initial capacity should be 
     * at least sufficient to hold n elements, but must be one less
     * than a power of two.
     */
    public ChainingHashTable(int n) {
        capacity =(int) Math.pow(2, (int) (Math.log(n)/Math.log(2)) + 1) - 1;
        table = (LinkedList<E>[]) new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double loadFactor() {
        return (double) size / capacity;
    }

    @Override
    public boolean add(E e) {
        if (loadFactor() > 0.75) {
            resize();
        }
        int index = getIndex(e);
        LinkedList<E> l = table[index];

        if (l.contains(e)) return false;

        l.add(e);
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        int index = getIndex(e);
        boolean removed = table[index].remove(e);
        if (removed) {
            size--;
        }
        return removed;
    }

    @Override
    public boolean contains(E e) {
        int index = getIndex(e);
        return table[index].contains(e);
    }

    @Override
    public E get(E e) {
        int index = getIndex(e);
        for (E element : table[index]) {
            if (element.equals(e)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new HashTableIterator();
    }
    private void resize() {
        int newCapacity = (capacity + 1) * 2 - 1;
        LinkedList<E>[] newTable = (LinkedList<E>[]) new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }
        for (LinkedList<E> chain : table) {
            for (E element : chain) {
                int index = element.hashCode() % newCapacity;
                newTable[index].add(element);
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    private int getIndex(E e) {
        return e.hashCode() % capacity;
    }

    private class HashTableIterator implements Iterator<E> {
        private int currentIndex = 0;
        private int ll_index = 0;

        @Override
        public boolean hasNext() {
            while (currentIndex < table.length) {
                if (table[currentIndex].isEmpty()) currentIndex++;
                else if (ll_index < table[currentIndex].size()) {
                    return true;
                }

                else {
                    ll_index = 0;
                    currentIndex++;
                }
            }
            return false;
        }

        @Override
        public E next() {
            if (!hasNext() && currentIndex >= capacity ) {
                throw new NoSuchElementException();
            }
            return table[currentIndex].get(ll_index++);
        }
    }
}
