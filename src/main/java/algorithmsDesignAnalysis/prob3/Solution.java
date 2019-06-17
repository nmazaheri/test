package algorithmsDesignAnalysis.prob3;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * Created by nav on 11/17/15.
 * <p/>
 * get the i'th minimum index using quickSelectRecursive
 */
public class Solution {

    public static void main(String args[]) {
        int[] orig = { 9, 3, 8, 5, 11, 2, 4, 7, 15, 23 };
        System.out.println(Arrays.toString(orig));
        printAll(orig);
    }

    public static void printAll(int[] orig) {
        for (int i = 0; i < orig.length; i++) {
            System.out.format("k=%d is %d\n", i, Solution.quickSelect(orig.clone(), i));
        }
        sort(orig);
        System.out.println(Arrays.toString(orig));
    }

    public static int quickSelect(int[] nums, int k) {
        int size = nums.length - 1;
        if (size == 0 || k > size)
            return -1;
        return quickSelect(nums, 0, size, k);
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        while (true) {
            if (start == end)
                return nums[start];

            int pivotIndex = start;
            pivotIndex = partition(nums, start, end, pivotIndex);

            if (k == pivotIndex)
                return nums[k];
            else if (k < pivotIndex)
                end = pivotIndex - 1;
            else
                start = pivotIndex + 1;
        }
    }

    private static int partition(int[] nums, int start, int end, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        //                System.out.format("start=%d; end=%d\n", start, end);
        swap(nums, pivotIndex, end);

        int moveIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, moveIndex, i);
                moveIndex++;
            }
        }
        swap(nums, end, moveIndex);
        //        System.out.println("new pivotIndex is " + moveIndex);
        return moveIndex;
    }

    private static void swap(int[] nums, int a, int b) {
        if (a != b) {
            //            System.out.format("swapping index %d and %d\n", a, b);
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

    }

    //    private int quickSelectRecursive(int start, int end, int k) {
    //        if (start == end)
    //            return nums[start];
    //
    //        int pivotIndex = start;
    //        pivotIndex = partition(start, end, pivotIndex);
    //
    //        if (k == pivotIndex)
    //            return nums[k];
    //        else if (k < pivotIndex)
    //            return quickSelect(start, pivotIndex - 1, k);
    //        else
    //            return quickSelect(pivotIndex + 1, end, k);
    //    }
}
