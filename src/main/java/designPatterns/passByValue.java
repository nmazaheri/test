package designPatterns;


/**
 * Created by nav on 7/13/15.
 */
public class passByValue {
    public static void main(String[] args) {
        Integer x = 55;
        passByValue.doStuff(x);
        System.out.println(x);
    }

    public static void doStuff(Integer i) {
        System.out.println(i);
        i--;
        System.out.println(i);
    }
}
