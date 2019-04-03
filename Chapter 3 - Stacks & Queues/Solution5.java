import java.util.Scanner;
import java.util.Stack;
import java.util.Stack;

public class Solution5 {
    private static Stack<Integer> sortedStack = new Stack<>();
    private static Stack<Integer> tempStack = new Stack<>();
    public static void main (String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter the number of items");
        int items = sc.nextInt();
        Stack<Integer> inputStack = new Stack<>();
        for (int i = 0; i < items; i++) {
            inputStack.push(sc.nextInt());
        }            
        System.out.println (inputStack);
        sc.close();        
        popAll(sortStack(inputStack));
    }

    public static Stack<Integer> sortStack (Stack<Integer> inputStack) {
        while (!inputStack.isEmpty()) {
            if (sortedStack.isEmpty()) {
                sortedStack.push(inputStack.pop());
            } else {
                if (inputStack.peek() <= sortedStack.peek()) {
                    sortedStack.push(inputStack.pop());
                } else {
                    while (!sortedStack.isEmpty() && (sortedStack.peek() < inputStack.peek())) {
                        System.out.println ("Push to temp stack");
                        tempStack.push(sortedStack.pop());
                    }
                    sortedStack.push(inputStack.pop());
                    while (!tempStack.isEmpty()) {
                        sortedStack.push(tempStack.pop());
                    }
                }
            }
        }
        System.out.println ("Sorted stack "+sortedStack);
        return sortedStack;
    }

    public static void popAll (Stack<Integer> inpStack) {        
        int temp;
        do {                   
            temp = inpStack.pop();             
            System.out.print (temp +",");             
        }
        while (!inpStack.isEmpty());
    }
}