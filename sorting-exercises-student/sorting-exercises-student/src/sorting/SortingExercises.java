/*
 * Copyright 2023 Marc Liberatore.
 */

package sorting;

import java.util.Random;

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
        for (int i = start + 1; i < end; i++) {
            double swap = a[i];
            int j = i - 1;
            while (j >= start && a[j] > swap) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = swap;
        }
    }

    /**
     * Perform a destructive mergesort on the array a.
     * 
     * The array will be in ascending order (least-to-greatest) after sorting; the
     * original
     * values will be overwritten.
     * Additional array space will be allocated by this method.
     * 
     * For efficiency, this method will *insertion sort* any array of length less
     * than 10.
     */
    public static void mergeSort(double[] a) {
        if (a.length < 10) {
            insertionSort(a);
            return;
        }
        double[] temp = new double[a.length];
        mergeSort(a, temp, 0, a.length - 1);
    }
    //helper method
    private static void mergeSort(double[] a, double[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, temp, left, mid);
            mergeSort(a, temp, mid + 1, right);

            int i = left;
            int j = mid + 1;
            int k = left;

            while (i <= mid && j <= right) {
                if (a[i] <= a[j]) {
                    temp[k++] = a[i++];
                } else {
                    temp[k++] = a[j++];
                }
            }

            while (i <= mid) {
                temp[k++] = a[i++];
            }

            while (j <= right) {
                temp[k++] = a[j++];
            }

            for (i = left; i <= right; i++) {
                a[i] = temp[i];
            }
        }
    }
    /**
     * Merge the sorted arrays l and r into the array a (overwriting its previous
     * contents).
     */
    static void merge(double[] a, double[] l, double[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
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
        if (j - 1 < 10) {
            insertionSort(a, i, j);
            return;
        }
        int pivotIndex = partition(a, i, j);
        quickSort(a, i, pivotIndex);
        quickSort(a, pivotIndex + 1, j);
    }

    /**
     * Perform an in-place partition on the range i (inclusive) to j
     * (exclusive) of the array a, returning the index of the pivot
     * after partitioning.
     * 
     * To cut down on worst case choices, this method will chose the
     * pivot value at random from among the values in the range.
     * 
     * @return the index of the pivot after the partition
     */
    static int partition(double[] a, int i, int j) {
        Random rand = new Random();
        int pivotIndex = i + rand.nextInt(j - i);
        double pivotValue = a[pivotIndex];
        swap(a, pivotIndex, j - 1);
        int storeIndex = i;
        for (int k = i; k < j - 1; k++) {
            if (a[k] < pivotValue) {
                swap(a, k, storeIndex++);
            }
        }
        swap(a, storeIndex, j - 1);
        return storeIndex;
    }
}