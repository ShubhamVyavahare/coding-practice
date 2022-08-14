package scenariobased.demo24;

/**
 * Find out min and max from the given array
 */
public class Demo24 {
    public static void main(String[] args) {

        int[] intArr = {9, 3, 2, 8, 11, 10, 1};

        int min = intArr[0];
        int max = intArr[0];

        for (int i = 1; i < intArr.length; i++) {

            if (intArr[i] < min)
                min = intArr[i];

            if (intArr[i] > max)
                max = intArr[i];
        }

        System.out.println("Min is : " + min + "\nMax is : " + max);
    }
}
