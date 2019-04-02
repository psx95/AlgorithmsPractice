import java.util.Scanner;
import java.util.Stack;
import java.util.Stack;

public class Solution3 {
    public static void main (String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter the threshold");
        int threshold = sc.nextInt();
        System.out.println ("Enter the number of plates");
        int numberOfPlates = sc.nextInt();
        StackOfPlates<Integer> stackOfPlates = new StackOfPlates<Integer>(threshold);
        for (int i = 0; i< numberOfPlates; i++) {
            stackOfPlates.push(sc.nextInt());
        }
        stackOfPlates.popAll();
    }

    static class StackOfPlates<T> {
        private int threshold = 10;
        private Stack<Stack<T>> internalStack;
        private Stack<T> stackAtTop;
        private int count = 0;

        public StackOfPlates (int threshold) {
            this.threshold = threshold;
        }

        public void push(T data) {
            if (stackAtTop == null) {
                stackAtTop = new Stack<T>();
                stackAtTop.push(data);
                count++;
            } else {
                if (count % threshold != 0) {
                    stackAtTop.push(data);
                    count++;
                } else {
                    if (internalStack == null){
                        internalStack = new Stack<Stack<T>>();
                    }
                    internalStack.push(stackAtTop);
                    stackAtTop = new Stack<T>();
                    stackAtTop.push(data);
                    count++;
                }
            }
        }

        public T pop () {
            if (stackAtTop == null) {
                return null;
            } else {
                if (!stackAtTop.isEmpty()) {
                    return stackAtTop.pop();
                } else {
                    System.out.println ("End of stack");
                    if (internalStack!=null && !internalStack.isEmpty()) {
                        stackAtTop = internalStack.pop();
                        return stackAtTop.pop();
                    } else {
                        return null;
                    }
                }
            }
        }

        public void popAll () {
            T temp;
            do {                   
                temp = pop();             
                System.out.print (temp +",");             
            }
            while (temp != null);
        }
    }
}