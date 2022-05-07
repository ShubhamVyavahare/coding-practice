package scenariobased.demo8;

import scenariobased.demo3.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Given an employee DB fetch employee by id and return the name of employee.
 * If it's not present return default name using java 8
 * <p>
 * Output:
 * In callMe method
 * Emp name : Shubham
 * ----------------------------
 * Emp name : Shubham
 * ----------------------------
 * In callMe method
 * Emp name using orElse method : Unknown employee
 * ----------------------------
 * In callMe method
 * Emp name using orElseGet method : Unknown employee
 * ----------------------------
 * Exception in thread "main" java.lang.IllegalArgumentException: The corresponding employee name not found !!!
 * 	at scenariobased.demo8.Demo8.lambda$main$11(Demo8.java:75)
 * 	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
 * 	at scenariobased.demo8.Demo8.lambda$main$12(Demo8.java:75)
 * 	at java.base/java.util.Optional.ifPresent(Optional.java:178)
 * 	at scenariobased.demo8.Demo8.main(Demo8.java:74)
 * 	----------------------------
 * <p>
 * hence do not use orElse if not required, possible then use only orElseGet method - check difference between orElse and orElseGet
 */
public class Demo8 {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee(null, "Pune", 30, "1234"),
                new Employee("Shubham", "Akole", 25, "5678"));

        employeeList.stream()
                .filter(employee -> employee.getEmpNumber().equals("5678"))
                .toList()
                .stream().findAny().ifPresent(employee -> {
                    // check callMe here - now the empName is Shubham still callMe method is called from orElse
                    String empNm = Optional.ofNullable(employee.getEmpName()).orElse(callMe());
                    System.out.println("Emp name : " + empNm);
                    System.out.println("----------------------------");
                });

        employeeList.stream()
                .filter(employee -> employee.getEmpNumber().equals("5678"))
                .toList()
                .stream().findAny().ifPresent(employee -> {
                    // check callMe here - now the empName is Shubham, then callMe method is not called from orElseGet
                    String empNm = Optional.ofNullable(employee.getEmpName()).orElseGet(() -> callMe());
                    System.out.println("Emp name : " + empNm);
                    System.out.println("----------------------------");
                });

        employeeList.stream()
                .filter(employee -> employee.getEmpNumber().equals("1234"))
                .toList()
                .stream().findAny().ifPresent(employee -> {
                    String empNm = Optional.ofNullable(employee.getEmpName()).orElse(callMe());
                    System.out.println("Emp name using orElse method : " + empNm);
                    System.out.println("----------------------------");
                });

        employeeList.stream()
                .filter(employee -> employee.getEmpNumber().equals("1234"))
                .toList()
                .stream().findAny().ifPresent(employee -> {
                    String empNm = Optional.ofNullable(employee.getEmpName()).orElseGet(() -> callMe());
                    System.out.println("Emp name using orElseGet method : " + empNm);
                    System.out.println("----------------------------");
                });

        employeeList.stream()
                .filter(employee -> employee.getEmpNumber().equals("1234"))
                .toList()
                .stream().findAny().ifPresent(employee -> {
                    String empNm = Optional.ofNullable(employee.getEmpName()).orElseThrow(() -> new IllegalArgumentException("The corresponding employee name not found !!!"));
                    System.out.println("Emp name using orElseGet method : " + empNm);
                    System.out.println("----------------------------");
                });
    }

    private static String callMe() {
        System.out.println("In callMe method");
        return "Unknown employee";
    }
}
