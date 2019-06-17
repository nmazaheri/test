package algorithmsDesignAnalysis.hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nav on 11/14/15.
 */
public class Inversions {
    private static final String filename = "IntegerArray.txt";
    private int[] nums;
    private long inv;

    public static void main(String[] args) throws Exception {
        int[] in = { 1, 9, 3, 5, 2 };
        System.out.println(Inversions.bruteForceCount(in));

        int[] file = Inversions.loadFile(filename);
        Inversions inversions = new Inversions(file);
        System.out.println(inversions.getCount());
        // result is 2407905288
    }

    public Inversions(int[] nums) {
        this.nums = nums;
    }

    public static long bruteForceCount(int[] nums) {
        long count = 0;
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] > nums[j]) {
                    //                    System.out.println(nums[i] + " " + nums[j]);
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] loadFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<Integer> list = new ArrayList<>();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } finally {
            br.close();
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public long getCount() {
        inv = 0;
        sortAndCount(0, nums.length - 1);
        return inv;
    }

    private int[] sortAndCount(int start, int end) {
        if (end <= start) {
            return new int[] { nums[start] };
        }

        int mid = (end + start) / 2;
        int[] l = sortAndCount(start, mid);
        int[] r = sortAndCount(mid + 1, end);
        return countSplitInversion(l, r);
    }

    private int[] countSplitInversion(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0;

        for (int k = 0; k < result.length; k++) {
            if (leftIndex == left.length)
                result[k] = right[rightIndex++];
            else if (rightIndex == right.length)
                result[k] = left[leftIndex++];
            else if (left[leftIndex] < right[rightIndex])
                result[k] = left[leftIndex++];
            else {
                result[k] = right[rightIndex++];
//                System.out.printf("for %s and %s. %d is greater then %d. adding %d\n", Arrays.toString(left), Arrays.toString(right), left[leftIndex], right[rightIndex-1], left.length - leftIndex);
                inv += left.length - leftIndex;
            }
        }
        return result;
    }
}
