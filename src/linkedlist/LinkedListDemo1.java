package linkedlist;

/**
 * Create a Java Program to find the middle node of the linked list in java in one pass
 * <p>
 * Output :
 * 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * Middle Node : 3
 * 1 -> 2 -> 3 -> 4 -> NULL
 * Middle Node : 3
 */
public class LinkedListDemo1 {

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
        LinkedListDemo1 linkedListDemo1 = new LinkedListDemo1();
        linkedListDemo1.addNode(1);
        linkedListDemo1.addNode(2);
        linkedListDemo1.addNode(3);
        linkedListDemo1.addNode(4);
        linkedListDemo1.addNode(5);

        linkedListDemo1.printMe();

        linkedListDemo1.findMiddleNode();

        LinkedListDemo1 linkedListDemo2 = new LinkedListDemo1();
        linkedListDemo2.addNode(1);
        linkedListDemo2.addNode(2);
        linkedListDemo2.addNode(3);
        linkedListDemo2.addNode(4);

        linkedListDemo2.printMe();

        linkedListDemo2.findMiddleNode();
    }

    private void findMiddleNode() {

        Node fastPointer = head;
        Node slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        System.out.println("Middle Node : " + slowPointer.data);
    }
}
