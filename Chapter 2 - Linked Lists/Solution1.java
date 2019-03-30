import java.util.Scanner;

public class Solution1 {
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
        sc.close();
        printLinkedList(head);
        removeDuplicates(head);
        printLinkedList(head);
    }

    private static void removeDuplicates (Node head) {
        Node temp = head;
        while (temp!=null) {
            isDuplicate(temp);
            temp = temp.next;
        }
    }

    private static void isDuplicate(Node nodeToCheck) {
        if (nodeToCheck.next == null) {
            return;
        }
        Node temp_next = nodeToCheck.next;
        Node temp = nodeToCheck;  
        boolean updated = false;      
        while (temp_next!=null) {
            if (temp_next.data != nodeToCheck.data) {
                temp.next = temp_next;
                temp = temp_next; 
                updated = true;    
            }
            temp_next = temp_next.next;
        }
        if (!updated){
            // all nodes are same
            nodeToCheck.next = null;
        }        
    }

    private static void printLinkedList(Node head) {
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