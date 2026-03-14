package lr9.task_5;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
