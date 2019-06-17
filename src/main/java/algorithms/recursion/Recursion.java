package algorithms.recursion;

/**
 * Created by nav on 5/18/15.
 */
public class Recursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();

        int val = recursion.test(20);
        System.out.println();
        System.out.println("total = " + val);
        System.out.println();
        System.out.println(recursion.fib(12));
        System.out.println(recursion.fibIterative(5));
        System.out.println(recursion.factorial(6));

        System.out.println(recursion.getNumberSum(769));
        System.out.println(7+6+9);
    }

    int test(int input) {
        int decreaseBy = 5;

        if (input < decreaseBy) {
            System.out.print(input);
            return input;
        } else {
            System.out.print(input + " + ");
            return input + test(input - decreaseBy);
        }
    }

    int fib(int num) {
        if (num < 2) {
            return num;
        }
        return fib(num - 2) + fib(num - 1);
    }

    int fibIterative(int num) {
        int first = 0;
        int second = 1;
        int temp;
        for (int i = 0; i < num; i++) {
            temp = second;
            second = first+second;
            first = temp;
        }
        return first;
    }

    int factorial(int num) {
        if (num == 1)
            return num;

        return num * factorial(num - 1);
    }

    int getNumberSum(int num) {
        if (num < 10) {
            return num;
        }
        return num%10 + getNumberSum(num/10);
    }
}
