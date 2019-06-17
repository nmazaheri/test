package algorithms.sortMapValues;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {

    Map<Doctor, BigDecimal> data = new HashMap<>();

    public static void main(String[] args) {
        Main2 main = new Main2();
        main.fillData();
        System.out.println(main.getSecondHighestPaid());
    }

    private void fillData() {
        Doctor john = new Doctor(1, "john");
        Doctor frank = new Doctor(2, "frank");
        Doctor dillon = new Doctor(3, "dillon");
        Doctor jane = new Doctor(3, "jane");
        addToMap(john, new BigDecimal(5.5));
        addToMap(frank, new BigDecimal(3.5));
        addToMap(dillon, new BigDecimal(11.5));
        addToMap(john, new BigDecimal(5.5));
        addToMap(jane, new BigDecimal(6));
        addToMap(dillon, new BigDecimal(2));

        System.out.println(data);
    }

    private BigDecimal getSecondHighestPaid() {
        if (data.size() < 2) {
            return null;
        }
        return data.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()).get(data.size() - 2).getValue();
    }

    private void addToMap(Doctor doc, BigDecimal amt) {
        data.merge(doc, amt, BigDecimal::add);
    }
}