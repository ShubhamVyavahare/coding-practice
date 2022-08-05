package scenariobased.demo20;

import java.util.HashMap;
import java.util.Map;

/**
 * While putting custom object as a key in a hashmap
 * What happen if hashcode and equals are not overriden
 * <p>
 * Output :
 * Map Size : 2
 * Objects equals : false
 * Emp1 hashcode : 1705736037
 * Emp2 hashcode : 455659002
 * <p>
 * Explanation :
 * 1.While putting 1st element it will calculate hashcode on the key and find out index of the bucket
 * 2.Let's say calculated bucket index is 4, then at bucket 4 it will add the node containing key and value
 * 3.While putting 2nd element it will calculate hashcode on the key - now here there are 2 possibilities - either hashcode will be different or it will be same
 * 4.When the hashcode is different then index will be let's say 7, so at 7th bucket it will add the node containing key and value
 * 5.That means at 4th and 7th bucket it has added same element (That's why map size is 2 in the output)
 * 6.When the hashcode is same then again index will be 4, so at 4th bucket 1st element is present, but as we have not overriden equals method it will add new node in the same bucket
 * 7.That means at 4th bucket it has added 2 nodes with the same data
 */
public class Demo20Scenario1 {
    public static void main(String[] args) {

        EmployeeExample1 empObj1 = new EmployeeExample1(1, "shubham");
        EmployeeExample1 empObj2 = new EmployeeExample1(1, "shubham");

        Map<EmployeeExample1, String> map = new HashMap();
        map.put(empObj1, "1");
        map.put(empObj2, "2");

        System.out.println("Map Size : " + map.size());
        System.out.println("Objects equals : " + empObj1.equals(empObj2));
        System.out.println("Emp1 hashcode : " + empObj1.hashCode());
        System.out.println("Emp2 hashcode : " + empObj2.hashCode());
    }
}

class EmployeeExample1 {
    private Integer id;
    private String name;

    public EmployeeExample1(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}