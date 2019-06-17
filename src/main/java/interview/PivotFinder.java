package interview;

/**
 * Created by nav on 12/6/15.
 */
public class PivotFinder {
    public static void main(String args[]) {
        PivotFinder pivotFinder = new PivotFinder();
        System.out.println(pivotFinder.getPivot(new int[] { 4, 5, 6, 7, 8, 9, 1, 2, 3 }));

        System.out.println(pivotFinder.getPivot(new int[] { 1, 2, 3 }));
        System.out.println(pivotFinder.getPivot(new int[] { 1 }));
        System.out.println(pivotFinder.getPivot(new int[] { 4, 5, 6, 7, 1 }));


    }

    public int getPivot(int[] in) {
        int start = 0;
        int end = in.length - 1;
        int middle = (start + end) / 2;

        while (start <= end && middle != in.length - 1 && in[middle] < in[middle + 1]) {
            if (in[middle] >= in[start])
                start = middle + 1;
            else
                end = middle - 1;

            middle = (start + end) / 2;
        }
        return middle;
    }



}
