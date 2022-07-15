package multithreading;

public class SleepMethodDemo2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            System.out.println("Calling sleep method");
            Thread.sleep(400);
        }
    }
}
