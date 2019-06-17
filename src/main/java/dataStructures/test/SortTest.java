package dataStructures.test;

import sorting.SortAlgorithms;

import java.util.Arrays;

/**
 * Created by nav on 5/14/15.
 */
public class SortTest {

    public static void main(String[] args) {
        int[] list = new int[] { 5, 4, 2, 9, 7, 6, 1, 8, 4 };
        SortAlgorithms sortAlgorithms = new SortAlgorithms(list);

        System.out.println("Selection Sort: " + Arrays.toString(sortAlgorithms.selectionSort()));
        System.out.println("Bubble Sort: " + Arrays.toString(sortAlgorithms.bubbleSort()));
        System.out.println("Insertion Sort: " + Arrays.toString(sortAlgorithms.insertionSort()));
        System.out.println("Quick Sort: " + Arrays.toString(sortAlgorithms.quickSort()));
        System.out.println("Merge Sort: " + Arrays.toString(sortAlgorithms.mergeSort()));

    }
}
