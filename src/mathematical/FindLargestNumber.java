package mathematical;

import java.util.Arrays;
import java.util.List;

/**
 * Output:
 * Max number is : 22
 */
public class FindLargestNumber {
    public void findLargestNumber(int a, int b, int c) {
        List<Integer> integerList = Arrays.asList(a, b, c);
        System.out.println("Max number is : " + integerList.stream().distinct().max((o1, o2) -> o1 - o2).get());
    }

    public static void main(String[] args) {
        FindLargestNumber findLargestNumber = new FindLargestNumber();
        findLargestNumber.findLargestNumber(12, 22, 11);
    }
}
