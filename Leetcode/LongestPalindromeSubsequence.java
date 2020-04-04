class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        String reverseString = str.reverse().toString();
        return calculateLCS(s, reverseString);
    }
    
    private int calculateLCS(String a, String b) {
        int [][] lcs = new int[a.length() + 1][b.length() + 1];
        
        for (int i = 0; i < a.length() + 1; i++) {
            // rows
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;                    
                } else {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        lcs[i][j] = 1 + lcs[i-1][j-1];
                    } else {
                        lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                    }
                }                
            }            
        }        
        printLongestPalindromeSeq(lcs, a, b, a.length(), b.length());
        return lcs[a.length()][b.length()];
    }
    
    private void printLongestPalindromeSeq (int[][] lcs, String a, String b, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (a.charAt(i-1) == b.charAt(j-1)) {            
            printLongestPalindromeSeq(lcs, a, b, i-1, j-1);
            System.out.print(a.charAt(i-1));
        } else {
            if (lcs[i-1][j] >= lcs[i][j-1]) {
                printLongestPalindromeSeq(lcs, a, b, i-1, j);
            } else {
                printLongestPalindromeSeq(lcs, a, b, i, j - 1);
            }
        }
    }
    
    private void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print (arr[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
