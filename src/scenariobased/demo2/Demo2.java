package scenariobased.demo2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Output:
 * All Even Num : [2, 4, 6, 8, 10]
 * Numbers starts with One : [1, 10]
 * Duplicate in List : [1, 1, 5, 2, 5]
 * List contains numbers and their count : {1=3, 2=2, 4=1, 5=3, 10=1}
 * Sorted List : [1, 2, 4, 5, 7, 9]
 * Sorted in reverse order : [9, 7, 5, 4, 2, 1]
 */
public class Demo2 {

    public static void main(String[] args) {

        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        Given a list of integers, find out all the even numbers exist in the list using Stream functions
        List<Integer> evenNums = integerList1.stream()
                .filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        System.out.println("All Even Num : " + evenNums);

//        Given a list of integers, find out all the numbers starting with 1 using Stream functions
        List<Integer> numStartWithOne = integerList1.stream()
                .filter(integer -> integer.toString().startsWith("1")).collect(Collectors.toList());
        System.out.println("Numbers starts with One : " + numStartWithOne);

//        How to find duplicate elements in a given integers list in java using Stream functions
        List<Integer> integerList2 = Arrays.asList(1, 2, 1, 4, 5, 1, 5, 2, 5, 10);
        Set<Integer> integerSet = new HashSet<>();
        List<Integer> duplicateInList = integerList2.stream()
                .filter(integer -> !integerSet.add(integer))
                .collect(Collectors.toList());
        System.out.println("Duplicate in List : " + duplicateInList);

//        Find out List elements and their count in list
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
        System.out.println("List contains numbers and their count : " + numAndCountMap);

//        Given a list of integers, sort all the values present in it using Stream functions
        List<Integer> integerList3 = Arrays.asList(5, 2, 1, 7, 4, 9);
        List<Integer> sortedList = integerList3.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List : " + sortedList);

//        Given a list of integers, sort all the values present in it in descending order using Stream functions
        List<Integer> reveseOrderList = integerList3.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted in reverse order : " + reveseOrderList);
    }
}
