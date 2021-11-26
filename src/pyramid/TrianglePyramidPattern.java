package pyramid;


/**
 * Output:
 *     *
 *    * *
 *   * * *
 *  * * * *
 * * * * * *
 */
public class TrianglePyramidPattern {
    public void printPattern(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = size - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 5;
        TrianglePyramidPattern trianglePyramidPattern = new TrianglePyramidPattern();
        trianglePyramidPattern.printPattern(size);
    }
}
