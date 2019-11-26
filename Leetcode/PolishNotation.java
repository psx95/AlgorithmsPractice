import java.util.Deque;
import java.util.LinkedList;

public class PolishNotation {
    
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isSymbol(token)) {                
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());   
               // System.out.println ("op1 "+op1 + " " + "op2 "+op2);
                stack.push(calculate(op1, op2, token)+"");
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isSymbol(String token) {
        return token.equals("+") || token.equals("/") || token.equals("*") || token.equals("-");
    }

    private int calculate (int a, int b, String op) {
        switch (op) {
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*":
            return a * b;
        case "/":
                //System.out.println ("a = "+a + " b = "+b +""+ (int)Math.floor(a / b));
            return (int)Math.floor(a / b);
        default:
               // System.out.println ("Invalid token ");
            return a;        
        }
    }
}