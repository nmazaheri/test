package topcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navid.mazaheri on 12/9/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=14074
 */
public class SubstitutionCipher {
    public static void main(String[] args) {
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();
        System.out.println(substitutionCipher.decode("CAT", "DOG", "GOD"));
        System.out.println(substitutionCipher.decode("BANANA", "METETE", "TEMP"));
        System.out.println(substitutionCipher
                .decode("THEQUICKBROWNFOXJUMPSOVERTHELAZYHOG", "UIFRVJDLCSPXOGPYKVNQTPWFSUIFMBAZIPH",
                        "DIDYOUNOTICESKIPPEDLETTER"));
    }

    public String decode(String a, String b, String y) {
        Map<Character, Character> code = new HashMap();
        for (int i = 0; i < a.length(); i++) {
            code.put(b.charAt(i), a.charAt(i));
        }

        if (code.size() == 25) {
            char missingKey = 0;
            char missingValue = 0;
            for (char i = 'A'; i <= 'Z'; i++) {
                if (!code.containsKey(i))
                    missingKey = i;

                if (!code.containsValue(i))
                    missingValue = i;

                if (missingKey != 0 && missingValue != 0)
                    break;
            }
            code.put(missingKey, missingValue);
        }

        StringBuilder result = new StringBuilder();
        for (char c : y.toCharArray()) {
            if (!code.containsKey(c))
                return "";
            result.append(code.get(c));
        }
        return result.toString();
    }
}