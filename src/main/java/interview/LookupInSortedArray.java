package interview;

/**
 * Created by nav on 12/6/15.
 */
public class LookupInSortedArray {
    public static void main(String args[]) {
        LookupInSortedArray lookupInSortedArray = new LookupInSortedArray();
        System.out.println(lookupInSortedArray.findInsPoint("cfjpv", 'a'));
        System.out.println(lookupInSortedArray.findInsPoint("cfjpv", 'c'));
        System.out.println(lookupInSortedArray.findInsPoint("cfjpv", 'k'));
        System.out.println(lookupInSortedArray.findInsPoint("cfjpv", 'z'));
        System.out.println(lookupInSortedArray.findInsPoint("cfk", 'f'));
        System.out.println(lookupInSortedArray.findInsPoint("cfk", 'c'));
        System.out.println(lookupInSortedArray.findInsPoint("cfk", 'd'));
    }

    public char findInsPoint(String sortedString, char c) {
        char[] chars = sortedString.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;

            if (chars[middle] > c) {
                if (middle == 0 || chars[middle - 1] <= c)
                    return chars[middle];
                else
                    end = middle - 1;
            } else
                start = middle + 1;
        }
        return chars[0];
    }
}