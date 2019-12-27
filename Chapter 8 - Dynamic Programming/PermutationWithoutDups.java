import java.util.List;
import java.util.ArrayList;

public class PermutationWithoutDups {
    public static void main(String[] args) {
        String s = args[0];
        printList(permute(s));
    }

    public static List<String> permute(String s) {
        List<StringBuilder> s_list = permuteHelper(new StringBuilder(s), s.length());
        List<String> ans = new ArrayList<>();
        for (StringBuilder str : s_list) {
            ans.add(str.toString());
        }
        return ans;
    }

    // permute helper will be called n! times
    private static List<StringBuilder> permuteHelper(StringBuilder s, int length) {
        if (length == 0) {
            return new ArrayList<>();
        }
        if (length == 1) {
            List<StringBuilder> list = new ArrayList<>();
            list.add(new StringBuilder(s.substring(0, 1)));
            return list;
        }
        if (length == 2) {
            List<StringBuilder> list = new ArrayList<>();
            StringBuilder _s = new StringBuilder(s.substring(0, 2));
            StringBuilder _s2 = new StringBuilder(s.substring(0, 2));
            list.add(_s);
            list.add(_s2.reverse());
            return list;
        }
        List<StringBuilder> list = permuteHelper(s, --length);
        printList(list);
        List<StringBuilder> newList = new ArrayList<>();
        for (StringBuilder strBldr : list) {
            // strBldr = 'ab'
            System.out.println(strBldr + " length " + strBldr.length());
            char x = s.charAt(length - 1);

            for (int i = 0; i <= strBldr.length(); i++) {
                StringBuilder str = new StringBuilder(strBldr);
                // str.setCharAt(i, x);
                str.insert(i, x);
                // if (str.length() == s.length())
                newList.add(str);
            }
        }
        return newList;
    }

    private static <T> void printList(List<T> s) {
        System.out.println("[");
        int count = 0;
        for (T a : s) {
            System.out.println(a);
            count++;
        }
        System.out.println("Total permutations =" + count + "]");
    }
}