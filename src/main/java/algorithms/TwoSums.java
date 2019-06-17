package algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by nav on 5/31/15.
 */
public class TwoSums {
    public static void main(String[] args) {
        int [] result = TwoSums.easy(new int[] { 2, 11, 7, 15 }, 9);
        System.out.println(Arrays.toString(result));
        int [] result2 = TwoSums.medium(new int[] { 2, 11, 15, 7 }, 9);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] easy(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] + data[j] == target)
                    return new int[] { i + 1, j + 1 };
            }
        }
        return new int[1];
    }

    public static int[] medium(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                // 2nd entry found
                int index = map.get(numbers[i]);
                result[0] = index+1 ;
                result[1] = i+1;
                break;
            } else {
                // adding key need to reach target
                map.put(target - numbers[i], i);
            }
        }

        return result;

    }

//    public static void printUniques()

}
