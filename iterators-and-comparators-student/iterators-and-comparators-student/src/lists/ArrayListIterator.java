/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayListIterator<E> implements Iterator<E> {
    private ArrayList<E> list;
    private int currentIndex;

    public ArrayListIterator(ArrayList<E> list){
        this.list = list;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        E element = list.get(currentIndex);
        currentIndex++;
        return element;
    }
}
