import java.util.*;
public class MergeSortedList
{
    public static void main (String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter number of elements in list 1");
        int n1 = sc.nextInt();
        ListNode root1 = null, root2 = null;
        ListNode temp = null;
        for (int i = 0; i < n1; i++)
        {
            int n = sc.nextInt();
            ListNode a = new ListNode(n);
            if (root1 == null)
            {
                root1 = a;
                temp = root1;
            }
            else
            {
                temp.next = a;
                temp = temp.next;
            }
        }

        System.out.println ("Enter number of elements in list 2");
        int n2 = sc.nextInt();
        temp = null;
        for (int i = 0; i < n2; i++)
        {
            int n = sc.nextInt();
            ListNode a = new ListNode(n);
            if (root2 == null)
            {
                root2 = a;
                temp = root2;
            }
            else
            {
                temp.next = a;
                temp = temp.next;
            }
        }
        ListNode ans = mergeTwoLists(root1, root2);
        printList(ans);
    }

    private static void printList (ListNode root) {
    	while (root!=null) {
    		System.out.print(root.val + " -> ");
    		root = root.next;
    	}
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode root = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = null;
        while (temp1 != null || temp2 != null)
        {
            if (temp1 != null && temp2 != null)
            {
                if (temp1.val < temp2.val)
                {
                    if (root == null)
                    {
                        root = new ListNode(temp1.val);
                        temp = root;
                    }
                    else
                    {
                        ListNode n = new ListNode(temp1.val);
                        temp.next = n;
                        temp = temp.next;
                    }
                    temp1 = temp1.next;
                }
                else
                {
                    if (root == null)
                    {
                        root = new ListNode(temp2.val);
                        temp = root;
                    }
                    else
                    {
                        ListNode n = new ListNode(temp2.val);
                        temp.next = n;
                        temp = temp.next;
                    }
                    temp2 = temp2.next;
                }
            }
            else if (temp1 == null)
            {                
                if (root == null) {
                	root = new ListNode(temp2.val);;
                	temp = root;
                } else {
                	ListNode n = new ListNode(temp2.val);
                	temp.next = n;
                	temp = temp.next;
                }                                
                temp2 = temp2.next;
            }
            else
            {                
                if (root == null) {                	
                	root = new ListNode(temp1.val);
                	temp = root;                
                } else {                	
                	ListNode n = new ListNode(temp1.val);
                	temp.next = n;
                	temp = temp.next;
                }                                                
                temp1 = temp1.next;
            }
        }
        return root;
    }

    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }
}