package scenariobased.demo20;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * While putting custom object as a key in a hashmap
 * What happen if we only override hashcode but not equals
 * <p>
 * Output :
 * Map Size : 2
 * Objects equals : false
 * Emp1 hashcode : 2072215442
 * Emp2 hashcode : 2072215442
 * <p>
 * Explanation :
 * 1.While putting 1st element it will calculate hashcode on the key and find out index of the bucket
 * 2.Let's say calculated bucket index is 4, then at bucket 4 it will add the node containing key and value
 * 3.While putting 2nd element it will calculate hashcode on the key, now, as we have overridden the hashcode method, the hashcode of 2nd object is also same
 * 5.As the hashcode is same, index is also same, i.e., 4
 * 6.As at 4th index there is already 1 node present, but as we have not overridden equals method the object class's equals method getting call which will return objects are not equal
 * 7.As it returns objects not equal then new node is getting add in index 4 for 2nd object
 * 8.That means at 4th index we have 2 nodes with same data, hence the size of map is 2
 */
public class Demo20Scenario3 {
    public static void main(String[] args) {

        EmployeeExample3 empObj1 = new EmployeeExample3(1, "shubham");
        EmployeeExample3 empObj2 = new EmployeeExample3(1, "shubham");

        Map<EmployeeExample3, String> map = new HashMap<>();
        map.put(empObj1, "1");
        map.put(empObj2, "1");

        System.out.println("Map Size : " + map.size());
        System.out.println("Objects equals : " + empObj1.equals(empObj2));
        System.out.println("Emp1 hashcode : " + empObj1.hashCode());
        System.out.println("Emp2 hashcode : " + empObj2.hashCode());
    }
}

class EmployeeExample3 {
    private Integer id;
    private String name;

    public EmployeeExample3(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}