package scenariobased.demo3;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Operations using groupingBy
 */
public class Demo3 {
    public static void main(String[] args) {

        List<Employee> employeeList = List.of(new Employee("Prem", "Nashik", 45, "PP1234"),
                new Employee("Tushar", "Pune", 55, "TP1234"),
                new Employee("Shubham", "Pune", 25, "SV1234"),
                new Employee("Pratik", "Warje", 30, "PA5678"),
                new Employee("Akshay", "Mumbai", 25, "AA5678"),
                new Employee("Akshay", "Mumbai", 25, "AA5678")
        );

        System.out.println("Create Map where key is age of emp and value is/are object/group of objects of employee : ");
        Map<Integer, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAge));

        collect.forEach((age, employees) -> System.out.println(age + employees.toString()));

        System.out.println("Remove duplicates from above example");
        Map<Integer, Set<Employee>> collect1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAge, Collectors.toSet()));
        collect1.forEach((age, employees) -> System.out.println(age + employees.toString()));

        System.out.println("I want sorted map instead of hashmap");
        TreeMap<Integer, Set<Employee>> collect2 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpAge, TreeMap::new, Collectors.toSet()));
        collect2.forEach((age, employees) -> System.out.println(age + employees.toString()));

//        OutPut :
//        Create Map where key is age of emp and value is/are object/group of objects of employee :
//        55[Employee{empName='Tushar', empAddress='Pune', empAge=55, empNumber='TP1234'}]
//        25[Employee{empName='Shubham', empAddress='Pune', empAge=25, empNumber='SV1234'}, Employee{empName='Akshay', empAddress='Mumbai', empAge=25, empNumber='AA5678'}, Employee{empName='Akshay', empAddress='Mumbai', empAge=25, empNumber='AA5678'}]
//        45[Employee{empName='Prem', empAddress='Nashik', empAge=45, empNumber='PP1234'}]
//        30[Employee{empName='Pratik', empAddress='Warje', empAge=30, empNumber='PA5678'}]
//        Remove duplicates from above example
//        55[Employee{empName='Tushar', empAddress='Pune', empAge=55, empNumber='TP1234'}]
//        25[Employee{empName='Shubham', empAddress='Pune', empAge=25, empNumber='SV1234'}, Employee{empName='Akshay', empAddress='Mumbai', empAge=25, empNumber='AA5678'}]
//        45[Employee{empName='Prem', empAddress='Nashik', empAge=45, empNumber='PP1234'}]
//        30[Employee{empName='Pratik', empAddress='Warje', empAge=30, empNumber='PA5678'}]
//        I want sorted map instead of hashmap
//        25[Employee{empName='Shubham', empAddress='Pune', empAge=25, empNumber='SV1234'}, Employee{empName='Akshay', empAddress='Mumbai', empAge=25, empNumber='AA5678'}]
//        30[Employee{empName='Pratik', empAddress='Warje', empAge=30, empNumber='PA5678'}]
//        45[Employee{empName='Prem', empAddress='Nashik', empAge=45, empNumber='PP1234'}]
//        55[Employee{empName='Tushar', empAddress='Pune', empAge=55, empNumber='TP1234'}]

    }
}
