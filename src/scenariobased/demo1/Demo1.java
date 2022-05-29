package scenariobased.demo1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given List<Employee> has id, salary, deptid,status
 *
 * Program to print Max emp salary from given collection
 * Program to print Min emp salary from given collection
 * Program to print max salary of an emp from each dept
 * Program to print active and inactive emps from each dept
 * Program to print emp details working in each dept
 * Program to print emps count working in each dept
 */
public class Demo1 {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(new Employee(1, 10000, 101, "active"),
                new Employee(2, 9000, 102, "inactive"),
                new Employee(3, 6000, 101, "active"),
                new Employee(4, 8000, 103, "inactive"),
                new Employee(5, 15000, 102, "active"));

        // Program to print Max emp salary from given collection
        employeeList.stream().mapToInt(Employee::getSalary).max().ifPresent(System.out::println);

        // Program to print Min emp salary from given collection
        employeeList.stream().mapToInt(Employee::getSalary).min().ifPresent(System.out::println);

        // Program to print max salary of an emp from each dept
        Map<Integer, Employee> employeeMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getDeptId, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary))));
        employeeMap.forEach((integer, employee) -> System.out.println("Dept : " + integer + " --> " + "Max Emp Salary : " + employee.getSalary()));

        Map<Integer, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptId));
        collect.forEach((dept, employees) -> {
            System.out.println("Dept : " + dept);
            employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(employee -> System.out.println("Max Emp Salary : " + employee.getSalary()));
        });

        // Program to print active and inactive emps from each dept
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                        Collectors.mapping(Employee::getEmpId, Collectors.toList())))
                .forEach((s, integers) -> System.out.println("Status : " + s + " --> EmpIds :  " + integers.toString()));


        // Program to print emp details working in each dept
        Map<Integer, List<Employee>> collect1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId));
        collect1.forEach((integer, employees) -> {
            System.out.println("Dept : " + integer);
            employees.forEach(employee -> System.out.println(employee.toString()));
        });

        // Program to print emps count working in each dept
        Map<Integer, Long> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
        collect3.forEach((integer, aLong) -> System.out.println("Dept : " + integer + " --> Emp Count : " + aLong));

    }
}
