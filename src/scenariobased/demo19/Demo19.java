package scenariobased.demo19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Find out the second-highest number from the given array
 */
public class Demo19 {

    public static void main(String[] args) {

        int[] intArr = new int[]{2, 7, 9, 4, 1, 5, 6, 0, 10};
        method1(intArr);
        method2(intArr);
    }

    private static void method1(int[] intArr) {

        System.out.println("======= In Method 1 =======");

        IntStream stream = Arrays.stream(intArr);
        stream.boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findAny()
                .ifPresent(System.out::println);
    }

    private static void method2(int[] intArr) {

        System.out.println("======= In Method 2 =======");

        boolean flag = true;
        int counter = 0;
        int secondLargestNumber = 0;

        do {
            int i = 0;

            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[i] < intArr[j]) {
                    i = j;
                }
            }

            secondLargestNumber = intArr[i];

            intArr[i] = 0;
            counter++;

            if (counter == 2)
                flag = false;

        } while (flag);

        System.out.println("Second largest number is : " + secondLargestNumber);
    }
}
