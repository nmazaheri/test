package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by navid.mazaheri on 12/31/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=13698
 */

public class OneEntrance {
    List[] list;

    public static void main(String[] args) {
        OneEntrance oneEntrance = new OneEntrance();
        //        System.out.println(oneEntrance.count(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 0));
        //        System.out.println(oneEntrance.count(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2));
        System.out.println(oneEntrance.count(new int[] { 0, 0, 0, 0 }, new int[] { 1, 2, 3, 4 }, 0));

        //        System.out.println(oneEntrance.count(new int[] { 0, 1, 1 }, new int[] { 1, 2, 3 }, 1));

    }

    public int count(int[] a, int[] b, int s) {
        if (a.length == 0)
            return 1;

        list = new ArrayList[a.length + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < a.length; i++) {
            list[a[i]].add(b[i]);
            list[b[i]].add(a[i]);
        }

        System.out.println(Arrays.toString(list));
        boolean[] visited = new boolean[list.length];
        Arrays.fill(visited, false);

        return countPathingOptions(s, visited);
    }

    private int countPathingOptions(int s, boolean[] visited) {
        Queue<Integer> stack = new LinkedList();
        stack.add(s);

        int combinations = 1;
        while (!stack.isEmpty()) {
            int nextNode = stack.remove();

            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.println(nextNode + " " + Arrays.toString(visited));

                List<Integer> adjacentRooms = list[nextNode];
                for (int adjacentRoom : adjacentRooms) {
                    if (!visited[adjacentRoom]) {
                        stack.add(adjacentRoom);
                    }
                }

                if (stack.size() > 1) {
                    for (int sa : stack) {
                        combinations += countPathingOptions(sa, visited.clone());
                    }
                }
            }
        }
        return combinations;
    }
}