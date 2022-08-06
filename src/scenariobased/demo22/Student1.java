package scenariobased.demo22;

import java.io.Serial;
import java.io.Serializable;

public class Student1 implements Serializable {
    @Serial
    private static final long serialVersionUID = 6854419194683009237L;
    private transient int id;
    private String name;

    public Student1() {
    }

    public Student1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
