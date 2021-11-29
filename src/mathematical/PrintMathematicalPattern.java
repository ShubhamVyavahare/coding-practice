package mathematical;

/**
 * Output:
 * 333222111
 * 332211
 * 321
 */
public class PrintMathematicalPattern {
    public void printPattern(int size) {
        for (int i = size; i >= 1; i--) {
            for (int j = size; j >= 1; j--) {
                int counter = i;
                while (counter != 0) {
                    System.out.print(j);
                    counter--;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 3;
        PrintMathematicalPattern printMathematicalPattern = new PrintMathematicalPattern();
        printMathematicalPattern.printPattern(size);
    }
}
