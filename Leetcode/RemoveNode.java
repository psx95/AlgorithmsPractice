import java.util.Scanner;
public class RemoveNode
{
    public static void main (String Args[])
    {
        Scanner sc = new Scanner (System.in);
        System.out.println ("enter the number of nodes");
        int number  = sc.nextInt();
        ListNode head = null;
        ListNode temp = null;
        for (int i = 0; i < number; i++)
        {
            ListNode node = new ListNode(sc.nextInt());
            if (head == null)
            {
                head = node;
                temp = head;
            }
            else
            {
                temp.next = node;
                temp = temp.next;
            }
        }
        printLinkedList(head);
        System.out.println ("Enter the node position (from end) that you want to remove");
        int num = sc.nextInt();
        printLinkedList(removeNthFromEnd(head, num));
        sc.close();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n)
    {	
        n += 1;
        ListNode temp = head;
        int numberNodes = 0;
        while (temp != null)
        {
            numberNodes++;
            temp = temp.next;
        }
        int stopNodeAt = numberNodes - (n - 1) - 1;
        if (stopNodeAt >= 0)
        {
            int counter = 0;
            temp = head;
            while (counter != stopNodeAt)
            {
                counter++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        else
        {
            if (head != null)
                head = head.next;
        }
        return head;
    }

    private static void printLinkedList(ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print (temp.val);
            if (temp.next != null)
                System.out.print("->");
            else System.out.println();
            temp = temp.next;
        }
    }

    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x)
        {
            val = x;
        }
    }
}