package scenariobased.demo5;

import scenariobased.demo3.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Slicing of the stream
 * <p>
 * Output :
 * Sorted Employee Ages based on ages in ascending order : [22, 25, 30, 45, 55]
 * Sorted Employee Object Based on Ages : [Employee{empName='Akshay', empAddress='Mumbai', empAge=22, empNumber='AA5678'}, Employee{empName='Shubham', empAddress='Pune', empAge=25, empNumber='SV1234'}, Employee{empName='Pratik', empAddress='Warje', empAge=30, empNumber='PA5678'}, Employee{empName='Prem', empAddress='Nashik', empAge=45, empNumber='PP1234'}, Employee{empName='Tushar', empAddress='Pune', empAge=55, empNumber='TP1234'}]
 * Find 2nd and 3rd youngest employees : [25, 30]
 * Find 2nd highest old employee: 45
 * Get all the names of emp and want it in a comma separated format : PREM, TUSHAR, SHUBHAM, PRATIK, AKSHAY
 */
public class Demo5 {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee("Prem", "Nashik", 45, "PP1234"),
                new Employee("Tushar", "Pune", 55, "TP1234"),
                new Employee("Shubham", "Pune", 25, "SV1234"),
                new Employee("Pratik", "Warje", 30, "PA5678"),
                new Employee("Akshay", "Mumbai", 22, "AA5678")
        );

        // Find all the sortedAges of employees in ascending order
        List<Integer> sortedAges = employeeList.stream()
                .map(Employee::getEmpAge)
                .sorted().toList();
        System.out.println("Sorted Employee Ages based on ages in ascending order : " + sortedAges);

        // Sort employeeList based on sortedAges
        List<Employee> sortedEmpListOnAges = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmpAge)).toList();
        System.out.println("Sorted Employee Object Based on Ages : " + sortedEmpListOnAges);

        // Find 2nd and 3rd youngest employees
        List<Integer> integers = sortedAges.stream().skip(1).limit(2).toList();
        System.out.println("Find 2nd and 3rd youngest employees : " + integers);

        // Find 2nd highest old employee
        employeeList.stream()
                .map(Employee::getEmpAge)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .toList()
                .stream().findAny()
                .ifPresent(age -> System.out.println("Find 2nd highest old employee: " + age));

        // Get all the names of emp and want it in a comma separated format
        String collect = employeeList.stream()
                .map(Employee::getEmpName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("Get all the names of emp and want it in a comma separated format : " + collect);
    }
}
