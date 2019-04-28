import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class Solution2 {
    public static void main (String Args[]) {
        Scanner sc = new Scanner (System.in);
        String input = sc.next();        
        System.out.println(lengthOfLongestSubstring(input));
        System.out.println(longestPalindrome(input));
        System.out.println(romanToInt(input));
        System.out.println ("Enter a number to convert to Roman Number");
        int romanNumber = sc.nextInt();
        System.out.println(intToRoman(romanNumber));
        sc.close();    
    }

    private static String longestPalindrome(String s) {        
        int maxLength = 0;
        String longestSub = "";
        HashMap<Character, ArrayList<Integer>> characterToNumberMapping = new HashMap<>();        
        for (int i =0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (characterToNumberMapping.containsKey(x)) {
                ArrayList<Integer> indices = characterToNumberMapping.get(x);
                indices.add(i);
                characterToNumberMapping.put(x, indices);                
            } else {
                ArrayList<Integer> index = new ArrayList<>();
                index.add(i);
                characterToNumberMapping.put(x, index);             
            }
        } 
        
        for (Map.Entry<Character, ArrayList<Integer>> entry : characterToNumberMapping.entrySet()) {
            ArrayList<Integer> indices = entry.getValue();
            if (indices.size() == 1 && maxLength == 0) {
                maxLength = 1;
                longestSub = entry.getKey()+"";
            } else {
                for (int i = 0; i < indices.size()-1; i++) {
                    for (int j= indices.size() - 1; j >= i; j--) {
                        String sub = s.substring(indices.get(i),indices.get(j)+1);
                        if (isPalindrome(sub)) {
                            if (sub.length() > maxLength) {
                                maxLength = sub.length();
                                longestSub = sub;
                            }
                        }
                    }                            
                }
            }            
        }
        
        return longestSub;
    }        

    private static boolean isPalindrome(String s) {
        System.out.println("Checking palin "+s);
        for (int i =0 ; i<=s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i))
            return false;
        }
        return true;
    }

    public static int romanToInt(String s) {        
        LinkedHashMap<Character, Integer> valueMapping = new LinkedHashMap<>();
        valueMapping.put('M',1000);
        valueMapping.put('D', 500);
        valueMapping.put('C', 100);
        valueMapping.put('L', 50);
        valueMapping.put('X', 10);
        valueMapping.put('V', 5);
        valueMapping.put('I', 1);
        char currChar, nextChar; 
        int finalValue = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1) {
                currChar = s.charAt(i);
                nextChar = s.charAt(i+1);
                int currValue = valueMapping.get(currChar);
                int nextValue = valueMapping.get(nextChar);
                if (currValue >= nextValue) {
                    finalValue += currValue;
                } else {
                    finalValue += nextValue-currValue;
                    i++;
                }
            } else {
                finalValue+= valueMapping.get(s.charAt(i));
            }            
        }
        return finalValue;
    }

    public static String intToRoman(int num) {
        LinkedHashMap<Integer, Character> valueMapping = new LinkedHashMap<>();
        valueMapping.put(1000,'M');
        valueMapping.put( 500,'D');
        valueMapping.put( 100,'C');
        valueMapping.put( 50,'L');
        valueMapping.put( 10,'X');
        valueMapping.put( 5,'V');
        valueMapping.put( 1,'I');
        int temp = num;
        int power = 0;
        StringBuilder ans = new StringBuilder("");
        while (temp != 0) {
            int d = temp%10;
            int placeValue = (int)Math.pow(10, power++) * d;
            System.out.println(placeValue);            
            if (valueMapping.containsKey(placeValue)) {
                ans.insert(0, valueMapping.get(placeValue));                
            } else {
                int nextLargerNumer = nextLargerNumber(placeValue);
                if (valueMapping.containsKey(nextLargerNumer-placeValue)) {
                    String a = valueMapping.get(nextLargerNumer-placeValue) +""+ valueMapping.get(nextLargerNumer);
                    ans.insert(0, a);                    
                } else {
                    String a = "";
                   while (placeValue > 0) {                       
                       int immidiateSmallerNumber = immidiateSmallerNumber(placeValue);
                       a += valueMapping.get(immidiateSmallerNumber);                       
                       System.out.println("Immediate smaller number "+immidiateSmallerNumber+ " Place Value "+placeValue);
                       placeValue -= immidiateSmallerNumber;                                              
                   }
                   ans.insert(0, a);
                }
            }
            temp/=10;
        }
        return ans.toString();
    }

    private static int immidiateSmallerNumber (int number) {
        if (number >= 1 && number < 5)
        return 1;
        else if (number >= 5 && number < 10)
        return 5;
        else if (number >= 10 && number <  50)
        return 10;
        else if (number >= 50 && number < 100) 
        return 50;
        else if (number >= 100 && number < 500)
        return 100;
        else if (number >= 500 && number < 1000) 
        return 500;
        else if (number >= 1000)
        return 1000;
        return 0;
    }

    private static int nextLargerNumber (int number) {
        if (number > 1 && number <= 5)
        return 5;
        else if (number > 5 && number <= 10)
        return 10;
        else if (number > 10 && number <=  50)
        return 50;
        else if (number > 50 && number <= 100) 
        return 100;
        else if (number > 100 && number <= 500)
        return 500;
        else if (number > 500)
        return 1000;
        else return 0;
    }
 
    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currLength = 0;
        HashMap<Character, Integer> characterToIndex = new HashMap<>();
        for (int  i= 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!characterToIndex.containsKey(x)) {
                characterToIndex.put(x, i);
                currLength++;
            } else {
                maxLength = currLength > maxLength ? currLength : maxLength;
                System.out.println ("Max Length "+maxLength);
                currLength = 0;
                i = characterToIndex.get(x);
                characterToIndex.clear();                
            }
        }
        maxLength = currLength > maxLength ? currLength : maxLength;
        return maxLength;
    }
}