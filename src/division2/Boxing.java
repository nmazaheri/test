package division2;

import java.util.Arrays;

/**
 * Created by navid.mazaheri on 12/3/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=2977&rd=5880
 */

public class Boxing {
    public static void main(String args[]) {
        Boxing boxing = new Boxing();
        System.out.println(boxing.maxCredit(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 2, 3, 4, 5, 6, 7 },
                new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 0, 1, 2 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));

    }

    public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
        int[][] hits = { a, b, c, d, e };
        int[] mr = new int[5];
        int[] pos = new int[5];
        Arrays.fill(mr, -1);
        Arrays.fill(pos, 0);
        int ans = 0;
        for (int i = 0; i <= 180000; i++) {
            for (int j = 0; j < 5; j++) {
                if (pos[j] >= hits[j].length)
                    continue;
                if (hits[j][pos[j]] <= i) {
                    mr[j] = hits[j][pos[j]];
                    pos[j]++;
                }
            }
            int num = 0;
            for (int j = 0; j < 5; j++) {
                if (mr[j] == -1)
                    continue;
                if (i - mr[j] <= 1000) {
                    num++;
                }
            }
            if (num >= 3) {
                ans++;
                Arrays.fill(mr, -1);
            }
        }
        return ans;
    }

}


