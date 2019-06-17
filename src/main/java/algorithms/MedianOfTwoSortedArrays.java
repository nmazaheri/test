package algorithms;

/**
 * Created by nav on 5/31/15.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int ar1[] = { 1, 12, 15, 26, 38 };
        int ar2[] = { 2, 13, 17, 30, 45 };
        System.out.println(MedianOfTwoSortedArrays.getMedian(ar1, ar2));

        int ar3[] = { 1, 12, 19, 26 };
        int ar4[] = { 2, 13, 17, 30, 45 };
        System.out.println(MedianOfTwoSortedArrays.getMedian(ar3, ar4));

        int ar5[] = { 12 };
        int ar6[] = { 2, 13, 17, 30, 45 };
        System.out.println(MedianOfTwoSortedArrays.getMedian(ar5, ar6));
    }

    private static int getMedian(int[] first, int[] second) {
        int totalLength = second.length + first.length;
        int medianPos = totalLength / 2;
        boolean even = totalLength % 2 == 0;

        int[] out = new int[medianPos + 1];
        int firstPos = 0;
        int secondPos = 0;
        int outPos = 0;

        while (firstPos < first.length && secondPos < second.length) {
            if (first[firstPos] < second[secondPos]) {
                out[outPos] = first[firstPos];
                firstPos++;
            } else {
                out[outPos] = second[secondPos];
                secondPos++;
            }
            print(out, outPos);
            if (outPos == medianPos)
                return calculateMedian(even, out, outPos);

            outPos++;
        }

        for (int i = firstPos; i < first.length; i++) {
            out[outPos] = first[i];

            if (outPos == medianPos)
                return calculateMedian(even, out, outPos);

            outPos++;
        }

        for (int i = secondPos; i < second.length; i++) {
            out[outPos] = second[i];

            if (outPos == medianPos)
                return calculateMedian(even, out, outPos);

            outPos++;
        }

        return -1;
    }

    private static int calculateMedian(boolean even, int[] out, int outPos) {
        return even ? (out[outPos] + out[outPos - 1]) / 2 : out[outPos];
    }

    private static void print(int[] out, int outPos) {
        System.out.println("out = " + out[outPos] + " at pos=" + outPos);
    }
}
