/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

public class LinkedList<E> implements List<E> {
    // Note: do not declare any additional instance variables
    Node<E> head;
    Node<E> tail;
    int size;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Node<E> n = head;
        while (n != null) {
            result = prime * result + head.data.hashCode();
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
        for (int i = 0; i < size; i++) {
            if ((this.get(i) == null && other.get(i) != null) || (this.get(i) != null && other.get(i) == null)) {
                return false;
            }
            if (!(this.get(i).equals(other.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
public void add(E e) {
    Node<E> a = new Node<>(e);
    if (head == null) {
        head = a;
        tail = a; 
    } else {
        tail.next = a;
        tail = a;
    }
    size++;
}

@Override
public void add(int index, E e) throws IndexOutOfBoundsException {
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
    }
    if (index == size) {
        add(e);
        return; //basically checks if 8 (size) and i add it at 8 thing there's still 8 elements 
    }

    Node<E> a = new Node<>(e);
    if (index == 0) {
        a.next = head;
        head = a;
    } else {
        Node<E> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        a.next = currentNode.next;
        currentNode.next = a;
    }
    size++;
}

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node<E> removedNode = head;
            head = head.next;
            size--;
            return removedNode.data;
        } else {
            Node<E> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            Node<E> removedNode = currentNode.next;
            currentNode.next = removedNode.next;
            if (index == size - 1) {
                tail = currentNode;
            }
            size--;
            return removedNode.data;
        }
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        E a = currentNode.data;
        currentNode.data = e;
        return a;
    }

    @Override
    public int indexOf(E e) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.data.equals(e)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }
}
