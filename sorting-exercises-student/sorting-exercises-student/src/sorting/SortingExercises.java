/*
 * Copyright 2023 Marc Liberatore.
 */

package sorting;

public class SortingExercises {

    /**
     * Swap the values at a[i] and a[j].
     */
    static void swap(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Perform an in-place insertion sort on the array a.
     * The array will be in ascending order (least-to-greatest) after sorting.
     */
    static void insertionSort(double[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; (j > 0 && a[j - 1] > a[j]); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    /**
     * Perform an in-place insertion sort of the range start (inclusive) 
     * through end (exclusive) on array a.
     * The array will be in ascending order (least-to-greatest) after sorting.
     */
    static void insertionSort(double[] a, int start, int end) {
    }

    /**
     * Perform a destructive mergesort on the array a.
    
     * The array will be in ascending order (least-to-greatest) after sorting; the original
     * values will be overwritten.
     * Additional array space will be allocated by this method.
     * 
     * For efficiency, this method will *insertion sort* any array of length less than 10.
     */
    public static void mergeSort(double[] a) {
    }

    /**
     * Merge the sorted arrays l and r into the array a (overwriting its previous contents).
     */
    static void merge(double[] a, double[] l, double[] r) {
    }

    /**
     * Perform an in-place quicksort on the array a.
     */
    static void quickSort(double[] a) {
        quickSort(a, 0, a.length);
    }

    /**
     * Perform an in-place quicksort on the range i (inclusive) to j 
     * (exclusive) of the array a.
     * 
     * For efficiency, this method will *insertion sort* any range of 
     * length less than 10.
     */
    static void quickSort(double[] a, int i, int j) {
    }

    /**
     * Perform an in-place partition on the  range i (inclusive) to j 
     * (exclusive) of the array a, returning the index of the pivot
     * after partitioning.
     * 
     * To cut down on worst case choices, this method will chose the 
     * pivot value at random from among the values in the range.
     * 
     * @return the index of the pivot after the partition
     */
    static int partition(double[] a, int i, int j) {
        return -1;
    }
}