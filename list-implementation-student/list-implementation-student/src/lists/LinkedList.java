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
    Node<E> addition = new Node<>(e);
    if (head == null) {
        head = addition;
        tail = addition; 
    } else {
        tail.next = addition;
        tail = addition;
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

    Node<E> addition = new Node<>(e);
    if (index == 0) {
        addition.next = head;
        head = addition;
    } else {
        Node<E> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        addition.next = currentNode.next;
        currentNode.next = addition;
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
        E oldVal = currentNode.data;
        currentNode.data = e;
        return oldVal;
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

    public LinkedList<E> slice(int i, int j){
        LinkedList<E> new_link = new LinkedList<E>(); 
        if(i >= size){
            return new_link; 
        }
        for(int k = i; k < size; k++){
            if (k < j){
                new_link.add(list.get(i));
            }
        }
        return new_link; 
    }

    public LinkedList<E> repeat(E element, int count){
        LinkedList new_link = new LinkedList<E>();
        for(int i = 0; i < count; i++){
            new_link.add(element);
        }
        return new_link;
    }

    public LinkedList<E> range(int start, int stop, int step){

    }

    public Node<E> takeNth(int n) {
        Node<E> current = head;
        LinkedList<E> return_new = new LinkedList<E>;

        for (int i = 0; i < size; i ++){
            if(n == 0){
                return return_new.add(list.get(i));
            }
            if((i+1)%n == 0 && n!=0){
                return_new.add(list.get(i)); 
            }
        }
        return return_new; 
    }

    public LinkedList<E> flatten(LinkedList<LinkedList<E>> a){
        if a.head == null:
            return null;
        current = head;
        LINKED LIST new_return
        curr_list = a.head;
        else:
            for(int i = 0; i < a.size; i ++){
                curr_element = curr_list.head;
                for(int j= 0; j < curr_list.head;  j++){
                    if(e.get(i).get(j) != null){
                        new_return.add(e.get(i).get(j)); 
                    }
                }
            }
            return new_return
    }

    

    public LinkedList<E> partition(LinkedList<E> a, int n){
        if (n < size){
            throw error 
        }
        NEW LINKED LIST A
        
        int i = 0; 
        while (i < size):
        NEW LINKED LIST ADDITION; 

            for (int j= i ; j <= i+n && j < size ; j ++){
                addition.add(node.get(i);  
            }
            a.data = addition;
            i+= n;
            a = a.next
            
         return A;    
        }
    }

    
}
