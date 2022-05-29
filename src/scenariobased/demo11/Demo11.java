package scenariobased.demo11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Sort an employee based on pincode in descending order
 * <p>
 * Output:
 * Sorted Employee Objects Based On Pincode :
 * [Employee{name='Shubham', empId=1, empAddress=Address{addressLine1='Warje', addressLine2='Pune', pincode=155}},
 * Employee{name='Pranav', empId=5, empAddress=Address{addressLine1='Thane', addressLine2='Mumbai', pincode=123}},
 * Employee{name='Ashish', empId=2, empAddress=Address{addressLine1='Nasihik Rd', addressLine2='Nashik', pincode=111}},
 * Employee{name='Pratik', empId=3, empAddress=Address{addressLine1='Akole', addressLine2='Nagar', pincode=98}}]
 * <p>
 * Sort an employee based on empId which is int primitive datatype
 * <p>
 * Output:
 * Sorted Employee Objects Based On EmpId (primitive datatype) :
 * [Employee{name='Shubham', empId=1, empAddress=Address{addressLine1='Warje', addressLine2='Pune', pincode=155}},
 * Employee{name='Ashish', empId=2, empAddress=Address{addressLine1='Nasihik Rd', addressLine2='Nashik', pincode=111}},
 * Employee{name='Pratik', empId=3, empAddress=Address{addressLine1='Akole', addressLine2='Nagar', pincode=98}},
 * Employee{name='Pranav', empId=5, empAddress=Address{addressLine1='Thane', addressLine2='Mumbai', pincode=123}}]
 */
public class Demo11 {
    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee("Shubham", 1, new Address("Warje", "Pune", 155)),
                new Employee("Pratik", 3, new Address("Akole", "Nagar", 98)),
                new Employee("Ashish", 2, new Address("Nasihik Rd", "Nashik", 111)),
                new Employee("Pranav", 5, new Address("Thane", "Mumbai", 123))
        );

        List<Employee> sortedEmpListOnPincode = employeeList.stream()
                .sorted((o1, o2) -> o2.getEmpAddress().getPincode().compareTo(o1.getEmpAddress().getPincode()))
                .toList();

        System.out.println("Sorted Employee Objects Based On Pincode : " + sortedEmpListOnPincode);

        List<Employee> sortedEmpListOnEmpId = employeeList.stream()
//                .sorted((o1, o2) -> o1.getEmpId() - o2.getEmpId()) --> this is same as below statement
                .sorted(Comparator.comparingInt(Employee::getEmpId))
                .toList();
        System.out.println("Sorted Employee Objects Based On EmpId (primitive datatype) : " + sortedEmpListOnEmpId);
    }
}
