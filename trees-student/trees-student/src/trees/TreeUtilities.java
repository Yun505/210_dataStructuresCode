/*
 * Copyright 2023 Marc Liberatore.
 */
package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * A collection of utility methods for trees and their nodes.
 * 
 * You will almost certainly need to add some methods here to complete
 * the unimplemented methods!
 */
public class TreeUtilities {
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
        List<E> resultList = new ArrayList<>();
        inOrderTraversal(node, resultList);
        return resultList;
    }

    private static <E> void inOrderTraversal(Node<E> node, List<E> resultList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, resultList);
        resultList.add(node.data);
        inOrderTraversal(node.right, resultList);
    }

    /**
     * Returns the height of the node n.
     * 
     * null has a height of -1; otherwise, the height is defined as
     * 1 + the height of the larger of the node's two subtrees.
     * 
     * @param n
     * @return the height of the node n
     */
    static <E> int height(Node<E> n) {
        if (n == null || n.data == null) {
            return -1;
        }
        return heightTraversal(n);
    }

    private static <E> int heightTraversal(Node<E> n) {
        if (n == null) {
            return -1;
        }
        int leftHeight = heightTraversal(n.left);
        int rightHeight = heightTraversal(n.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Return a new, balanced tree containing all the values of the old tree bst.
     * 
     * @param bst
     * @return a new, balanced tree containing all the values of the old tree bst
     */

     static <E extends Comparable<E>> BinarySearchTree<E> intoBalanced(BinarySearchTree<E> bst) {
        if (bst == null || bst.size() == 0 ) {
            return new BinarySearchTree<>();
        }

        List<E> sortedList = inOrder(bst.root);
        Collections.sort(sortedList);

        Node<E> newRoot = constructBalancedTree(sortedList, 0, sortedList.size() - 1);

        BinarySearchTree<E> balancedTree = new BinarySearchTree<>();
        balancedTree.root = newRoot;
        balancedTree.size = sortedList.size();
        return balancedTree;
    }

    // Helper method to get middle element 
    private static <E extends Comparable<E>> Node<E> constructBalancedTree(List<E> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node<E> newNode = new Node<>(sortedList.get(mid));
        newNode.left = constructBalancedTree(sortedList, start, mid - 1);
        newNode.right = constructBalancedTree(sortedList, mid + 1, end);

        return newNode;
    }

    //why is this attep
   

    // Define the Node and Bi

    /**
     * Returns true iff the tree rooted at n is a Binary Search Tree.
     * 
     * It must have no more than two children per node.
     * 
     * Each node's value must be greater than all the values in its left subtree,
     * and smaller
     * than all the values in its right subtree. (This implies duplicate values are
     * not allowed.)
     * 
     * @param n true iff the tree rooted at n is a Binary Search Tree
     * @return
     */
    
    static <E extends Comparable<E>> boolean isBST(Node<E> n) {
        return isBSTHelper(n, null, null);
    }
    
    /**
     * Helper method for checking whether the tree rooted at node n is a Binary Search Tree.
     * 
     * @param n the current node being checked
     * @param min the minimum value that the current node's value must be greater than (exclusive)
     * @param max the maximum value that the current node's value must be smaller than (exclusive)
     * @return true if the tree rooted at n is a Binary Search Tree, false otherwise
     */
    private static <E extends Comparable<E>> boolean isBSTHelper(Node<E> n, E min, E max) {
        // Base case: an empty tree is considered a BST
        if (n == null) {
            return true;
        }
    
        // Check if the current node's value is within the correct range
        if ((min != null && n.data.compareTo(min) <= 0) || (max != null && n.data.compareTo(max) >= 0)) {
            return false;
        }
    
        // Recursively check the left and right subtrees with updated min and max values
        return isBSTHelper(n.left, min, n.data) && isBSTHelper(n.right, n.data, max);
    }

    /**
     * Returns true iff the tree rooted at n is an AVL tree.
     * 
     * AVL trees are Binary Search trees with the additional property that
     * every node in the tree has the AVL property.
     * 
     * A node has the AVL property iff the height of its left subtree and the
     * height of its right subtree differ by no more than 1.
     * 
     * @param <E>
     * @param n
     * @returntrue iff the tree rooted at n is an AVL tree
     */
    static <E extends Comparable<E>> boolean isAVLTree(Node<E> n) {
        if (n == null) {
            return true; // An empty tree is considered an AVL tree
        }
    
        // Check if the tree rooted at n satisfies the AVL property
        return isBalanced(n) && isAVLTree(n.left) && isAVLTree(n.right);
    }
    
    /**
     * Helper method to check if the tree rooted at node n satisfies the AVL property.
     * 
     * @param n the root node of the subtree to be checked
     * @return true if the subtree rooted at n satisfies the AVL property, false otherwise
     */
    private static <E extends Comparable<E>> boolean isBalanced(Node<E> n) {
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    /**
     * Returns true iff the subtrees rooted at n and m have the same values
     * and same structure.
     * 
     * Only checks child references, not parent references.
     * 
     * @param n
     * @param m
     * @return true iff the subtrees rooted at n and m have the same values and same
     *         structure
     */
    static <E> boolean equalSubtrees(Node<E> n, Node<E> m) {
        if (n == null && m == null) {
            return true;
        } else if (n == null || m == null) {
            return false;
        } else {
            return n.data.equals(m.data) && equalSubtrees(n.left, m.left) && equalSubtrees(n.right, m.right);
        }
    }
}
