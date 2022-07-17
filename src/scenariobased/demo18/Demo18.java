package scenariobased.demo18;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * WAP to print even and odd numbers from 1-10 by two threads
 * <p>
 * Output :
 * ForkJoinPool.commonPool-worker-1 : 1
 * ForkJoinPool.commonPool-worker-2 : 2
 * ForkJoinPool.commonPool-worker-1 : 3
 * ForkJoinPool.commonPool-worker-2 : 4
 * ForkJoinPool.commonPool-worker-1 : 5
 * ForkJoinPool.commonPool-worker-2 : 6
 * ForkJoinPool.commonPool-worker-1 : 7
 * ForkJoinPool.commonPool-worker-2 : 8
 * ForkJoinPool.commonPool-worker-1 : 9
 * ForkJoinPool.commonPool-worker-2 : 10
 */
public class Demo18 {
    private static Object object = new Object();

    private static IntPredicate evenCondition = e -> e % 2 == 0;
    private static IntPredicate oddCondition = e -> e % 2 != 0;

    public static void execute(Integer no) {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printNumber(IntPredicate condition) {
        IntStream.rangeClosed(1, 10).filter(condition).forEach(Demo18::execute);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> Demo18.printNumber(oddCondition));
        CompletableFuture.runAsync(() -> Demo18.printNumber(evenCondition));
        Thread.sleep(1000);
    }
}
