package dynamic;


/**
 * Created by nav on 6/1/15.
 */
public class EggDropping {

    public int calculate(int eggs, int floors) {
        // init T to zeroes
        int T[][] = new int[eggs + 1][floors + 1];
        for (int i = 1; i <= floors; i++) {
            T[1][i] = i;
        }

        for (int e = 2; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                T[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    int c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
                    if (c < T[e][f]) {
                        T[e][f] = c;
                    }
                }
            }
        }
        for (int[] row : T) {
            for (int column = 0; column < row.length; column++) {
                System.out.print(row[column]);
                if (row[column] > 9) {
                    System.out.print("| ");
                } else {
                    System.out.print(" | ");
                }
            }
            System.out.println("");
        }

        return T[eggs][floors];
    }

    public int calculateRecursive(int eggs, int floors) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0) {
            return 0;
        }
        int minAttempts = Integer.MAX_VALUE;
        for (int floor = 1; floor <= floors; floor++) {
            int attempts = 1 + Math.max(calculateRecursive(eggs - 1, floor - 1), calculateRecursive(eggs, floors - floor));
            minAttempts = Math.min(minAttempts, attempts);
        }
        return minAttempts;
    }

    public int calculateIdealEggs(int floors) {
        if (floors < 1) {
            return 0;
        }
        int result;
        int eggs = 1;
        int oldResult = calculate(eggs, floors);

        while (true) {
            result = calculate(++eggs, floors);
            if (oldResult == result)
                return eggs - 1;

            oldResult = result;
        }
    }

    public static void main(String args[]) {
        EggDropping ed = new EggDropping();
        int floors = 50;
        System.out.println(ed.calculate(5, floors));
        //        for (int eggs = 3; eggs <= 10; eggs++) {
        //            //            int eggs = ed.calculateIdealEggs(floors);
        //            System.out.println("eggs = " + eggs + "; floors = " + floors + " and number of iterations = " + ed
        //                    .calculate(eggs, floors));
        //        }
    }
}