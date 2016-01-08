package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navid.mazaheri on 1/8/16.
 * https://community.topcoder.com/stat?c=problem_statement&pm=14098&rd=16627
 */
public class PalindromePrime {
    public static void main(String[] args) {
        PalindromePrime palindromePrime = new PalindromePrime();
        System.out.println(palindromePrime.count(100, 150));
        System.out.println(palindromePrime.count(1, 9));
        System.out.println(palindromePrime.count(929, 929));
        System.out.println(palindromePrime.count(1, 1));
        System.out.println(palindromePrime.count(1, 1000));

    }

    public int count(int L, int R) {
        List<Integer> list = new ArrayList<>();
        L = Math.max(2, L);
        int c = 0;
        for (int i = L; i <= R; i++) {
            if (isPalindrome(i) && isPrime(i))
                c++;
        }
        return c;
    }

    private boolean isPalindrome(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        if (chars.length == 1)
            return true;

        for (int i=0; i<chars.length/2; i++) {
            if(chars[i] != chars[chars.length-i-1])
                return false;
        }
        return true;
    }

    private boolean isPrime(int i) {
        if (i == 1)
            return false;

        if (i == 2)
            return true;

        if (i % 2 == 0)
            return false;

        for (int j = 3; j <= Math.sqrt(i); j += 2) {
            if (i % j == 0)
                return false;
        }
        return true;
    }
}
