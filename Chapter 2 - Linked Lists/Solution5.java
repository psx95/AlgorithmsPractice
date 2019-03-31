import java.util.Scanner;

public class Solution5 {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("enter the length of first number, followed by number in reverse order");
        int number  = sc.nextInt();
        Node head = null, _head = null;
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
        temp  = null;
        System.out.println ("Enter the length of the second number, followed by number in reverse order");
        int _number = sc.nextInt();
        for (int i = 0; i< _number; i++) {
            Node node = new Node();
            node.data = sc.nextInt();
            if (_head == null) {
                _head = node;
                temp = _head;
            } else {
                temp.next = node;
                temp = temp.next;        
            }
        }
        sc.close();
        Node.printLinkedList(head);
        Node.printLinkedList(_head);                
        //int num1 = formNumberFromLinkedList(head);
        //int num2 = formNumberFromLinkedList(_head);
        //Node.printLinkedList(formLinkedListFromNumber(num1+num2));

        // forward order 
        int num1 = getNumberFromList_forward(head);
        int num2 = getNumberFromList_forward(_head);
        Node.printLinkedList(getListFromNumber_forward(num1+num2));
    }

    private static Node formLinkedListFromNumber (int number) {
        Node head = null; 
        Node temp = null;
        while (number!=0) {
            int dig = number%10;
            if (head == null) {
                head = new Node();
                head.data = dig;
                head.next = null;
                temp = head;
            } else {
                temp.next = new Node();
                temp.next.data = dig;
                temp.next.next = null;
                temp = temp.next;
            }
            number/=10;
        }
        return head;
    }

    private static int formNumberFromLinkedList (Node head) {
        int counter = 0, sum = 0;
        Node temp = head;
        while (temp!=null) {
            sum+=temp.data * Math.pow(10.0d, counter++);            
            temp = temp.next;
        }
        return sum;
    }

    // Follow UP - Numbers and list in forward order instead of reverse  
    private static Node getListFromNumber_forward (int number) {
        int num_dig = 0;
        int t = number;
        while (t!=0) {
            t/=10;
            num_dig++;        
        }
        Node head = null, temp = null;
        while (num_dig > 0) {
            int dig = (int)(number/(Math.pow(10, num_dig-1)));
            number = (int) (number%Math.pow(10, num_dig-1));
            num_dig--;
            if (head == null) {
                head = new Node();
                head.data = dig;
                head.next = null;
                temp = head;
            } else {
                temp.next = new Node();
                temp.next.data = dig;
                temp.next.next = null;
                temp = temp.next;
            }
        }
        return head;
    }

    private static int getNumberFromList_forward (Node head) {
        int sum = 0; 
        Node temp = head;
        while (temp !=null) {
            sum *= 10;
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }
}