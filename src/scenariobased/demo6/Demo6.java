package scenariobased.demo6;

import scenariobased.demo3.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find emp names those are in same city
 * <p>
 * Output :
 * Employees lives in same city :
 * {Satara=[Employee{empName='Pratik', empAddress='Satara', empAge=30, empNumber='PA5678'}],
 * Pune=[Employee{empName='Tushar', empAddress='Pune', empAge=55, empNumber='TP1234'}, Employee{empName='Shubham', empAddress='Pune', empAge=25, empNumber='SV1234'}],
 * Nashik=[Employee{empName='Prem', empAddress='Nashik', empAge=45, empNumber='PP1234'}],
 * Mumbai=[Employee{empName='Akshay', empAddress='Mumbai', empAge=25, empNumber='AA5678'}]}
 */
public class Demo6 {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee("Prem", "Nashik", 45, "PP1234"),
                new Employee("Tushar", "Pune", 55, "TP1234"),
                new Employee("Shubham", "Pune", 25, "SV1234"),
                new Employee("Pratik", "Satara", 30, "PA5678"),
                new Employee("Akshay", "Mumbai", 25, "AA5678")
        );

        Map<String, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAddress));

        System.out.println("Employees lives in same city : " + collect);
    }
}
