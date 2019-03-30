public class Solution5 {
    public static void main (String args[]) {
        System.out.println ("Strings one edit away "+oneEdit(args[0], args[1]));
    }

    private static boolean oneEdit(String a, String b) {
        if (a.length() == b.length()) {
            boolean replaced = false;
            for (int i = 0; i<a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (!replaced)
                    replaced = true;
                    else 
                    return false;
                }
            }
            return true;
        } else {
            if (Math.abs(a.length() - b.length()) > 1) {
                return false;
            } else {
                boolean operationPerformed = false;
                String max = a.length() > b.length() ? a : b;
                String min = a.length() < b.length() ? a : b;
                int j = 0;
                for (int i = 0; i< min.length(); i++) {
                    if (min.charAt(i)!=max.charAt(j)) {
                        if (operationPerformed)
                        return false;
                        else {
                            operationPerformed = true;
                            if (max.charAt(++j)!= min.charAt(i)) {
                                return false;
                            }
                        }
                    }
                    j++;
                }
                return true;
            }
        }
    }
}