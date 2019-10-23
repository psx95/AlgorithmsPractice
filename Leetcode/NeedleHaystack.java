public class NeedleHaystack {
    public static void main(String[] args) {

    }

    int kmpSearch(String pattern, String text) {
        if (pattern.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int[] lps = new int[pattern.length()];
        computeLps(pattern, lps);
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return i - j;
                }
            }           
            else {
                // characters did not match
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];                    
                }
            }
        }
        return -1;
    }

    void computeLps(String pattern, int[] lps) {
        int i = 1;
        int len = 0;
        lps[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(len) == pattern.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        for (int k = 0; k < lps.length; k++) {
            System.out.print(lps[k] + ",");
        }
        System.out.println();
    }
}