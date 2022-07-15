package multithreading;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}

public class ThreadDemo1 {

    public static void main(String[] args) throws InterruptedException {

        MyThread th = new MyThread();
        th.start();
        th.join();

        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
