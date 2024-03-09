public class Node<T> {
    T x;   
    Node<T> next;
}

int sum(Node n) {
    if (n is NULL ){
        return 0;
    }
    else{
        return sum(n.next) + n.number;
    }
}