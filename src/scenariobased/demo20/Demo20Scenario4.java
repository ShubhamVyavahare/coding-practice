package scenariobased.demo20;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * While putting custom object as a key in a hashmap
 * What happen if we override both equals and hashcode methods
 * <p>
 * Output :
 * Map Size : 1
 * Objects equals : true
 * Emp1 hashcode : 2072215442
 * Emp2 hashcode : 2072215442
 * Key : EmployeeExample4{id=1, name='shubham'} Value : new node
 * <p>
 * Explanation :
 * 1.While putting 1st element it will calculate hashcode on the key and find out index of the bucket
 * 2.Let's say calculated bucket index is 4, then at bucket 4 it will add the node containing key and value
 * 3.While putting 2nd element it will calculate hashcode on the key, now, as we have overridden the hashcode method, the hashcode of 2nd object is also same
 * 5.As the hashcode is same, index is also same, i.e., 4
 * 6.As at 4th index there is already 1 node present, but as we have overridden equals method the object which will return objects are equal
 * 7.As it returns objects equal then the old node is getting replaced with the new node
 * 8.That means at 4th index we have only 1 node with data ({id=1, name='shubham'}, "new node"), hence the size of map is 1
 */
public class Demo20Scenario4 {
    public static void main(String[] args) {

        EmployeeExample4 empObj1 = new EmployeeExample4(1, "shubham");
        EmployeeExample4 empObj2 = new EmployeeExample4(1, "shubham");

        Map<EmployeeExample4, String> map = new HashMap<>();
        map.put(empObj1, "old node");
        map.put(empObj2, "new node");

        System.out.println("Map Size : " + map.size());
        System.out.println("Objects equals : " + empObj1.equals(empObj2));
        System.out.println("Emp1 hashcode : " + empObj1.hashCode());
        System.out.println("Emp2 hashcode : " + empObj2.hashCode());
        map.forEach((employeeExample4, s) -> System.out.println("Key : " + employeeExample4 + " Value : " + s));
    }
}

class EmployeeExample4 {
    private Integer id;
    private String name;

    public EmployeeExample4(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeExample4 that = (EmployeeExample4) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "EmployeeExample4{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}