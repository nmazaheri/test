package topcoder.division2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by navid.mazaheri on 12/29/15.
 */
public class IsItASquare {
    public static void main(String[] args) {
        IsItASquare isItASquare = new IsItASquare();
        System.out.println(isItASquare.isSquare(new int[] { 0, 0, 2, 2 }, new int[] { 0, 2, 0, 2 }));
        System.out.println(isItASquare.isSquare(new int[] { 0, 1, 5, 6 }, new int[] { 1, 6, 0, 5 }));
        System.out.println(isItASquare.isSquare(new int[] { 0, 0, 7, 7 }, new int[] { 0, 3, 0, 3 }));
        System.out
                .println(isItASquare.isSquare(new int[] { 0, 5000, 5000, 10000 }, new int[] { 5000, 0, 10000, 5000 }));
        System.out.println(isItASquare.isSquare(new int[] { 1, 2, 3, 4 }, new int[] { 4, 3, 2, 1 }));
        System.out.println(isItASquare.isSquare(new int[] { 0, 5, 3, 8 }, new int[] { 0, 0, 4, 4 }));

    }

    public String isSquare(int[] x, int[] y) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int dx = x[i] - x[j], dy = y[i] - y[j];
                list.add(dx * dx + dy * dy);
            }
        }

        Collections.sort(list);
        int l = list.get(0);
        if (list.get(1) == l && list.get(2) == l && list.get(3) == l && list.get(4) == l * 2 && list.get(5) == l * 2)
            return "It's a square";
        return "Not a square";
    }

}
