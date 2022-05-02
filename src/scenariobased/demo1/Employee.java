package scenariobased.demo1;

public class Employee {

    private Integer empId;
    private Integer salary;
    private Integer deptId;
    private String status;

    public Employee(Integer empId, Integer salary, Integer deptId, String status) {
        this.empId = empId;
        this.salary = salary;
        this.deptId = deptId;
        this.status = status;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", salary=" + salary +
                ", deptId=" + deptId +
                ", status='" + status + '\'' +
                '}';
    }
}
