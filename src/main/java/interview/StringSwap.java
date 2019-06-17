package interview;

/**
 * Created by nav on 12/18/15.
 */
public class StringSwap {
    public static void main(String[] args) {
        StringSwap stringSwap = new StringSwap();
        System.out.println(stringSwap.swap("awesomeman", "awesome", "boring"));
        System.out.println(stringSwap.swap("manawesome", "awesome", "boring"));
        System.out.println(stringSwap.swap("awesometheawesomemanawesome", "awesome", "boring"));
    }

    public String swap(String original, String find, String replace) {
        if (!original.contains(find))
            return original;

        StringBuilder result = new StringBuilder();
        int index = original.indexOf(find);
        result.append(original.substring(0, index));
        result.append(replace);
        String remainder = original.substring(index + find.length(), original.length());
        result.append(swap(remainder, find, replace));
        return result.toString();
    }
}
