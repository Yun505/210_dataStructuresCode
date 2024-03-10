package recursion;

public class RecursionExercises {

    /**
     * sumOfDigits (both implementations) should return the sum of the
     * digits of its input, x.
     * 
     * If `x` is 1234, the function should return 1 + 2 + 3 + 4, that is, 10.
     * 
     * If `x` is 345, the function should return 3 + 4 + 5 = 12.
     * 
     * If `x` is 3, the function should return 3.
     * 
     * If `x` is negative, *ignore the minus sign*. For example, -12 and 12
     * should both return 3.
     */

    /**
     * Return the sum of the digits of `x`; your algorithm must be implemented
     * iteratively.
     * 
     * @param x
     * @return
     */
    static int sumOfDigitsIterative(int x) {
        return 0;
    }

    /**
     * Return the sum of the digits of `x`; your algorithm must be implemented
     * recursively. No explicit loops (`for`, `while`) or use of Streams are
     * allowed!
     * 
     * @param x
     * @return
     */
    static int sumOfDigitsRecursive(int x) {
        return 0;
    }

    /**
     * Returns the length of the linked list, starting from node.
     * Empty lists have length 0.
     * 
     * (Must traverse the list using recursion.)
     * 
     * @param node - the head of a list
     * @return the size (length) of the linked list, starting from node
     */
    static <E> int size(Node<E> node) {
        return 0;

    }

    /**
     * Returns the i-th Node in the linked list which starts at node,
     * or null if the list is empty.
     * 
     * (Must be implemente recursively.)
     * 
     * @param node - the head of a list
     * @param i
     * @return the i-th node of the list
     */
    static <E> Node<E> getNode(Node<E> node, int i) {
        return null;
    }
}
