package mathematical;

/**
 * Factorial
 * 4! = 4*3*2*1 = 24
 * 6! = 6*5*4*3*2*1 = 720
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(Factorial.factorial1(4));
        System.out.println(Factorial.factorial1(6));
    }

    public static int factorial1(int n) {
        if (n == 0)
            return 1;
        return n * factorial1(n - 1);
    }
}
