package topcoder.division2;

/**
 * Created by navid.mazaheri on 12/28/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=13751
 */
public class GoodString {
    public static void main(String[] args) {
        GoodString goodString = new GoodString();
        System.out.println(goodString.isGood("ab"));
        System.out.println(goodString.isGood("aab"));
        System.out.println(goodString.isGood("aabb"));
        System.out.println(goodString.isGood("ababab"));
        System.out.println(goodString.isGood("abaababababbaabbaaaabaababaabbabaaabbbbbbbb"));
        System.out.println(goodString.isGood("aaaaaaaabbbaaabaaabbabababababaabbbbaabbabbbbbbabb"));
    }

    public String isGood(String s) {
        if (s.length() % 2 != 0)
            return "Bad";

        while (s.contains("ab")) {
            s = s.replaceAll("ab", "");
        }
        return s.isEmpty() ? "Good" : "Bad";
    }
}
