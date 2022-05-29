package scenariobased.demo2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Output:
 * All Even Num : [2, 4, 6, 8, 10]
 * Numbers starts with One : [1, 10]
 * Duplicate elements vs it's count : {1=3, 2=2, 5=3}
 * Element in a list vs their count (Solution 1) : {1=3, 2=2, 4=1, 5=3, 10=1}
 * Element in a list vs their count (Solution 2) : {1=3, 2=2, 4=1, 5=3, 10=1}
 * Sorted List : [1, 2, 4, 5, 7, 9]
 * Sorted in reverse order : [9, 7, 5, 4, 2, 1]
 */
public class Demo2 {

    public static void main(String[] args) {

        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        Given a list of integers, find out all the even numbers exist in the list using Stream functions
        List<Integer> evenNums = integerList1.stream()
                .filter(integer -> integer % 2 == 0).toList();
        System.out.println("All Even Num : " + evenNums);

//        Given a list of integers, find out all the numbers starting with 1 using Stream functions
        List<Integer> numStartWithOne = integerList1.stream()
                .filter(integer -> integer.toString().startsWith("1")).toList();
        System.out.println("Numbers starts with One : " + numStartWithOne);

//        How to find duplicate elements in a given integers list in java using Stream functions
        List<Integer> integerList2 = Arrays.asList(1, 2, 1, 4, 5, 1, 5, 2, 5, 10);
        Map<Integer, Long> duplicateElementsMap = new HashMap<>();
        integerList2.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((num, count) -> {
                    if (count > 1)
                        duplicateElementsMap.put(num, count);
                });
        System.out.println("Duplicate elements vs it's count : " + duplicateElementsMap);

//        Find out List elements and their count in list
        //solution 1
        Map<Integer, Integer> numAndCountMap = new HashMap<>();
        integerList2.forEach(integer -> {
            if (!numAndCountMap.containsKey(integer)) {
                numAndCountMap.put(integer, 1);
            } else {
                Integer count = numAndCountMap.get(integer);
                count += 1;
                numAndCountMap.replace(integer, count);
            }
        });
        System.out.println("Element in a list vs their count (Solution 1) : " + numAndCountMap);

        // solution 2
        Map<Integer, Long> elementVsCountMap = integerList2.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Element in a list vs their count (Solution 2) : " + elementVsCountMap);

//        Given a list of integers, sort all the values present in it using Stream functions
        List<Integer> integerList3 = Arrays.asList(5, 2, 1, 7, 4, 9);
        List<Integer> sortedList = integerList3.stream().sorted().toList();
        System.out.println("Sorted List : " + sortedList);

//        Given a list of integers, sort all the values present in it in descending order using Stream functions
        List<Integer> reveseOrderList = integerList3.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted in reverse order : " + reveseOrderList);
    }
}
