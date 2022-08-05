package scenariobased.demo20;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * While putting custom object as a key in a hashmap
 * What happen if we only override equals but not hashcode
 * <p>
 * Output :
 * Map Size : 2
 * Objects equals : true
 * Emp1 hashcode : 1705736037
 * Emp2 hashcode : 455659002
 * <p>
 * Explanation :
 * 1.While putting 1st element it will calculate hashcode on the key and find out index of the bucket
 * 2.Let's say calculated bucket index is 4, then at bucket 4 it will add the node containing key and value
 * 3.While putting 2nd element it will calculate hashcode on the key - now here there are 2 possibilities - either hashcode will be different or it will be same
 * 4.When the hashcode is different then index will be, let's say 7, so at 7th bucket it will add the node containing key and value
 * 5.That means at 4th and 7th bucket it has added same element (That's why map size is 2 in the output)
 * 6.When by any chance the hashcode is same then again index will be 4, so at 4th bucket 1st element is present, but as we have overridden equals method it will check the content of the object, and the content is same hence the new node will replace the older node
 * 7.That means at 4th bucket it has added the latest node with the same data
 */
public class Demo20Scenario2 {
    public static void main(String[] args) {

        EmployeeExample2 empObj1 = new EmployeeExample2(1, "shubham");
        EmployeeExample2 empObj2 = new EmployeeExample2(1, "shubham");

        Map<EmployeeExample2, String> map = new HashMap<>();
        map.put(empObj1, "1");
        map.put(empObj2, "1");

        System.out.println("Map Size : " + map.size());
        System.out.println("Objects equals : " + empObj1.equals(empObj2));
        System.out.println("Emp1 hashcode : " + empObj1.hashCode());
        System.out.println("Emp2 hashcode : " + empObj2.hashCode());
    }
}

class EmployeeExample2 {
    private Integer id;
    private String name;

    public EmployeeExample2(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeExample2 employee2 = (EmployeeExample2) o;
        return Objects.equals(id, employee2.id) && Objects.equals(name, employee2.name);
    }
}