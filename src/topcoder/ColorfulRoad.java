package topcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navid.mazaheri on 12/30/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=12837
 */
public class ColorfulRoad {
    Map<Character, Character> nextChar;

    public ColorfulRoad() {
        nextChar = new HashMap();
        nextChar.put('R', 'G');
        nextChar.put('G', 'B');
        nextChar.put('B', 'R');
    }

    public static void main(String[] args) {
        ColorfulRoad colorfulRoad = new ColorfulRoad();
        System.out.println(colorfulRoad.getMin("RGGGB"));
        System.out.println(colorfulRoad.getMin("RGBRGBRGB"));
        System.out.println(colorfulRoad.getMin("RBBGGGRR"));
        System.out.println(colorfulRoad.getMin("RBRRBGGGBBBBR"));
        System.out.println(colorfulRoad.getMin("RG"));
        System.out.println(colorfulRoad.getMin("RBRGBGBGGBGRGGG"));
    }

    public int getMin(String road) {
        if (road.length() == 1)
            return 0;

        int result = Integer.MAX_VALUE;
        char nextChar = this.nextChar.get(road.charAt(0));

        for (int i = 1; i < road.length(); i++) {
            if (road.charAt(i) == nextChar) {
                int m = getMin(road.substring(i));
                if (m != -1)
                    result = Math.min(result, i * i + m);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
