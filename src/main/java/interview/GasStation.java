package interview;

/**
 * Created by nav on 1/10/16.
 */
public class GasStation {
    public static void main(String[] args) {
        System.out.println(GasStation.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 3, 2, 4, 5 }));
        System.out.println(GasStation.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 3, 3, 4, 5 }));
        System.out.println(GasStation.canCompleteCircuit(new int[] { 2, 2, 3, 4, 5 }, new int[] { 1, 3, 3, 4, 5 }));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            int gasSupply = 0;

            boolean success = true;
            for (int j = 0; j < gas.length && success; j++) {
                int pos = (j + start) % gas.length;
                int diff = gas[pos] - cost[pos];
                gasSupply += diff;
                if (gasSupply < 0)
                    success = false;
            }
            if (success)
                return start;
        }
        return -1;
    }
}
