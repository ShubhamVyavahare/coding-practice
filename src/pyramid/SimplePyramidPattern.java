package pyramid;

/**
 * Output
 * *
 * * *
 * * * *
 * * * * *
 * * * * * *
 */
public class SimplePyramidPattern {
    public void printPattern(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 5;
        SimplePyramidPattern simplePyramidPattern = new SimplePyramidPattern();
        simplePyramidPattern.printPattern(size);
    }
}
