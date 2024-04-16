/*
 * Copyright 2023 Marc Liberatore.
 */

package treaps;

import java.util.ArrayList;
import java.util.List;

public class Treap<E extends Comparable<E>> {
    Node<E> root;
    int size;

    public int size() {
        return size;
    }

    /**
     * Return true iff the tree contains the value e.
     * 
     * @param e
     * @return true iff the tree contains the value e
     */
    public boolean contains(E e) {
        return find(e) != null;
    }

    private Node<E> find(E e, Node<E> n) {
        if (n == null) {
            return null;
        } else if (e.equals(n.data)) {
            return n;
        } else if (e.compareTo(n.data) < 0) { // left
            return find(e, n.left);
        } else { // right
            return find(e, n.right);
        }
    }

    private Node<E> find(E e) {
        return find(e, root);
    }

    /**
     * Perform an in-order traversal of the tree rooted at the given node, and
     * return
     * a list of the elements in the order they were visited.
     * 
     * @param node
     * @return a list of elements from the tree from an in-order traversal starting
     *         at node
     */
    static <E> List<E> inOrder(Node<E> node) {
        List<E> result = new ArrayList<>();
        inOrderTraversal(node, result);
        return result;
    }

    /**
     * Helper method to perform the in-order traversal recursively.
     * 
     * @param node   the current node being visited
     * @param result the list to store the traversal result
     */
    private static <E> void inOrderTraversal(Node<E> node, List<E> result) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, result);
        result.add(node.data);
        inOrderTraversal(node.right, result);
    }

    /**
     * Returns true iff the tree rooted at n is heap (based on its priority values).
     * 
     * It must have no more than two children per node.
     * 
     * Each node's priority value must be greater than or equal to all the values
     * in its children.
     * 
     * @param n true iff the tree rooted at n is a Binary Search Tree
     * @return
     */
    static <E extends Comparable<E>> boolean isHeap(Node<E> n) {
        if (n == null) {
            return true; // An empty tree is a heap
        }

        // Check if the node has left and right children
        if (n.left != null && n.right != null) {
            // Compare the priority value of the node with its children
            if (n.priority < n.left.priority || n.priority < n.right.priority) {
                return false; // The node's priority value is less than one of its children
            }
        } else if (n.left != null) {
            // Compare the priority value of the node with its left child
            if (n.priority < n.left.priority) {
                return false; // The node's priority value is less than its left child
            }
        } else if (n.right != null) {
            // Compare the priority value of the node with its right child
            if (n.priority < n.right.priority) {
                return false; // The node's priority value is less than its right child
            }
        }

        // Recursively check the left and right subtrees
        return isHeap(n.left) && isHeap(n.right);
    }

    /**
     * Add the value e to the treap, maintaining the BST and heap properties.
     * 
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            root = new Node<>(e);
            size = 1;
            return;
        }
        add(e, root);
    }

    /**
     * Add the value e to the treap rooted at the given node,
     * maintaining the BST and heap properties.
     * 
     * @param e
     * @param node
     */
    public void add(E e, Node<E> node) {
        addBST(e, node); // Add the new node according to the BST property
        restoreHeapProperty(find(e)); // Restore the max-heap property
    }

    /**
     * Add the value e to the treap rooted at the given node,
     * maintaining the BST property.
     * 
     * @param e    the value to add
     * @param node the root of the treap where the value should be added
     */
    private void addBST(E e, Node<E> node) {
        if (e.equals(node.data)) {
            node.data = e; // Update the existing node with the same value
        } else if (e.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(e, node);
                size++;
            } else {
                addBST(e, node.left); // Recursively add to the left subtree
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(e, node);
                size++;
            } else {
                addBST(e, node.right); // Recursively add to the right subtree
            }
        }
    }

    /**
     * Restore the max-heap property of the treap rooted at the given node.
     * 
     * @param node the root of the treap where the heap property should be restored
     */
    private void restoreHeapProperty(Node<E> node) {
        if (node == null || node.parent == null) return;
        while (node != root && node.parent != null &&  node.parent.priority < node.priority) {
            TreePrinter.print(node.parent);
            if (node.parent.left == node) {
                rotateRR(node); // Rotate right if the violated node is a left child
                
            } else {
                rotateLL(node); // Rotate left if the violated node is a right child
            }
            TreePrinter.print(node.parent);
        }
    }
    // public void add(E e, Node<E> node) {
    // // TODO! the BST add code below maintains the BST property,
    // // but you need to add the code to restore the max-heap property
    // //
    // // I suggest writing a separate method and calling it from here
    // // in the appropriate place(s)

    // if (e.equals(node.data)) {
    // node.data = e;
    // }
    // if (e.compareTo(node.data) < 0) {
    // if (node.left == null) {
    // node.left = new Node<>(e, node);
    // size++;
    // return;
    // } else {
    // add(e, node.left);
    // }
    // } else {
    // if (node.right == null) {
    // node.right = new Node<>(e, node);
    // size++;
    // return;
    // } else {
    // add(e, node.right);
    // }
    // }
    // }

    /**
     * Perform an LL rotation around n.
     * 
     * @param n
     */
    private void rotateLL(Node<E> n) {
       Node<E> A = n.parent;
       if (A == root) {
        n.parent = null;
        root = n;
       }

       else {
        if (A == A.parent.left) {
            n.parent = A.parent;
            A.parent.left = n;
        }
        else {
            n.parent = A.parent;
            A.parent.right = n;
        }
       }
       A.parent = n;
       A.right = n.left;
       if (n.left != null) {
        n.left.parent = A;
       }
       
        n.left = A;
    }

    /**
     * Perform an RR rotation around n.
     * 
     * @param n
     */
    private void rotateRR(Node<E> n) {
        Node<E> A = n.parent;
       if (A == root) {
        n.parent = null;
        root = n;
        
       }

       else {
        if (A == A.parent.left) {
            n.parent = A.parent;
            A.parent.left = n;
        }
        else {
            n.parent = A.parent;
            A.parent.right = n;
        }
       }
       A.parent = n;
        A.left = n.right;

        if (n.right != null) {
            n.right.parent = A;
        }
        
        n.right = A;
    }

    public static boolean isBST(Node<Integer> node) {
        if (node == null) {
            return true;
        }

        boolean ans = true;

        if (node.left != null) {
            ans = ans && node.left.data.compareTo(node.data) < 0;
        }

        if (node.right != null) {
            ans = ans && node.right.data.compareTo(node.data) > 0;
        }

        return ans && isBST(node.left) && isBST(node.right);
    }

    public static void main(String[] args) {
        Treap<Integer> t = new Treap<>();

        for (int i = 0; i < 15; i++) {
            t.add(i);
            TreePrinter.print(t.root);
            // System.out.println(isBST(t.root) + "/" + isHeap(t.root));
        }
    }
}
