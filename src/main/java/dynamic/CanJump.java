package dynamic;

/**
 * Created by nav on 6/1/15.
 */
public class CanJump {
    public static void main(String[] args) {
        System.out.println(CanJump.run(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println(CanJump.run(new int[] { 3, 2, 2, 0, 1 }));

    }

    public static boolean run(int[] arr) {
        int length = arr.length;
        if (length <= 1)
            return true;

        int max = arr[0];
        for (int i = 0; i < length; i++) {

            if (max <= i && arr[i] == 0)
                return false;

            if (i + arr[i] > max)
                max = i + arr[i];

            if (max >= length) {
                return true;
            }
        }
        return false;
    }
}
