package interview;

/**
 * Created by nav on 1/20/16.
 */
public class PeakAndValleys {

    public static void main(String[] args) {
        // 0
        System.out.println(PeakAndValleys.getPeak(new int[] { 6, 5, 4 }));

        // 1
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 1, 0 }));
        System.out.println(PeakAndValleys.getPeak(new int[] { 2, 3, 2, 1 }));

        // 2
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3, 2, 1 }));
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3 }));
        System.out.println(PeakAndValleys.getPeak(new int[] { 2,3,4,3,2 }));

        // 3
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3, 4, 3, 2 }));
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3, 4, 3 }));
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3, 4, 3, 2, 1, 0 }));


        // 4
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3, 4, 5, 4 }));

        // 5
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3, 4, 5, 6, 5, 4 }));

        // 6
        System.out.println(PeakAndValleys.getPeak(new int[] { 1, 2, 3, 4, 5, 6, 7, 6, 5 }));

    }

    public static int getPeak(int[] nums) {
        int lastIndex = nums.length - 1;
        if (nums.length < 3)
            return -1;

        int midPos = nums.length / 2;
        int offset = (nums[0] - nums[lastIndex]) / 2;

        if (nums.length % 2 == 0 && nums[0] > nums[lastIndex])
            midPos--;

        return midPos - offset;
    }
}
