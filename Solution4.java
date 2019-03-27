import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import jdk.nashorn.internal.parser.Scanner;

public class Solution4 {

    static String palinPermutation(String s) {
        int single_allow = 0; 
        if (s.length()%2 !=0) {
            single_allow+=1;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int currValue = map.get(s.charAt(i));
                map.put(s.charAt(i), currValue+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue()%2!=0) {
                if (single_allow != 0) {
                    single_allow = 0;
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }    
    public static void main(String[] args) throws IOException {                
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String s = scanner.nextLine();

        String result = palinPermutation(s);
        System.out.println (result);        
    }
}
