package pyramid;

/**
 * Output
 * Pattern 1
 * 5 4 3 2 1
 *  5 4 3 2
 *   5 4 3
 *    5 4
 *     5
 *
 * Pattern 2
 * 1 2 3 4 5
 *  2 3 4 5
 *   3 4 5
 *    4 5
 *     5
 */
public class ReversePyramidPattern {
    public void printPattern1(int size) {
        System.out.println("Pattern 1");
        for (int i = 1; i <= size; i++) {
            for (int j = i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int k = size; k >= i; k--) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public void printPattern2(int size) {
        System.out.println("\nPattern 2");
        for (int i = 1; i <= size; i++) {
            for (int j = i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int k = i; k <= size; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 5;
        ReversePyramidPattern reversePyramidPattern = new ReversePyramidPattern();
        reversePyramidPattern.printPattern1(size);
        reversePyramidPattern.printPattern2(size);
    }
}
