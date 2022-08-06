package scenariobased.demo21;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 4424436885220990420L;
    private Integer id;
    private String name;
    private String address;
    private String pincode;

    public Student(Integer id, String name, String address, String pincode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
