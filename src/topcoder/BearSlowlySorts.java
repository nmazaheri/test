package topcoder;

import java.util.Arrays;

/**
 * Created by navid.mazaheri on 12/7/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=14083
 */

public class BearSlowlySorts {
    public static void main(String args[]) {
        BearSlowlySorts bearSlowlySorts = new BearSlowlySorts();
        System.out.println(bearSlowlySorts.minMoves(new int[] { 2, 6, 8, 5 }));
        System.out.println(bearSlowlySorts.minMoves(new int[] { 4, 3, 1, 6, 2, 5 }));
        System.out.println(bearSlowlySorts
                .minMoves(new int[] { 93, 155, 178, 205, 213, 242, 299, 307, 455, 470, 514, 549, 581, 617, 677 }));
        System.out.println(bearSlowlySorts.minMoves(new int[] { 50, 20, 30, 40, 10 }));
        System.out.println(bearSlowlySorts.minMoves(
                new int[] { 234, 462, 715, 596, 906, 231, 278, 223, 767, 925, 9, 526, 369, 319, 241, 354, 317, 880, 5,
                        696 }));
    }

    public int minMoves(int[] w) {
        int lastElement = w.length - 1;

        int[] sorted = w.clone();
        Arrays.sort(sorted);

        boolean isSorted = true;
        boolean[] unsortedPos = new boolean[w.length];

        for (int i = 0; i < w.length; i++) {
            if (sorted[i] != w[i]) {
                isSorted = false;
                unsortedPos[i] = true;
            }
        }

        int iterationCount = 1;

        if (isSorted)
            iterationCount = 0;
        else if (w[0] == sorted[lastElement] && w[lastElement] == sorted[0])
            iterationCount = 3;
        else if (unsortedPos[0] && unsortedPos[lastElement])
            iterationCount = 2;

        return iterationCount;
    }
}
