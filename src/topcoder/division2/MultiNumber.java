package topcoder.division2;

/**
 * Created by navid.mazaheri on 1/5/16.
 * https://community.topcoder.com/stat?c=problem_statement&pm=10072&rd=13513
 */
public class MultiNumber {
    public static void main(String[] args) {
        MultiNumber multiNumber = new MultiNumber();
        System.out.println(multiNumber.check(1));
        System.out.println(multiNumber.check(1221));
        System.out.println(multiNumber.check(1236));
        System.out.println(multiNumber.check(4729382));
        System.out.println(multiNumber.check(42393338));
    }

    public String check(int number) {
        String s = String.valueOf(number);
        for (int i = 1; i < s.length(); i++) {
            String a = s.substring(0, i);
            String b = s.substring(i);

            int k = 1, j = 1;
            for (char c : a.toCharArray())
                j *= c - '0';
            for (char c : b.toCharArray())
                k *= c - '0';
            if (j == k)
                return "YES";
        }
        return "NO";
    }
}
