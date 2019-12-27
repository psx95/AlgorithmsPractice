import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Parenthesis {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        printList(new ArrayList<>(validParenthesis(n)));
    }

    public static Set<String> validParenthesis(int n) {
        if (n == 0) {
            return new HashSet<>();
        }
        if (n == 1) {
            String s = "()";
            Set<String> list = new HashSet<>();
            list.add(s);
            return list;
        }
        if (n == 2) {
            String s1 = "()()";
            String s2 = "(())";
            Set<String> list1 = new HashSet<>();
            list1.add(s1);
            list1.add(s2);
            return list1;
        }
        Set<String> listSoFar = validParenthesis(n - 1);
        Set<String> newList = new HashSet<>(); // form new list for parenthesis pair = n
        for (String parenthesis : listSoFar) {
            // form new list using the parenthesis pairs in the previous list
            int fromIndex = 0; // position from which a '(' will be searched. The new '()' can be inserted only
                               // after a '('
            // this loop takes care of inserting () at various valid positions within the
            // parenthesis
            // from previous iterations for n
            while (parenthesis.indexOf('(', fromIndex) != -1) {
                int openingBrace = parenthesis.indexOf('(', fromIndex);
                StringBuilder newParenthesis = new StringBuilder();
                newParenthesis.append(parenthesis.substring(0, openingBrace + 1));
                newParenthesis.append("()");
                newParenthesis.append(parenthesis.substring(openingBrace + 1));
                newList.add(newParenthesis.toString());
                fromIndex = openingBrace + 1;
            }
            // adding a pair of parenthesis at the beginning and end of the previous
            // positions
            StringBuilder _newParenthesis = new StringBuilder("()");
            _newParenthesis.append(parenthesis);
            StringBuilder newParenthesis = new StringBuilder(parenthesis);
            newParenthesis.append("()");
            newList.add(newParenthesis.toString());
            newList.add(_newParenthesis.toString());
        }
        return newList;
    }

    private static <T> void printList(List<T> list) {
        System.out.println("[");
        for (T data : list) {
            System.out.println("\t" + data);
        }
        System.out.println("]");
    }
}