package scenariobased.demo5;

import scenariobased.demo3.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Slicing of the stream
 */
public class Demo5 {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee("Prem", "Nashik", 45, "PP1234"),
                new Employee("Tushar", "Pune", 55, "TP1234"),
                new Employee("Shubham", "Pune", 25, "SV1234"),
                new Employee("Pratik", "Warje", 30, "PA5678"),
                new Employee("Akshay", "Mumbai", 22, "AA5678")
        );

        // Find all the ages of employees in ascending order
        List<Integer> ages = employeeList.stream()
                .map(Employee::getEmpAge)
                .sorted()
                .collect(Collectors.toList());

        // Find 2nd and 3rd youngest employees
        List<Integer> integers = ages.stream().skip(1).limit(2).toList();
        System.out.println("Find 2nd and 3rd youngest employees : " + integers);
        // Output :
        // Find 2nd and 3rd youngest employees : [25, 30]

        // Find 2nd highest old employee
        employeeList.stream()
                .map(Employee::getEmpAge)
                .sorted((o1, o2) -> o2.compareTo(o1))
                .skip(1)
                .limit(1)
                .toList()
                .stream().findAny()
                .ifPresent(age -> System.out.println("Find 2nd highest old employee: " + age));
        // Output :
        // Find 2nd highest old employee: 45

        // Get all the names of emp and want it in a comma separated format
        String collect = employeeList.stream()
                .map(Employee::getEmpName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("Get all the names of emp and want it in a comma separated format : " + collect);
        // Output :
        // Get all the names of emp and want it in a comma separated format : PREM, TUSHAR, SHUBHAM, PRATIK, AKSHAY

    }
}
