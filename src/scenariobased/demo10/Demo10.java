package scenariobased.demo10;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Flatmap working
 *
 * <p>
 * Output:
 * Before Flatmap : [[5, 7, 11, 13], [1, 3, 5], [2, 4, 6, 8]]
 * After Flatmap : [5, 7, 11, 13, 1, 3, 5, 2, 4, 6, 8]
 * ------------------------------------
 * AllIntegers List<List<Integer>> before using flatmap : [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Find out even elements from List<List<Integer>> in a single list : [2, 4, 6, 8]
 */
public class Demo10 {
    public static void main(String[] args) {

        List<Integer> primeNumbers = Arrays.asList(5, 7, 11, 13);
        List<Integer> oddNumbers = Arrays.asList(1, 3, 5);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> beforeFlatMap = Arrays.asList(primeNumbers, oddNumbers, evenNumbers);

        System.out.println("Before Flatmap : " + beforeFlatMap);

        List<Integer> afterFlatMap = beforeFlatMap.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println("After Flatmap : " + afterFlatMap);

        System.out.println("------------------------------------");

        List<Integer> integer1 = Arrays.asList(1, 2, 3);
        List<Integer> integer2 = Arrays.asList(4, 5, 6);
        List<Integer> integer3 = Arrays.asList(7, 8, 9);
        List<List<Integer>> allIntegers = Arrays.asList(integer1, integer2, integer3);

        System.out.println("AllIntegers List<List<Integer>> before using flatmap : " + allIntegers);

        List<Integer> outputList = allIntegers.stream()
                .flatMap(integers -> integers.stream().filter(integer -> integer % 2 == 0))
                .toList();

        System.out.println("Find out even elements from List<List<Integer>> in a single list : " + outputList);

    }
}
