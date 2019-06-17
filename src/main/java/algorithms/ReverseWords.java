package algorithms;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by nav on 9/26/15.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String message = "find you will pain only go you recordings security the into if";
        String result = ReverseWords.reverseWords3(message);
        System.out.println(message);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        String result = "";
        int endWordPos = s.length();
        for (int i = endWordPos - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                result += s.substring(i + 1, endWordPos) + " ";
                endWordPos = i;
            }
        }
        result += s.substring(0, endWordPos);
        return result;
    }

    public static String reverseWords2(String s) {
        String result = "";
        String[] sArr = s.split(" ");
        Collections.reverse(Arrays.asList(sArr));
        for (String word : sArr) {
            result += word + " ";
        }
        return result.substring(0, result.length()-1);
    }

    public static String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder(s.length() + 1);
        String[] sArr = s.split(" ");
        for (int i = sArr.length - 1; i >= 0; i--) {
            sb.append(sArr[i]).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
