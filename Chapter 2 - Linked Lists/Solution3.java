import java.util.Scanner;

public class Solution3{
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("enter the number of nodes");
        int number  = sc.nextInt();
        Node head = null;
        Node temp = null;
        for (int i = 0; i < number; i++) {
            Node node = new Node();
            node.data = sc.nextInt();
            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = temp.next;        
            }
        }
        System.out.println ("Enter position at which you want to delete Node");    
        int position = sc.nextInt();
        Node nodeToDelete = getNodeAtPosition(head, position);
        if (nodeToDelete == null) {
            System.out.println ("Node at that position does not exist");        
        } else {
            nodeToDelete = deleteNode(nodeToDelete);
            Node.printLinkedList(head);
        }
        sc.close();
    }

    private static Node deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            return null;
        } else {
            Node next = nodeToDelete.next;
            nodeToDelete.data = next.data;
            nodeToDelete.next = next.next;
        }
        return nodeToDelete;
    }

    private static Node getNodeAtPosition (Node head, int position) {
        Node temp = head;
        int counter = 0; 
        while (temp!=null) {
            if (position == counter) {
                return temp;
            } else {
                counter++;
                temp = temp.next;
            }
        }
        return null;
    }
}