package interview;

import java.util.*;

public class SequenceFind {
    private Map<Integer, List<Integer>> data = new HashMap<>();

    List<List<Integer>> findSequences(List<Integer> input) {
        if (input.size() < 3) {
            return Collections.emptyList();
        }
        for (int i = 0; i < input.size() - 4; i++) {
            List<Integer> subList = input.subList(i, input.size());
            for (int distance = 2; 2 <= getAvailableSpots(subList.size(), distance); distance++) {
                List<Integer> seq = findLongestSequence(subList, distance);
                if (seq.size() >= 3 && (data.get(distance) == null || data.get(distance).size() < seq.size())) {
                    data.put(distance, seq);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        System.out.println(data.toString());
        int totalSum = 0;
        for (Map.Entry<Integer, List<Integer>> entry : data.entrySet()) {
            List<Integer> list = entry.getValue();
            result.add(list);
            int sequenceSum = list.stream().mapToInt(Integer::intValue).sum();
            totalSum += sequenceSum;
            System.out.printf("N=%d total is %d\n", entry.getKey(), sequenceSum);
        }
        System.out.println("total of all sequences is " + totalSum);
        return result;
    }

    private static int getAvailableSpots(int size, int distance) {
        return (size - 1) / distance;
    }

    List<Integer> findLongestSequence(List<Integer> input, int distance) {
        Integer previousValue = input.get(0);
        if (distance <= 1 || previousValue == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.add(previousValue);

        for (int i = distance; i < input.size(); i += distance) {
            Integer nextValue = input.get(i);
            if (previousValue * distance != nextValue) {
                return result;
            }
            result.add(nextValue);
            previousValue = nextValue;
        }
        return result;
    }
}
