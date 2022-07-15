package multithreading;

/**
 * Implement producer consumer problem in multi-threading
 * <p>
 * output :
 * Produced : 1
 * Consumed value is : 1
 * Produced : 2
 * Consumed value is : 2
 * Produced : 3
 * Consumed value is : 3
 * Produced : 4
 * Consumed value is : 4
 * Produced : 5
 * Consumed value is : 5
 */
class SharedData {
    private int data;
    private boolean writable = true;

    public synchronized void produce(int x) {
        if (writable == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        data = x;
        System.out.println("Produced : " + x);
        writable = false;
        notify();
    }

    public synchronized int consume() {
        if (writable == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        writable = true;
        notify();
        return data;
    }
}

class Producer extends Thread {
    SharedData d;

    public Producer(SharedData d) {
        this.d = d;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            d.produce(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread {
    SharedData d;

    public Consumer(SharedData d) {
        this.d = d;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Consumed value is : " + d.consume());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedData d = new SharedData();
        Producer p = new Producer(d);
        Consumer c = new Consumer(d);

        p.start();
        c.start();
    }
}
