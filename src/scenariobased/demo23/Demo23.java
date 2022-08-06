package scenariobased.demo23;

/**
 * Find three largest numbers from the given list
 */
public class Demo23 {
    public static void main(String[] args) {

        int arr[] = {12, 13, 1, 10, 34, 1};

        if (arr.length < 3) {
            System.out.println("Invalid Input !!!");
        } else {
            int first, second, third;
            first = second = third = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > first) {
                    third = second;
                    second = first;
                    first = arr[i];
                } else if (arr[i] > second) {
                    third = second;
                    second = arr[i];
                } else if (arr[i] > third) {
                    third = arr[i];
                }
            }

            System.out.println("First Largest : " + first);
            System.out.println("Second Largest : " + second);
            System.out.println("Third Largest : " + third);
        }
    }
}
