public class PairSwap {
  public ListNode swapPairs(ListNode head) {
    ListNode iterator = head;
    ListNode pairEnd = null;
    ListNode newHead = null;
    ListNode previousNode = head;
    while (iterator.next != null) {
      ListNode nextNode = iterator.next;
      ListNode currentNode = iterator;
      
    }
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