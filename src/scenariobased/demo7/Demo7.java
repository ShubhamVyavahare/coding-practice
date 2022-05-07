package scenariobased.demo7;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find out duplicate names in given list
 * Find out unique names in a list
 * Find out elements and how many times it is repeated
 */
public class Demo7 {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Shubham", "Vaibhav", "Ashish", "Yash", "Ram", "Ram", "Shubham");
        Set<String> uniqueNameSet = new HashSet<>();

        String duplicateNames = nameList.stream()
                .filter(name -> !uniqueNameSet.add(name))
                .collect(Collectors.joining(", "));
        System.out.println("Duplicate names in a list : " + duplicateNames);
        // Output : Duplicate names in a list : Ram, Shubham
        System.out.println("Unique names in a list : " + uniqueNameSet);
        // Output : Unique names in a list : [Yash, Ashish, Vaibhav, Shubham, Ram]

        nameList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((name, count) -> System.out.println("Name : " + name + " --> Count : " + count));
        // Output :
//        Name : Yash --> Count : 1
//        Name : Ashish --> Count : 1
//        Name : Vaibhav --> Count : 1
//        Name : Shubham --> Count : 2
//        Name : Ram --> Count : 2

        Set<String> collect = nameList.stream()
                .filter(name -> Collections.frequency(nameList, name) > 1)
                .collect(Collectors.toSet());
        System.out.println("Finding duplicate in a list using Collections.frequency : " + collect);
        // Output :
//        Finding duplicate in a list using Collections.frequency : [Shubham, Ram]
    }
}
