package topcoder;

import java.util.Arrays;

/**
 * Created by navid.mazaheri on 1/8/16.
 * https://community.topcoder.com/stat?c=problem_statement&pm=14100&rd=16627
 * http://apps.topcoder.com/wiki/display/tc/SRM+677
 */
public class PalindromePath {
    private static final char emptyChar = '\0';

    public static void main(String[] args) {
        PalindromePath palindromePath = new PalindromePath();
        System.out.println(
                palindromePath.shortestLength(5, new int[] { 2, 2, 0, 3, 4 }, new int[] { 0, 1, 3, 4, 1 }, "abxyx"));
        //        System.out.println(
        //                palindromePath.shortestLength(5, new int[] { 2, 2, 0, 3, 4 }, new int[] { 0, 1, 3, 4, 1 }, "abxyz"));
        //        System.out.println(palindromePath
        //                .shortestLength(7, new int[] { 0, 0, 3, 4, 5, 6 }, new int[] { 2, 3, 4, 5, 6, 1 }, "abaaaa"));
        //        System.out.println(palindromePath.shortestLength(2, new int[] { 0 }, new int[] { 1 }, "x"));
        //        System.out.println(palindromePath.shortestLength(20, new int[] { 18 }, new int[] { 19 }, "z"));

    }

    /**
     * return shortest palindrome path from node 0 to 1
     */
    public int shortestLength(int n, int[] a, int[] b, String c) {
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
            dp[i][i] = 0;
        }

        char[][] edges = new char[n][n];
        for (int i = 0; i < a.length; i++) {
            edges[a[i]][b[i]] = c.charAt(i);
            edges[b[i]][a[i]] = c.charAt(i);
            dp[a[i]][b[i]] = 1;
            dp[b[i]][a[i]] = 1;
        }

        for (char[] chars1 : edges) {
            System.out.println(Arrays.toString(chars1));
        }
        System.out.println();

        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        System.out.println();

        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a.length; y++) {
                if (dp[x][y] != Integer.MAX_VALUE) {
                    for (int i = 0; i < a.length; i++) {
                        for (int j = 0; j < a.length; j++) {
                            if (edges[i][x] != emptyChar && edges[i][x] == edges[j][y]) {
                                System.out.printf("(%d, %d) and (%d, %d)\n", i, x, j, y);
                                dp[i][j] = Math.min(dp[i][j], dp[i][x] + dp[j][y] + dp[x][y]);
                            }
                        }
                    }
                }
            }

        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[0][1] == Integer.MAX_VALUE ? -1 : dp[0][1];
    }
}
