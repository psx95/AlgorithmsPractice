import java.util.Scanner;
import java.util.Stack;

import sun.nio.cs.ext.IBM1124;

public class Solution6 {   
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
        Node.printLinkedList(head);  
        String a  = convertLinkedListToString(head);        
        System.out.println (isPalin(a));
        System.out.println (isPalindrome_Stack(head));
    }

    private static boolean isPalin(String str) {
        int reverseCounter = str.length() -1;
        for (int i = 0; i <= reverseCounter; i++) {
            if (str.charAt(i)!=str.charAt(reverseCounter)) {
                return false;
            }
            reverseCounter--;
        }
        return true;
    }

    private static String convertLinkedListToString (Node head) {
        Node temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append(temp.data);
            temp = temp.next;
        }
        System.out.println (builder.toString());
        return builder.toString();
    }

    private static boolean isPalindrome_Stack (Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow);
            slow = slow.next;            
        }

        if (fast != null) {
            // odd number of nodes
            slow = slow.next;
        }
        while (slow!=null) {
            if (!stack.isEmpty()) {
                if (stack.pop().data != slow.data) {
                    return false;
                }
            }
            slow = slow.next;         
        }
        return true;
    }
}