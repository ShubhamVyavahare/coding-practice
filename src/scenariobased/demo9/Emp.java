package scenariobased.demo9;

import java.util.Objects;

public class Emp {

    private String name;
    private Integer salary;
    private String address;

    public Emp(String name, Integer salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(name, emp.name) && Objects.equals(salary, emp.salary) && Objects.equals(address, emp.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, address);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}
