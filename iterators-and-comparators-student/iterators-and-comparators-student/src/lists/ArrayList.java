/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    // Note: do not declare any additional instance variables
    E[] array;
    int size;

    public ArrayList() {
        size = 0;
        array = (E[]) new Object[10];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = prime * result + array[i].hashCode();
        }
        result = prime * result + size;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof List))
            return false;
        List other = (List) obj;
        if (size != other.size())
            return false;
        // TODO before returning true, make sure each element of the lists are equal!
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return null;
    }


    @Override
    public void add(E e) {
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int indexOf(E e) {
        return -1;
    }

    @Override
    public Iterator<E> iterator() {        
        return null;
    }
}