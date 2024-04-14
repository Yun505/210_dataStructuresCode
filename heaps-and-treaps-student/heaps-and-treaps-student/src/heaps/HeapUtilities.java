/*
 * Copyright 2023 Marc Liberatore.
 */

package heaps;

import java.util.Arrays;
import java.util.Random;

public class HeapUtilities {
    /**
     * Returns true iff the subtree of a starting at index i is a max-heap.
     * @param a an array representing a mostly-complete tree, possibly a heap
     * @param i an index into that array representing a subtree rooted at i
     * @return true iff the subtree of a starting at index i is a max-heap
     */
    static boolean isHeap(double[] a, int i) {
        return true;
    }

    /**
     * Perform the heap siftdown operation on index i of the array a. 
     * 
     * This method assumes the subtrees of i are already valid max-heaps.
     * 
     * This operation is bounded by n (exclusive)! In a regular heap, 
     * n = a.length, but in some cases (for example, heapsort), you will 
     * want to stop the sifting at a particular position in the array. 
     * siftDown should stop before n, in other words, it should not 
     * sift down into any index great than (n-1).
     * 
     * @param a the array being sifted
     * @param i the index of the element to sift down
     * @param n the bound on the array (that is, where to stop sifting)
     */
    static void siftDown(double[] a, int i, int n) {
    }

    /**
     * Heapify the array a in-place in linear time as a max-heap.
     * @param a an array of values
     */
    static void heapify(double[] a) {
    }

    /**
     * Heapsort the array a in-place, resulting in the elements of
     * a being in ascending order.
     * @param a
     */
    static void heapSort(double[] a) {
    }
    
    public static void main(String[] args) {
        Random r = new Random(0);
        int length = 15;
        double[] l = new double[length];
        for (int i = 0; i < length; i++) {
            l[i] = r.nextInt(20);
        }
        System.out.println(Arrays.toString(l));

        heapify(l);

        System.out.println(Arrays.toString(l));

        heapSort(l);

        System.out.println(Arrays.toString(l));
    }
}
