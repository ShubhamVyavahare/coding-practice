package scenariobased.demo3;

import java.util.Objects;

public class Employee {

    private String empName;
    private String empAddress;
    private Integer empAge;
    private String empNumber;

    public Employee(String empName, String empAddress, Integer empAge, String empNumber) {
        this.empName = empName;
        this.empAddress = empAddress;
        this.empAge = empAge;
        this.empNumber = empNumber;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empAge=" + empAge +
                ", empNumber='" + empNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empName, employee.empName) && Objects.equals(empAddress, employee.empAddress) && Objects.equals(empAge, employee.empAge) && Objects.equals(empNumber, employee.empNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empName, empAddress, empAge, empNumber);
    }
}
