package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nav on 6/28/15.
 */
public class CollectionsSortTest {
    public static void main(String args[]) {
        Employee.NameSort empNameSort = new Employee.NameSort();
        Employee.AgeSort empAgeSort = new Employee.AgeSort();

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Franko", 56));
        employees.add(new Employee("John", "Kilaw", 20));
        employees.add(new Employee("John", "Kilaw", 25));
        employees.add(new Employee("John", "Kilaw", 15));

        // use empNameSort
        Collections.sort(employees);
        printEmployees(employees);

        // use empAgeSort
        Collections.sort(employees, empAgeSort);
        printEmployees(employees);

        // use comparable
        Collections.sort(employees);
        printEmployees(employees);
    }

    private static void printEmployees(List<Employee> employees) {
        for(Employee e: employees) {
            System.out.println(e);
        }
        System.out.println();
    }
}
