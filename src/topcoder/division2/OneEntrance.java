package topcoder.division2;

import java.util.List;

/**
 * Created by navid.mazaheri on 12/31/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=13698
 */
public class OneEntrance {
    public static void main(String[] args) {
        OneEntrance oneEntrance = new OneEntrance();
        System.out.println(oneEntrance.count(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 0));
    }

    public int count(int[] a, int[] b, int s) {
        int[] forward = new int[a.length];
        int[] backwards = new int[a.length];
        for(int i = 0; i<a.length; i++) {
            forward[a[i]] = b[i];
            backwards[b[i]] = a[i];
        }


        List<Integer> path = new java.util.LinkedList<>();
        path.add(s);
        while (true) {

        }

    }
}
