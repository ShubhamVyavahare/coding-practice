package scenariobased.demo17;

/**
 * If two interface containing default methods, how to call that method
 */
public class Demo17 implements Inter1, Inter2 {

    public static void main(String[] args) {
        Demo17 demo17 = new Demo17();
        demo17.print();
    }

    @Override
    public void print() {
        Inter1.super.print();
    }
}
