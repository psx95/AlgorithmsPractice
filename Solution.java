import java.util.Stack;

public class Solution {
    public static void main (String Args[]) {
        System.out.println (longestValidParentheses(Args[0]));
    }

    public static int longestValidParentheses(String s) {
        int maxCount = 0;
        int currentCount = 0;

        Stack<Character> globalStack = new Stack<>();
        Stack<Character> localStack = new Stack<>();

        char x;
        int startIndex = 0;        
        boolean subtract = false;
        for (int i = 0; i < s.length(); i++) {         
            if (subtract) {
                i-=1;
                subtract = false;
            }                
            x = s.charAt(i);
            System.out.println ("i is "+i + " Char is "+x);
            if (x == '(') {
                globalStack.push(x);
                localStack.push(x);
            } else if (x == ')' && !globalStack.isEmpty() && !localStack.isEmpty()) {
                globalStack.pop();
                localStack.pop();
                currentCount+=2;
                if (globalStack.isEmpty() && localStack.isEmpty()) {
                    if (currentCount > maxCount) {                        
                        maxCount = currentCount;                        
                    }
                }
                if (i == s.length()-1 && !globalStack.isEmpty() && (maxCount < s.length() - 1)) {
                    // last iteration     
                    if (startIndex == 0 && (startIndex+maxCount) < s.length()) {
                        i = startIndex + maxCount;
                        startIndex = i;
                        subtract = true;
                        System.out.println ("Last iteration "+i);
                        globalStack.clear();
                        localStack.clear();
                        currentCount = 0;
                    } else if (startIndex + 1 < s.length()) {
                        startIndex+=1;
                        i = startIndex;
                        subtract = true;
                        System.out.println ("Last iteration "+i);
                        globalStack.clear();
                        localStack.clear();
                        currentCount = 0;
                    }                                                                   
                }
                System.out.println ("Max count "+maxCount);
            }
        }

        return maxCount;
    }
}