package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nav on 12/22/15.
 */

public class YelpV2 {
    public static void main(String[] args) {
        YelpV2 yelpV2 = new YelpV2();
        List<String> input = yelpV2.readFromStdin();
        yelpV2.sortAndPrint(input);
        // new String[] { "1000 2", "1005 5", "1001 5", "999 1" }
    }

    public List<String> readFromStdin() {
        List<String> result = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;

            while((input=br.readLine()) != null) {
                result.add(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void sortAndPrint(List<String> in) {
        if (in == null | in.isEmpty())
            return;

        List<Business> businessList = new ArrayList<>();
        for (String row : in) {
            String[] items = row.split(" ");
            if (items != null && items.length == 2)
                businessList.add(new Business(Integer.parseInt(items[0]), Integer.parseInt(items[1])));
        }

        Collections.sort(businessList);
        for (Business b : businessList) {
            System.out.println(b);
        }
    }

    private class Business implements Comparable {
        private int businessId;
        private int rating;

        public Business(int businessId, int rating) {
            this.businessId = businessId;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return businessId + " " + rating;
        }

        @Override
        public int compareTo(Object o) {
            Business b = (Business) o;
            if (this.rating > b.rating)
                return -1;
            else if (this.rating < b.rating)
                return 1;
            else
                return 0;
        }
    }

}
