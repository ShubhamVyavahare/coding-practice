package scenariobased.demo11;

public class Employee {

    private String name;
    private int empId;
    private Address empAddress;

    public Employee(String name, int empId, Address empAddress) {
        this.name = name;
        this.empId = empId;
        this.empAddress = empAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Address getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(Address empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", empAddress=" + empAddress +
                '}';
    }
}
