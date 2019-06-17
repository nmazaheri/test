package algorithms;

/**
 * Created by nav on 6/14/15.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(AddBinary.addBinary("1", "101"));
    }

    public static String addBinary(String a, String b) {
        int result = Integer.parseInt(a, 2) + Integer.parseInt(b,2);
        return Integer.toBinaryString(result);
    }
}
