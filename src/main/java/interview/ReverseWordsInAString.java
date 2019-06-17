package interview;

/**
 * Created by nav on 12/22/15.
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(ReverseWordsInAString.reverseEverything("i ekil siht margorp yrev hcum"));
        System.out.println(ReverseWordsInAString.reverseWords("fun is stuff"));

    }

    public static String reverseEverything(String sentence) {
        char[] result = sentence.toCharArray();
        int i = 0;
        int j = result.length - 1;
        char temp;

        while (i < j) {
            temp = result[i];
            result[i] = result[j];
            result[j] = temp;
            i++;
            j--;
        }
        return new String(result);
    }

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }
}
