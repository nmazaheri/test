package algorithms;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by nav on 5/11/15.
 */
public class Strings {
    public static void main(String[] args) {
        System.out.println(Strings.isUniqueChars("abc"));
        System.out.println(new StringBuilder("abcdef").reverse().toString());
        System.out.println(Strings.reverseStringWithDataStructure("abc"));
        System.out.println(Strings.reverseString("abcabd"));
        System.out.println(Strings.reverseString2("abcabe"));
        System.out.println(Strings.isPalindrome("abcabe"));
        System.out.println(Strings.isPalindrome("aba"));
        System.out.println(Strings.isAnagram("army", "mary"));

        String spaceTest = "some crazy stuff";
        System.out.println(Strings.replaceSpaces(spaceTest));
        System.out.println(Strings.replaceSpaces(spaceTest.toCharArray()));

        System.out.println(Strings.isRotation("waterbottle", "erbottlewat"));

        int[] array = new int[] { 1, 2, 3 };
        int[] rotateArray = Strings.rotate(array, 1);
        System.out.println(Arrays.toString(array) + " becomes " + Arrays.toString(rotateArray));
        Strings.printUrl("http://www.pandora.com/radio/stations?genre=Rock&paid=1&iphone=true");
        Strings.printUrl("http://www.pandora.com/radio/stations");
        System.out.println(isNumber("-234"));
        System.out.println(isNumber("2a34"));
        System.out.println(isNumber("+23.4"));
        System.out.println(isNumber("2.3.4"));
        System.out.println(fromIntegerToBinaryString(8));
    }

    public static boolean isUniqueChars(String str) {
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val])
                return false;

            charSet[val] = true;
        }
        return true;
    }

    // reverse a symbol using data struct
    public static String reverseStringWithDataStructure(String input) {
        Stack stack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversedInput = "";
        while (!stack.isEmpty()) {
            reversedInput += stack.pop();
        }

        return reversedInput;

    }

    // reverse a symbol in place
    public static String reverseString(String input) {
        int i, len = input.length();

        StringBuilder reversedInput = new StringBuilder(len);
        for (i = (len - 1); i >= 0; i--) {
            reversedInput.append(input.charAt(i));
        }
        return reversedInput.toString();
    }

    public static String reverseString2(String input) {
        int i, len = input.length();

        String reversedInput = "";
        for (i = (len - 1); i >= 0; i--) {
            reversedInput += input.charAt(i);
        }
        return reversedInput;
    }

    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty())
            return false;

        String reversedInput = Strings.reverseString2(input);
        if (input.equals(reversedInput))
            return true;

        return false;
    }

    public static boolean isAnagram(String input, String input2) {
        // StringUtils isNotBlank check for each argument
        if (input.length() != input2.length())
            return false;

        char[] chars = input.toCharArray();
        for (char c : chars) {
            int index = input2.indexOf(c);
            if (index == -1)
                return false;

            // check unique count
            input2 = input2.substring(0, index) + input2.substring(index + 1);
        }
        return input2.isEmpty();
    }

    public static String replaceSpaces(String input) {
        return input.replace(" ", "%20");
    }

    public static String replaceSpaces(char[] input) {
        int spaceCount = 0;
        for (char c : input) {
            if (c == ' ')
                spaceCount++;
        }

        int size = input.length;
        char[] result = new char[size + 2 * spaceCount];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (input[i] == ' ') {
                result[j++] = '%';
                result[j++] = '2';
                result[j++] = '0';
            } else {
                result[j++] = input[i];
            }
        }
        return new String(result);
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String concat = s1 + s1;
            return concat.contains(s2);
        }
        return false;
    }

    public static int[] rotate(int[] num, int k) {
        int len = num.length;
        if (k > len) {
            k = k % len;
        }

        int[] result = new int[len];
        int startOfArray = 0;
        int midpoint = len - k;
        System.arraycopy(num, k, result, startOfArray, midpoint);
        System.arraycopy(num, startOfArray, result, midpoint, k);
        return result;
    }

    public static void printUrl(String input) {
        String[] parameterString = input.split("\\?");
        if (parameterString.length < 2)
            return;

        String[] parameterPairs = parameterString[1].split("[&=]");
        if (parameterPairs.length < 2 || parameterPairs.length % 2 != 0)
            throw new IllegalArgumentException("Missing & : " + input);

        for (int i = 0; i < parameterPairs.length; i++) {
            String key = parameterPairs[i++];
            String value = parameterPairs[i];
            System.out.println("Key=" + key + " value=" + value);
        }
    }

    public static boolean isNumber(String input) {
        if (input == null)
            return false;

        boolean hasDecimal = false;
        int j = 0;
        char num = input.charAt(j);
        if (num == '+' || num == '-')
            j++;

        for (int i = j; i < input.length(); i++) {
            num = input.charAt(i);
            if (num == '.') {
                if (hasDecimal)
                    return false;
                hasDecimal = true;
            } else if (num < '0' || num > '9')
                return false;
        }
        return true;
    }

    //Given an integer, return Binary representation as Java String
    public static String fromIntegerToBinaryString(Integer input) {
        if (input == null || input < 1)
            return "0";

        int i = 1;
        while (Math.pow(2, i) <= input) {
            i++;
        }
        // prevent first 0, does not really matter
        int divisor = (int) Math.pow(2, i - 1);

        StringBuilder sb = new StringBuilder();
        while (divisor > 0) {
            if (input >= divisor) {
                sb.append(1);
                input = input % divisor;
            } else
                sb.append(0);

            divisor /= 2;
        }
        return sb.toString();
    }

}
