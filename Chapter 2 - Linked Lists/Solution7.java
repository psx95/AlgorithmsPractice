import java.util.Scanner;
import java.util.HashMap;

public class Solution7  {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("enter the number of nodes in first list");
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
        System.out.println ("Enter position of node which you want to be present in other list");    
        int position = sc.nextInt();
        Node nodeToInsert = null;
        int newPosition = -1;
        if (position > -1) {
            nodeToInsert = getNodeAtPosition(head, position);
        } 
        if (nodeToInsert == null) {
            System.out.println ("Node at that position does not exist");        
        } else {
            System.out.println("Enter position at which you want to insert in the node in the new List");
            newPosition = sc.nextInt();            
        }
        System.out.println("Enter number of nodes in the other list");
        int number_2 = nodeToInsert == null? sc.nextInt(): sc.nextInt()+1;
        Node head_2 = null, temp_2 = null;
        for (int i = 0; i<number_2; i++) {            
            if (newPosition > -1 && i == newPosition && head_2!=null) {
                temp_2.next = nodeToInsert;
                break;
            } else {                
                Node node = new Node();
                node.data = sc.nextInt();
                if (head_2 == null) {
                    head_2 = node;
                    temp_2 = head_2;
                } else {
                    temp_2.next = node;
                    temp_2 = temp_2.next;
                }
            }
        }
        sc.close();
        Node.printLinkedList(head);
        Node.printLinkedList(head_2);
        Node intersectingPoint = isIntersecting(head, head_2);
        System.out.println ("hash map approach");
        if (intersectingPoint == null) {
            System.out.println ("No intersecting point found");
        } else {
            Node.printLinkedList(intersectingPoint);
        }
        System.out.println ("Without hash map O(1) space");
        Node intersection = isIntersecting_NO_HASH(head, head_2);
        if (intersection == null) {
            System.out.println ("No intersection found");        
        } else {
            Node.printLinkedList(intersection);
        }                    
    }   

    private static Node isIntersecting (Node headA, Node headB) {
        Node runnerA = headA;
        Node runnerB = headB;
        HashMap<Node, Integer> map = new HashMap<>();
        int counter = 0;
        while (runnerA!=null) {
            map.put(runnerA, counter++);
            runnerA = runnerA.next;
        }
        while (runnerB!=null) {
            if (map.containsKey(runnerB)) {
                return runnerB;
            }
            runnerB = runnerB.next;
        }
        return null;
    }

    private static Node isIntersecting_NO_HASH (Node headA, Node headB) {
        Node runnerA = headA;
        Node runnerB = headB;
        int lengthA = 0, lengthB = 0;
        while (runnerA != null) {
            runnerA = runnerA.next;
            lengthA++;
        }
        while (runnerB != null) {
            runnerB = runnerB.next;
            lengthB++;
        }
        Node longerRunner = lengthA > lengthB ? headA : headB;
        Node smallerRunner = lengthA < lengthB ? headA : headB;
        int differenceCount = Math.abs(lengthA-lengthB);
        while (differenceCount != 0) {
            differenceCount--;
            longerRunner = longerRunner.next;
        }
        while (longerRunner!=null) {
            if (longerRunner == smallerRunner) {
                return longerRunner;
            } else {
                longerRunner = longerRunner.next;
                smallerRunner = smallerRunner.next;            
            }
        }
        return null;
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