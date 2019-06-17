package sorting;

import java.util.Arrays;

/**
 * Created by nav on 5/14/15.
 */
public class SortAlgorithms {
    int[] data;
    int length;

    public SortAlgorithms(int[] data) {
        this.data = data;
        this.length = data.length;
    }

    public int[] selectionSort() {
        int[] out = data.clone();

        for (int i = 0; i < length; i++) {
            int minPos = i;
            for (int j = i + 1; j < length; j++) {
                if (out[minPos] > out[j]) {
                    minPos = j;
                }
            }
            swap(i, minPos, out);
        }

        return out;
    }

    public int[] bubbleSort() {
        int[] out = data.clone();

        for (int i = length - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (out[j - 1] > out[j]) {
                    swap(j - 1, j, out);
                }
            }
        }

        return out;
    }

    public int[] insertionSort() {
        int[] out = data.clone();

        for (int i = 1; i < length; i++) {
            int next = out[i];
            int j = i;
            while (j > 0 && out[j - 1] > next) {
                out[j] = out[j - 1];
                j--;
            }
            out[j] = next;
        }

        return out;
    }

    public int[] mergeSort() {
        int[] out = data.clone();
        doMergeSort(out);
        return out;
    }

    private void doMergeSort(int[] out) {
        if (out.length <= 1)
            return;

        int middle = out.length / 2;
        int[] first = Arrays.copyOf(out, middle);
        int[] second = Arrays.copyOfRange(out, middle, out.length);
        doMergeSort(first);
        doMergeSort(second);
        mergeParts(out, first, second);
    }

    private void mergeParts(int[] out, int[] first, int[] second) {
        int firstPos = 0, secondPos = 0, outPos = 0;

        while (firstPos < first.length && secondPos < second.length) {
            if (first[firstPos] < second[secondPos]) {
                out[outPos] = first[firstPos];
                firstPos++;
            } else {
                out[outPos] = second[secondPos];
                secondPos++;
            }
            outPos++;
        }

        for (int i = firstPos; i < first.length; i++) {
            out[outPos++] = first[i];
        }

        for (int i = secondPos; i < second.length; i++) {
            out[outPos++] = second[i];
        }
    }

    public int[] quickSort() {
        int[] out = data.clone();
        quickSort(out, 0, out.length - 1);
        return out;
    }

    public void quickSort(int[] out, int start, int end) {
        if (start >= end)
            return;

        int pivot = out[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (out[left] < pivot)
                left++;

            while (out[right] > pivot)
                right--;

            if (left <= right) {
                swap(left, right, out);
                right--;
                left++;
            }
        }

        // recursion
        if (start < right)
            quickSort(out, start, right);
        if (left < end)
            quickSort(out, right + 1, end);
    }

    public void swap(int a, int b, int[] input) {
        if (a == b)
            return;
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
