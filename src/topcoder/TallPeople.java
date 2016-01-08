package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2923
 **/

public class TallPeople {
    public static void main(String args[]) {
        TallPeople tallPeople = new TallPeople();
        System.out.println(Arrays.toString(tallPeople.getPeople(new String[] { "9 2 3", "4 8 7" })));
        System.out.println(Arrays.toString(tallPeople.getPeople(new String[] { "1 2", "4 5", "3 6" })));
        System.out.println(Arrays.toString(tallPeople.getPeople(new String[] { "1 1", "1 1" })));
    }

    public int[] getPeople(String[] people) {
        if (people == null || people.length < 1) {
            return null;
        }

        List<Integer> tallestColumnList = new ArrayList();
        int tallestOfShortestRow = Integer.MIN_VALUE;

        for (String row : people) {
            int shortestPersonInRow = handleRow(row.split(" "), tallestColumnList);
            tallestOfShortestRow = Math.max(tallestOfShortestRow, shortestPersonInRow);
        }

        Collections.sort(tallestColumnList);
        return new int[] { tallestOfShortestRow, tallestColumnList.get(0) };

    }

    private int handleRow(String[] row, List<Integer> tallestColumnList) {
        int shortestPersonInRow = Integer.MAX_VALUE;

        for (int i = 0; i < row.length; i++) {
            int currentHeight = Integer.parseInt(row[i]);
            shortestPersonInRow = Math.min(currentHeight, shortestPersonInRow);

            if (tallestColumnList.size() < row.length)
                tallestColumnList.add(currentHeight);
            else if (tallestColumnList.get(i) < currentHeight)
                tallestColumnList.set(i, currentHeight);
        }

        return shortestPersonInRow;
    }
}
