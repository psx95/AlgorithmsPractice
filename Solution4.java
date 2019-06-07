import java.util.Scanner;
import java.util.Stack;

public class Solution4 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Answer is \n"+countAndSay(n));
        sc.close();
    }

    private static String countAndSay(int n) {
        String next = "1";
        StringBuilder builder = new StringBuilder("");
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                builder.append("1").append("\n");                
            } else {
                next = countSay(next);
                builder.append(next).append("\n");
            }            
        }
        return builder.toString();
    }

    private static String countSay (String s) {
        char lastChar = 'x', currChar;
        int count = 0;
        boolean allDone = false;
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            currChar = s.charAt(i);
            if (lastChar == 'x') {
                lastChar = currChar;
                count++;
            } else if (lastChar == currChar) {
                count++;
            } else {
                // lastChar != currChar                
                str.append(count).append(lastChar);
                count = 1;
            }
            lastChar = currChar;          
        }
        if (!allDone)
            str.append(count).append(lastChar);
        //System.out.println ("returning "+str.toString());
        return str.toString();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char x;
        for (int i = 0; i<s.length(); i++) {
            x = s.charAt(i);
            if (x == '{' || x == '(' || x == '[') {
                stack.push(x);
            } else if (x == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (x == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (x == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        } else {
            return haystack.indexOf(needle);            
        }
    }

    public int searchInsert(int[] nums, int target) {    
        int low = 0, high = nums.length -1, mid = (low+high)/2;        
        if (target > nums[l-1]) {
            return l;
        }
        if (target < nums[0]) {
            return 0;
        }
        while (high > low) {
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid;
                mid = (low+high)/2;                
            } else {
                high = mid;
                mid = (low+high)/2;
            }
        }
        return mid;
    }
}