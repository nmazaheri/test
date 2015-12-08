package division2;

import java.util.HashMap;

/**
 * Created by navid.mazaheri on 12/3/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=3450
 */

public class GroceryBagger {
    public static void main(String args[]) {
        GroceryBagger bagger = new GroceryBagger();
        System.out.println(
                bagger.minimumBags(2, new String[] { "DAIRY", "DAIRY", "PRODUCE", "PRODUCE", "PRODUCE", "MEAT" }));
        System.out.println(
                bagger.minimumBags(3, new String[] { "DAIRY", "DAIRY", "PRODUCE", "PRODUCE", "PRODUCE", "MEAT" }));
        System.out.println(bagger.minimumBags(10, new String[] {}));
        System.out.println(bagger.minimumBags(5,
                new String[] { "CANNED", "CANNED", "PRODUCE", "DAIRY", "MEAT", "BREAD", "HOUSEHOLD", "PRODUCE",
                        "FROZEN", "PRODUCE", "DAIRY" }));
        System.out.println(bagger.minimumBags(2,
                new String[] { "CANNED", "CANNED", "PRODUCE", "DAIRY", "MEAT", "BREAD", "HOUSEHOLD", "PRODUCE",
                        "FROZEN", "PRODUCE", "DAIRY" }));

    }

    public int minimumBags(int strength, String[] itemType) {
        HashMap<String, Integer> items = new HashMap();
        for (String item : itemType) {
            if (!items.containsKey(item))
                items.put(item, 1);
            else
                items.put(item, items.get(item) + 1);
        }

        int bagCount = 0;
        for (int itemCount : items.values()) {
            bagCount++;
            if (itemCount > strength)
                bagCount += itemCount / strength;
        }
        return bagCount;
    }
}
