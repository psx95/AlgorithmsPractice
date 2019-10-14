package Leetcode;

public class SwapPairs {

    public static void main(String[] Args) {

    }

    public ListNode swapPairs(ListNode head) {

        ListNode pairEnd = null;
        ListNode newHead = null;
        ListNode prev = head;
        ListNode temp = head;
        int counter = 0;

        while (head != null) {
            counter++;
            if (counter % 2 == 0) {
                ListNode first = prev;
                ListNode second = head;
                ListNode remainingList = second.next;
                second.next = first;
                first.next = remainingList;
                if (newHead == null)
                    newHead = second;
                if (pairEnd == null) {
                    pairEnd = first;
                } else {
                    pairEnd.next = second;
                    pairEnd = first;
                }
                head = first;
            }
            // update head counter
            prev = head;
            head = head.next;
        }
        if (newHead == null)
            return temp;
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
