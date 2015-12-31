package topcoder.division2;

import java.util.Arrays;

/**
 * Created by navid.mazaheri on 12/4/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=12977
 */

public class EllysSubstringSorter {
    public static void main(String args[]) {
        EllysSubstringSorter sorter = new EllysSubstringSorter();
        System.out.println(sorter.getMin("TOPCODER", 4));
        System.out.println(sorter.getMin("ESPRIT", 3));
        System.out.println(sorter.getMin("ABRACADABRA", 5));
        System.out.println(sorter.getMin("BAZINGA", 6));
        System.out.println(sorter.getMin("AAAWDIUAOIWDESBEAIWODJAWDBPOAWDUISAWDOOPAWD", 21));
    }

    public String getMin(String S, int L) {
        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < i + L; j++) {

                if (chars[i] > chars[j]) {
                    int separateIdx = i + L;
                    return S.substring(0, i) + sort(S.substring(i, separateIdx)) + S.substring(separateIdx, S.length());
                }
            }
        }
        return S;
    }

    private String sort(String in) {
        char [] chars = in.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
