package scenariobased.demo6;

import scenariobased.demo3.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find emp names those are in same city
 */
public class Demo6 {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee("Prem", "Nashik", 45, "PP1234"),
                new Employee("Tushar", "Pune", 55, "TP1234"),
                new Employee("Shubham", "Pune", 25, "SV1234"),
                new Employee("Pratik", "Warje", 30, "PA5678"),
                new Employee("Akshay", "Mumbai", 25, "AA5678")
        );
        Map<String, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAddress));
        collect.forEach((address, employees) -> {
            System.out.println("Address : " + address);
            System.out.println("Employees : ");
            employees.forEach(employee -> System.out.println(employee.getEmpName()));
        });

//        Output :
//        Address : Warje
//        Employees :
//        Pratik
//        Address : Pune
//        Employees :
//        Tushar
//                Shubham
//        Address : Nashik
//        Employees :
//        Prem
//        Address : Mumbai
//        Employees :
//        Akshay

    }
}
