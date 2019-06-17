package sorting;

import java.util.Arrays;

/**
 * Created by nav on 6/28/15.
 */
public class ArraySortTest {
    public static void main(String args[]) {
        Employee.NameSort empNameSort = new Employee.NameSort();
        Employee.AgeSort empAgeSort = new Employee.AgeSort();

        Employee[] employees = new Employee[3];
        employees[0] = new Employee("John", "Franko", 56);
        employees[1] = new Employee("John", "Kilaw", 20);
        employees[2] = new Employee("Frank", "Kilaw", 25);
        Arrays.sort(employees, empAgeSort);

        for(Employee e: employees) {
            System.out.println(e);
        }
    }
}
