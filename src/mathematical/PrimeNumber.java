package mathematical;

import java.util.Arrays;

/**
 * Output :
 * Method 1 :
 * 1 is NOT a prime number
 * 2 is a prime number
 * 3 is a prime number
 * 4 is NOT a prime number
 * 5 is a prime number
 * 6 is NOT a prime number
 *
 * Method 2 :
 * 1 is not a prime number
 * 2 is a prime number
 * 3 is a prime number
 * 4 is not a prime number
 * 5 is a prime number
 * 6 is not a prime number
 */
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("Method 1 : ");
        PrimeNumber.method1(1);
        PrimeNumber.method1(2);
        PrimeNumber.method1(3);
        PrimeNumber.method1(4);
        PrimeNumber.method1(5);
        PrimeNumber.method1(6);

        System.out.println("\nMethod 2 : ");
        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(n -> {
            if (PrimeNumber.method2(n)) {
                System.out.println(n + " is a prime number");
            } else {
                System.out.println(n + " is not a prime number");
            }
        });
    }

    public static void method1(int n) {
        int m = 0, flag = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            System.out.println(n + " is NOT a prime number");
        } else {
            for (int i = 2; i <= m; i++) {
                if (n % 2 == 0) {
                    System.out.println(n + " is NOT a prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                System.out.println(n + " is a prime number");
        }
    }

    public static boolean method2(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
