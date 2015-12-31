package topcoder.division2;

/**
 * Created by navid.mazaheri on 12/29/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=13782
 */
public class MutaliskEasy {
    private final int arraySize = 60;
    private int dp[][][] = new int[arraySize + 1][arraySize + 1][arraySize + 1];
    private int attacks[][] = { { 1, 3, 9 }, { 3, 1, 9 }, { 1, 9, 3 }, { 3, 9, 1 }, { 9, 3, 1 }, { 9, 1, 3 } };

    public static void main(String[] args) {
        MutaliskEasy mutaliskEasy = new MutaliskEasy();
        System.out.println(mutaliskEasy.minimalAttacks(new int[] { 12, 10, 4 }));
        System.out.println(mutaliskEasy.minimalAttacks(new int[] { 54, 18, 6 }));
        System.out.println(mutaliskEasy.minimalAttacks(new int[] { 55, 60, 53 }));
        System.out.println(mutaliskEasy.minimalAttacks(new int[] { 1, 1, 1 }));
        System.out.println(mutaliskEasy.minimalAttacks(new int[] { 60, 40 }));
        System.out.println(mutaliskEasy.minimalAttacks(new int[] { 60 }));

        System.out.println();
        //        System.out.println(mutaliskEasy.minimalAttacksRecursive(12, 10, 4));
        //        System.out.println(mutaliskEasy.minimalAttacksRecursive(54, 18, 6));
        //        System.out.println(mutaliskEasy.minimalAttacksRecursive(60, 40, 0));

    }

    public MutaliskEasy() {
        for (int i = 0; i <= arraySize; i++) {
            for (int j = 0; j <= arraySize; j++) {
                for (int k = 0; k <= arraySize; k++) {
                    if (i == 0 && j == 0 && k == 0)
                        continue;
                    dp[i][j][k] = Integer.MAX_VALUE;
                    for (int n = 0; n < attacks.length; n++) {
                        int newx, newy, newz;
                        newx = Math.max(0, i - attacks[n][0]);
                        newy = Math.max(0, j - attacks[n][1]);
                        newz = Math.max(0, k - attacks[n][2]);
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[newx][newy][newz] + 1);
                    }
                }
            }
        }
    }

    public int minimalAttacks(int[] x) {
        int a = x[0], b = 0, c = 0;
        if (x.length > 1)
            b = x[1];
        if (x.length > 2)
            c = x[2];
        return dp[a][b][c];
    }

    public int minimalAttacksRecursive(int x, int y, int z) {
        return minimalAttacksRecursive(x, y, z, 0);
    }

    private int minimalAttacksRecursive(int x, int y, int z, int attempts) {
        if (x < 1 && y < 1 && z < 1)
            return attempts;

        int min = Integer.MAX_VALUE;
        for (int[] attack : attacks) {
            min = Math.min(min, minimalAttacksRecursive(x - attack[0], y - attack[1], z - attack[2], attempts + 1));
        }
        return min;
    }

}
