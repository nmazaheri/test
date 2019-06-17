package sorting;

import java.util.PriorityQueue;

/**
 * Created by nav on 6/28/15.
 */
public class PriorityQueueTest {
    public static void main(String args[]) {
        Employee.NameSort empNameSort = new Employee.NameSort();
        Employee.AgeSort empAgeSort = new Employee.AgeSort();

        PriorityQueue<Employee> pq = new PriorityQueue<>(10, empNameSort);
        pq.offer(new Employee("John", "G", 56));
        pq.offer(new Employee("John", "Kilaw", 20));
        pq.offer(new Employee("John", "Kilaw", 38));


        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }


}
