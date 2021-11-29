package mathematical;

public class SeriesGP {
    public void printNthTerm(int a, int r, int n) {
        int nth = a;
        for (int i = 1; i < n; i++) {
            nth = nth * r;
        }
        System.out.print(nth);
    }

    public static void main(String[] args) {
        SeriesGP seriesGP = new SeriesGP();
        seriesGP.printNthTerm(4, 3, 3);
    }
}
