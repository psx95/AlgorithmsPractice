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
        Node.printLinkedList(head);
        Node.printLinkedList(partitionList(head, value));
    }

    private static Node partitionList(Node head, int value) {
        Node highListHead = null;
        Node lowListHead = null;
        Node temp = head;
        Node highList_temp = null;
        Node lowList_temp = null;
        while (temp!=null) {
            if (temp.data > value) {
                if (highListHead == null) {
                    highListHead = new Node();
                    highListHead.data = temp.data;
                    highListHead.next = null;
                    highList_temp = highListHead;
                } else {
                    highList_temp.next = temp;
                    highList_temp.next.next = null;
                    highList_temp = highList_temp.next;
                }
            } else {
                if (lowListHead == null) {
                    lowListHead = new Node();
                    lowListHead.data = temp.data;
                    lowListHead.next = null;
                    lowList_temp = lowListHead;
                } else {
                    lowList_temp.next = temp;
                    lowList_temp.next.next = null;
                    lowList_temp = lowList_temp.next;                
                }
            }
            temp = temp.next;            
        }
        Node.printLinkedList(lowListHead);
        Node.printLinkedList(highListHead);
        lowList_temp.next = highListHead;
        return lowListHead;
    }
}