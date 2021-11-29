package mathematical;

/**
 * Input: n = 3
 * Output:
 * 3 6 9 12 15 18 21 24 27 30
 */
public class MultiplicationTable {
    public void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(n * i + " ");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        multiplicationTable.printTable(n);
    }
}
