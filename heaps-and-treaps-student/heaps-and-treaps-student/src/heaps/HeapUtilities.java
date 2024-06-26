/*
 * Copyright 2023 Marc Liberatore.
 */

package heaps;

import java.util.Arrays;
import java.util.Random;

public class HeapUtilities {
    /**
     * Returns true iff the subtree of a starting at index i is a max-heap.
     * 
     * @param a an array representing a mostly-complete tree, possibly a heap
     * @param i an index into that array representing a subtree rooted at i
     * @return true iff the subtree of a starting at index i is a max-heap
     */
    static boolean isHeap(double[] a, int i) {
        
        if (i >= a.length) {
            return true; 
        }

        int left = 2 * i + 1;
        int right = 2 * i + 2; 

        if (left < a.length && a[left] > a[i]) {
            return false;
        }


        if (right < a.length && a[right] > a[i]) {
            return false;
        }
        return isHeap(a, left) && isHeap(a, right);

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
        int parent = i;
        int leftChild = 2 * parent + 1; 
        double parentValue = a[parent];

        while (leftChild < n) {
            int maxChild = leftChild;
            int rightChild = leftChild + 1;

           
            if (rightChild < n && a[rightChild] > a[leftChild]) {
                maxChild = rightChild;
            }

           
            if (parentValue >= a[maxChild]) {
                break; 
            }

            double temp = a[parent];
            a[parent] = a[maxChild];
            a[maxChild] = temp;

            parent = maxChild;
            leftChild = 2 * parent + 1;
        }
    }

    /**
     * Heapify the array a in-place in linear time as a max-heap.
     * 
     * @param a an array of values
     */
    static void heapify(double[] a) {
        int n = a.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            siftDown(a, i, n);
        }
    }

    /**
     * Heapsort the array a in-place, resulting in the elements of
     * a being in ascending order.
     * 
     * @param a
     */
    static void heapSort(double[] a) {
        int n = a.length;
        heapify(a);

        for (int i = n - 1; i > 0; i--) {
            double temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            siftDown(a, 0, i);
        }
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
