package algorithms;

/**
 * Created by nav on 6/14/15.
 */
public class ArrayTools {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 7, 10 };
        System.out.println(ArrayTools.searchInsert(arr, 8));
    }

    public static int searchInsert(int[] in, int target) {
        if (in == null)
            return 0;

        int pos = 0;
        for (int data : in) {
            if (data == target || data > target)
                break;
            pos++;
        }
        return pos;
    }
}
