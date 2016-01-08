package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by navid.mazaheri on 1/5/16.
 * https://community.topcoder.com/stat?c=problem_statement&pm=10036&rd=13513
 */
public class BirthdayCake {
    public static void main(String[] args) {
        BirthdayCake birthdayCake = new BirthdayCake();
        System.out.println(birthdayCake.howManyFriends(new String[] { "apple", "orange", "strawberry", "cherry" },
                new String[] { "apple orange", "apple cherry", "strawberry orange", "cherry", "apple" }, 2));
        System.out.println(birthdayCake
                .howManyFriends(new String[] { "strawberry", "orange", "apple", "lemon", "watermelon" },
                        new String[] { "orange", "apple", "lemon", "watermelon" }, 1));
        System.out.println(
                birthdayCake.howManyFriends(new String[] { "apple", "orange" }, new String[] { "strawberry" }, 1));
    }

    public int howManyFriends(String[] availableFruits, String[] friendsDislikings, int K) {
        List<List<Integer>> fruitPeopleCanEat = new ArrayList<>();
        for (int fruitPos = 0; fruitPos < availableFruits.length; fruitPos++) {
            String fruit = availableFruits[fruitPos];
            fruitPeopleCanEat.add(new ArrayList<Integer>());

            for (int friendPos = 0; friendPos < friendsDislikings.length; friendPos++) {
                if (!Arrays.asList(friendsDislikings[friendPos].split(" ")).contains(fruit))
                    fruitPeopleCanEat.get(fruitPos).add(friendPos);
            }
        }
        System.out.println(fruitPeopleCanEat);
        List<Integer>[] dp = getBestFruitCombo(fruitPeopleCanEat, K, friendsDislikings);
        System.out.println(Arrays.toString(dp));
        return dp[K].size();
    }

    /**
     * returns an array with 0 to K elements which contains a list of the people who can eat.
     **/
    private List<Integer>[] getBestFruitCombo(List<List<Integer>> fruitPeopleCanEat, int K,
            String[] friendsDislikings) {
        List<Integer> bestChoice = new ArrayList();
        for (int i = 0; i < friendsDislikings.length; i++) {
            bestChoice.add(i);
        }

        int j = 0;
        List<Integer>[] dp = new ArrayList[K + 1];
        dp[j++] = bestChoice;
        while (j <= K) {
            bestChoice = new ArrayList();

            int maxPos = 0;
            for (int i = 0; i < fruitPeopleCanEat.size(); i++) {
                List<Integer> intersection = findIntersection(fruitPeopleCanEat.get(i), dp[j - 1]);
                int currentSize = intersection.size();
                if (bestChoice.size() < currentSize) {
                    maxPos = i;
                    bestChoice = intersection;
                }
            }
            dp[j++] = bestChoice;
            fruitPeopleCanEat.remove(maxPos);
        }
        return dp;
    }

    private List<Integer> findIntersection(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList(a);
        result.retainAll(b);
        return result;
    }
}
