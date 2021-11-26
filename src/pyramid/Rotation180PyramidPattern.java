package pyramid;

/**
 * Output
 *         *
 *       * *
 *     * * *
 *   * * * *
 * * * * * *
 */
public class Rotation180PyramidPattern {
    public void printPattern(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = size; j > i; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 5;
        Rotation180PyramidPattern rotation180PyramidPattern = new Rotation180PyramidPattern();
        rotation180PyramidPattern.printPattern(size);
    }
}
