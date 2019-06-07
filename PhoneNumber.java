import java.util.*;
public class PhoneNumber {
	private static HashMap<Integer,String> mappings = new HashMap<Integer, String>() {{
		put (2, "abc");
		put (3, "def");
		put (4, "ghi");
		put (5, "jkl");
		put (6, "mno");
		put (7, "pqrs");
		put (8, "tuv");
		put (9, "wxyz");
	}};

	private static Node root = null;	
	private static ArrayList<Node> currentLeafNodes = new ArrayList<Node>();
	private static List<String> answer = new ArrayList<String>();
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println ("Enter digits");
		String dig = sc.next();
		letterCombinations(dig);
		System.out.println (Arrays.toString(answer.toArray()));
	}

	public static List<String> letterCombinations(String digits) {
        int currDigit;
        
        if (root == null) {
        	root = Node.convertCharToNode('\u0000');
        	currentLeafNodes.add(root);
        }

        for (int i = 0; i < digits.length(); i++) {
        	currDigit = digits.charAt(i) - 48;        	
        	String currLetters = mappings.get(currDigit);        	
        	convertLettersToTreeNodes(currLetters);
        } 
        printTree(root,"");
        return answer;       
    }

    private static void convertLettersToTreeNodes (String currLetters) {
    	ArrayList<Node> newLeafs = new ArrayList<Node>();
    	for (int k =0 ;k < currentLeafNodes.size(); k++) {
    		Node relativeRoot = currentLeafNodes.get(k);
    		for (int i = 0; i < currLetters.length(); i++) {
	    		char x = currLetters.charAt(i);
	    		Node currNode = Node.convertCharToNode(x);
	    		if (relativeRoot.adjecent == null) {
	    			relativeRoot.adjecent = new ArrayList<Node>();
	    		}
	    		relativeRoot.adjecent.add(currNode);
	    		newLeafs.add(currNode);
    		}
    	}
    	currentLeafNodes = newLeafs;    	
    }

    private static void printTree(Node root, String word) {
    	if (root == null) {
    		answer.add(word.trim());    		
    		return;
    	}
    	word = visit(root, word);
    	if (root.adjecent!=null) {
    		for (int i = 0; i< root.adjecent.size(); i++) {
    			Node n = root.adjecent.get(i);
    			if (!n.visited) {
    				printTree(n, word);
    			}
    		}
    	} else {
    		//System.out.println ("Formed word "+word);
    		answer.add(word.trim());
    	}    	
    }

    private static String visit (Node n, String word) {
    	// if (n.adjecent!=null) {
    	// 	// String a = "";
    	// 	// for (Node node : n.adjecent) {
    	// 	// 	a += node.currentChar;
    	// 	// }
    	// 	//System.out.println (a);
    	// 	System.out.print (n.currentChar +" -> "+Arrays.toString(n.adjecent.toArray()));   
    	// 	for (Node node : n.adjecent) {
    	// 		System.out.print (node.currentChar+",");
    	// 	}
    	// 	System.out.println ();
    	// } else {
    	// 	System.out.println (n.currentChar +" -> null");   
    	// }    	
    	word += n.currentChar;
    	n.visited  = true;    
    	return word;	
    }


    static class Node {
    	public boolean visited;
    	public ArrayList<Node> adjecent;
    	public char currentChar;

    	public static Node convertCharToNode (char x){
    		Node node = new Node();
    		node.visited = false;
    		node.currentChar = x;
    		node.adjecent = null;
    		return node;
    	}
    }
}