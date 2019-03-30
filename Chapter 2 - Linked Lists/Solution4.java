import java.util.Scanner;

public class Solution4 {
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
        System.out.println ("Enter the Partition value");
        int value = sc.nextInt();
        sc.close();
        Node.printLinkedList(partitionList(head, value));
    }

    private static Node partitionList(Node head, int value) {
        Node highListHead = null, highListEnd = null;
        Node lowListHead = null, lowListEnd = null;
        Node temp = head;        
        while (temp!=null) {
            if (temp.data >= value) {
                if (highListHead == null) {
                    highListHead = temp;                
                    highListEnd = highListHead;
                } else {
                    highListEnd.next = temp;
                    highListEnd = temp;
                }
            } else {
                if (lowListHead == null) {
                    lowListHead = temp;
                    lowListEnd = lowListHead;
                } else {
                    lowListEnd.next = temp;
                    lowListEnd = temp;
                }
            }
            temp = temp.next;
        }
        if (lowListHead == null) {
            return highListHead;
        } 
        lowListEnd.next = highListHead;
        return lowListHead;
    }
}