package sorting;

import java.util.Comparator;

/**
 * Created by nav on 6/28/15.
 */
public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (!this.getLastName().equals(o.getLastName())) {
            return this.getLastName().compareTo(o.getLastName());
        }
        if (!this.getFirstName().equals(o.getFirstName())) {
            return this.getFirstName().compareTo(o.getFirstName());
        }
        return this.getAge() - o.getAge();
    }

    public static class NameSort implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            if (!o1.getLastName().equals(o2.getLastName())) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }

    public static class AgeSort implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    }
}

