public class Node {
    Node next;
    int data;

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp!=null) {
            System.out.print (temp.data);
            if (temp.next!=null)
            System.out.print("->");
            else System.out.println();
            temp = temp.next;
        }
    }
}