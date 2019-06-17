package algorithms.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nav on 7/21/15.
 */
public class StringPermutations {
    Set<String> result;

    public static void main(String[] args) {
        String abc = "abc";
        System.out.println(abc.length());
        StringPermutations permutations = new StringPermutations();
        System.out.println(permutations.permutation("abdc"));
        // 4!
    }

    private Set<String> permutation(String str) {
        result = new HashSet();
        permutationRecursive("", str);
        return result;
    }

    private void permutationRecursive(String finalWord, String str) {
        int n = str.length();
        if (n == 0) {
            result.add(finalWord);
            return;
        }

        for (int i = 0; i < n; i++)
            permutationRecursive(finalWord + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));

    }
}
