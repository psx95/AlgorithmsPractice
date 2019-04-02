import java.util.*;

public class Solution2 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter the number of items");
        int items = sc.nextInt();
        StackMin<Integer> stackMin = new StackMin<Integer>();
        for (int i = 0; i < items; i++) {
            stackMin.push(sc.nextInt());
        }
        stackMin.popAll();
    }

    static class StackMin<T extends Comparable<T>> {
        private StackNode<T> top;
        
        private class StackNode<T> {
            private T data;
            private T data_min;
            private StackNode<T> next;

            protected StackNode (T data) {
                this.data = data;
                this.next = null;
            }
        }

        public void push (T data) {
            StackNode<T> s = new StackNode<T>(data);
            if (top == null) {             
                top = s;
                top.data_min = data;
            } else {
                s.next = top;
                int compare = top.data_min.compareTo(s.data);
                s.data_min = compare < 0 ? top.data_min : s.data;
                top = s;                            
            }
        }

        public T pop() {
            if (top == null) {
                return null;
            } else {
                StackNode<T> node = top;
                top = top.next;
                return node.data;
            }
        }

        public T min () {
            if (top == null) {
                return null;
            } else {
                return top.data_min;
            }
        }

        public void popAll () {
            T temp;
            do {                   
                temp = pop();             
                System.out.println ("Popped "+temp + ", New min data "+(top!=null?top.data_min:"null"));             
            }
            while (temp != null);
        }
    }
}