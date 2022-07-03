package scenariobased.demo7;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find out elements and how many times it is repeated
 * Find duplicates in a list
 * <p>
 * Output :
 * Name and respective count in a given list : {Yash=1, Ashish=1, Vaibhav=1, Shubham=2, Ram=2}
 * Finding duplicate in a list using Collections.frequency : [Shubham, Ram]
 */
public class Demo7 {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Shubham", "Vaibhav", "Ashish", "Yash", "Ram", "Ram", "Shubham");

        Map<String, Long> nameVsCountMap = nameList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Name and respective count in a given list : " + nameVsCountMap);

        Set<String> collect = nameList.stream()
                .filter(name -> Collections.frequency(nameList, name) > 1)
                .collect(Collectors.toSet());
        System.out.println("Finding duplicate in a list using Collections.frequency : " + collect);
    }
}
