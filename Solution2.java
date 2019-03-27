public class Solution2 {
    public static void main (String... args) {
        System.out.println(isPermutation(args[0], args[1]));
        System.out.println(isPermutation_opt(args[0], args[1]));
    }

    private static boolean isPermutation (String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            int[] a1 = new int[128];
            int[] b1 = new int[128];
            for (int i = 0; i<a.length(); i++) {
                a1[a.charAt(i)]++;
                b1[b.charAt(i)]++;
            }
            for (int i = 0; i<128;i++) {
                if (a1[i]!=b1[i]) {                    
                    return false;
                }                
            }
            return true;
        }        
    }

    // eliminating the use of 2 count arrays
    private static boolean isPermutation_opt (String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            int[] a1 = new int[128]; // only ascii characters are present
            for (int i = 0; i<a.length(); i++) {
                a1[a.charAt(i)]++;
                a1[b.charAt(i)]--;
            }
            for (int i = 0; i<128;i++) {
                if (a1[i]!=0) {                    
                    return false;
                }                
            }
            return true;
        }        
    }
}