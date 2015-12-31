package topcoder.division2;

/**
 * Created by navid.mazaheri on 12/13/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=14060
 * <p/>
 * Your goal is to change s into a string with negativity at most k in the fewest steps possible
 */
public class Drbalance {
    public static void main(String[] args) {
        Drbalance drBalance = new Drbalance();
        System.out.println(drBalance.lesscng("---", 1));
        System.out.println(drBalance.lesscng("+-+-", 0));
        System.out.println(drBalance.lesscng("-+-+---", 2));
        System.out.println(drBalance.lesscng("-------++", 3));
        System.out.println(drBalance.lesscng("-+--+--+--++++----+", 3));
    }

    public int lesscng(String s, int k) {
        char[] chars = s.toCharArray();
        int ans = 0;
        while (getNegativityCount(chars) > k) {
            ++ans;
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] == '-') {
                    chars[i] = '+';
                    break;
                }
            }
        }
        return ans;
    }

    public int getNegativityCount(char[] chars) {
        int bal = 0;
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+')
                bal++;
            else
                bal--;

            if (bal < 0) {
                cnt++;
            }
        }
        return cnt;
    }
}