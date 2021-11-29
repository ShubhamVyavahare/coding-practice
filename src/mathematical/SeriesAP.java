package mathematical;

public class SeriesAP {
    public void printNthTermOfAP(int a1, int a2, int n) {
        int nthTerm = 0;
        for (int i = a1; i < a1 + n; i++) {
            nthTerm = i;
        }
        System.out.println(nthTerm);
    }

    public static void main(String[] args) {
        SeriesAP seriesAP = new SeriesAP();
        seriesAP.printNthTermOfAP(1, 2, 10);
        seriesAP.printNthTermOfAP(2, 3, 5);
    }
}
