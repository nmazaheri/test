package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by nav on 5/31/15.
 */
public class Intervals {
    public static void main(String[] args) {
        ArrayList<Interval> testInput = new ArrayList<>(
                Arrays.asList(new Interval(2, 5), new Interval(3, 8), new Interval(1, 5), new Interval(1, 2),
                        new Interval(11, 15)));
        System.out.println(Intervals.mergeIntervals(testInput));
    }

    public ArrayList<Interval> insertInterval(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                // after
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                // before
                result.add(newInterval);
                newInterval = interval;
            } else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
        return result;
    }

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> input) {
        if (input == null && input.size() <= 1)
            return input;

        Collections.sort(input);
        ArrayList<Interval> result = new ArrayList<Interval>();

        Interval prev = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            Interval cur = input.get(i);

            if (cur.start <= prev.end) {
                // merge case
                prev = new Interval(prev.start, Math.max(prev.end, cur.end));
            } else {
                result.add(prev);
                prev = cur;
            }
        }
        result.add(prev);
        return result;
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start +
                "," + end +
                ']';
    }

    @Override
    public int compareTo(Interval o) {
        return this.start - o.start;
    }
}