package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navid.mazaheri on 1/8/16.
 */
public class FourStrings {

    public static void main(String[] args) {
        FourStrings fourStrings = new FourStrings();
        System.out.println(fourStrings.shortestLength("abc", "ab", "bc", "b"));
        System.out.println(fourStrings.shortestLength("a", "bc", "def", "ghij"));
        System.out.println(fourStrings.shortestLength("top", "coder", "opco", "pcode"));
        System.out.println(fourStrings.shortestLength("thereare", "arelots", "lotsof", "ofcases"));
        System.out.println(fourStrings.shortestLength("aba", "b", "b", "b"));
        System.out.println(fourStrings.shortestLength("x", "x", "x", "x"));
        System.out.println(fourStrings.shortestLength("asgrgrrr", "sadrgdas", "ferrrred", "we"));
        System.out.println(fourStrings.shortestLength("abb", "bbc", "bbb", "bbb"));

    }

    public int shortestLength(String a, String b, String c, String d) {
        return shortestLengthRecursive(Arrays.asList(a, b, c, d), "");
    }

    private int shortestLengthRecursive(List<String> l, String word) {
        if (l.size() == 1) {
            String combinedWord = combine(word, l.get(0));
            // System.out.println(combinedWord);
            return combinedWord.length();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l.size(); i++) {
            List<String> l2 = new ArrayList<>(l);
            String addedWord = l2.remove(i);
            min = Math.min(min, shortestLengthRecursive(l2, combine(word, addedWord)));
        }
        return min;
    }

    private String combine(String a, String b) {
        int i = b.length();
        String c = b;
        while (c.length() > 0 && !a.contains(c)) {
            c = c.substring(0, c.length() - 1);
            i--;
        }
        return a + b.substring(i, b.length());
    }
}
