package scenariobased.demo4;

import scenariobased.demo3.Employee;

import java.util.List;

/**
 * Operations using SummaryStatistics
 */
public class Demo4 {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee("Prem", "Nashik", 45, "PP1234"),
                new Employee("Tushar", "Pune", 55, "TP1234"),
                new Employee("Shubham", "Pune", 25, "SV1234"),
                new Employee("Pratik", "Warje", 30, "PA5678"),
                new Employee("Akshay", "Mumbai", 25, "AA5678"),
                new Employee("Akshay", "Mumbai", 25, "AA5678")
        );

//        Find Summary Statistics
        List<Integer> collect3 = employeeList.stream().map(Employee::getEmpAge).toList();
        String summaryStatistics = collect3.stream().mapToInt(value -> value).summaryStatistics().toString();
        System.out.println("Summary Statistics : " + summaryStatistics);
//        Output
//        Summary Statistics : IntSummaryStatistics{count=6, sum=205, min=25, average=34.166667, max=55}

//         Find min and max age
        int min = employeeList.stream().map(Employee::getEmpAge).mapToInt(value -> value).summaryStatistics().getMin();
        int max = employeeList.stream().map(Employee::getEmpAge).mapToInt(value -> value).summaryStatistics().getMax();
        System.out.println("Min age: " + min + " Max age: " + max);
//        Output
//        Min age: 25 Max age: 55
    }
}
