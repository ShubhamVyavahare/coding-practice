package linkedlist;

/**
 * Find a LinkedList contains a cycle or not in java
 * <p>
 * Output :
 * Before cyclic loop, linkedList looks like : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
 * Manually Creating a loop in the linkedList
 * LinkedList having a loop at node : 3
 */
public class LinkedListDemo2 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void addNode(int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void printMe() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedListDemo2 linkedListDemo = new LinkedListDemo2();
        linkedListDemo.addNode(1);
        linkedListDemo.addNode(2);
        linkedListDemo.addNode(3);
        linkedListDemo.addNode(4);
        linkedListDemo.addNode(5);
        linkedListDemo.addNode(6);

        System.out.print("Before cyclic loop, linkedList looks like : ");
        linkedListDemo.printMe();

        System.out.println("Manually Creating a loop in the linkedList");
        linkedListDemo.head.next.next.next = linkedListDemo.head.next;

        linkedListDemo.findCycleInLinkedList();
    }

    private void findCycleInLinkedList() {
        Node fastPointer = head;
        Node slowPointer = head;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (slowPointer == fastPointer) {
                System.out.println("LinkedList having a loop at node : " + slowPointer.data);
                break;
            }
        }
    }

}
