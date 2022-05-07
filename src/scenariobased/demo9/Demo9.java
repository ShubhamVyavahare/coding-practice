package scenariobased.demo9;

import java.util.Arrays;
import java.util.List;

public class Demo9 {
    public static void main(String[] args) {
        List<Emp> empList = Arrays.asList(
                new Emp("Santosh", 1000000, "Warje"),
                new Emp("Sham", 2000000, "Pune"),
                new Emp("Ram", 1200000, "Mumbai"),
                new Emp("Akash", 1500000, "Nashik"));

        // Given and empList. sort employees based on their salaries in desc order
        System.out.println("----- Given and empList. sort employees based on their salaries in desc order ------");
        empList.stream()
                .sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary()))
                .forEach(emp -> System.out.println(emp));

        // Fetch top 2 salaried employees from the given list
        System.out.println("--------- Fetch top 2 salaried employees from the given list -------");
        empList.stream()
                .sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary()))
                .limit(2)
                .forEach(emp -> System.out.println(emp));

        // Fetch all employees having salary less than 2nd highest salary
        System.out.println("---- Fetch all employees having salary less than 2nd highest salary -------");
        empList.stream()
                .sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary()))
                .skip(2)
                .forEach(emp -> System.out.println(emp));

        // Output
//        ----- Given and empList. sort employees based on their salaries in desc order ------
//        Emp{name='Sham', salary=2000000, address='Pune'}
//        Emp{name='Akash', salary=1500000, address='Nashik'}
//        Emp{name='Ram', salary=1200000, address='Mumbai'}
//        Emp{name='Santosh', salary=1000000, address='Warje'}
//        --------- Fetch top 2 salaried employees from the given list -------
//                Emp{name='Sham', salary=2000000, address='Pune'}
//        Emp{name='Akash', salary=1500000, address='Nashik'}
//        ---- Fetch all employees having salary less than 3rd highest salary -------
//                Emp{name='Ram', salary=1200000, address='Mumbai'}
//        Emp{name='Santosh', salary=1000000, address='Warje'}
    }
}
