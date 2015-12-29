package division2;

/**
 * Created by navid.mazaheri on 12/28/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=13947
 */
public class CombiningSlimes {
    public static void main(String[] args) {
        CombiningSlimes combiningSlimes = new CombiningSlimes();
        System.out.println(combiningSlimes.maxMascots(new int[] { 3, 4 }));
        System.out.println(combiningSlimes.maxMascots(new int[] { 2, 2, 2 }));
        System.out.println(combiningSlimes.maxMascots(new int[] { 1, 2, 3 }));
        System.out.println(combiningSlimes.maxMascots(new int[] { 3, 1, 2 }));
        System.out.println(combiningSlimes.maxMascots(new int[] { 7, 6, 5, 3, 4, 6 }));
    }

    public int maxMascots(int[] a) {
        int mascots = a[0] * a[1];
        int slimeSize = a[0] + a[1];
        for(int i = 2; i<a.length; i++) {
            mascots += slimeSize * a[i];
            slimeSize += a[i];
        }
        return mascots;
    }
}
