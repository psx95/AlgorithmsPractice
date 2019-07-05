package Leetcode;

public class RemoveDuplicateNodes {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            if (prev == null) {
                prev = head;
            } else {
                if (prev.val == temp.val) {
                    System.out.println ("Same prev -> "+prev.val + " temp ->" +temp.val);
                    while (temp != null && prev.val == temp.val) {
                        temp = temp.next;
                    }
                    prev.next = temp;
                    if (temp != null)
                        System.out.println ("Prev -> "+prev.val +" Prev Next is temp with value-> "+temp.val);
                    prev = temp;
                    if (temp == null)
                        return head;
                } else {
                    prev = temp;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
