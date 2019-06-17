package algorithms.sortMapValues;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Map<Doctor, BigDecimal> data = new HashMap<>();
        data.put(new Doctor(1, "john"), BigDecimal.TEN);
        data.put(new Doctor(2, "frank"), BigDecimal.ONE);
        Doctor dillon = new Doctor(3, "dillon");
        data.put(dillon, BigDecimal.ONE.add(BigDecimal.ONE));
        data.forEach((k,v) -> System.out.println(k));

        //        data.computeIfAbsent(dillon, )
        System.out.println(data);

        List<Map.Entry<Doctor, BigDecimal>> list = new ArrayList<>(data.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        System.out.println(list);

        System.out.println(list.get(list.size() - 2).getKey());

        List<Map.Entry<Doctor, BigDecimal>> collect = data.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("test");
        List<Doctor> collect1 = data.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect1);


//        data.entrySet().stream().
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n * 2).limit(20);
        Iterator<Integer> iterator = streamIterated.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
