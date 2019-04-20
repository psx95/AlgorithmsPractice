import java.util.Scanner;

public class MinimalTree  {
    static int intArr[];
    static BinaryTreeNode nodeArr[];
    public static void main (String Args[]) {

    }

    private static void processArray (int mid, int start, int end) {
        if (mid - start <= 1) { 
            processNode(getNodeAt(mid), getNodeAt(start), null);
        } else {
            BinaryTreeNode root = getNodeAt(mid);            
            processNode(root, left, null);
            int prevMid = mid;
            mid = Math.floor((mid+start)/2);            
            processArray(mid, start, end);
            start = prevMid;
            mid = 
        }
    }

    private static BinaryTreeNode getNodeAt(int pos) {
        if (nodeArr[pos] != null) {
            return nodeArr[pos];
        } else {
            BinaryTreeNode node = new BinaryTreeNode(intArr[pos]);
            nodeArr[pos] = node;
            return node;
        }
    }  

    private static void processNode (BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right) {
        if (root == null) {
            throw new Exception ("Cannot process node with NULL root");
        } else {
            if (left!=null)
                root.left = left;
            if (right!=null)
                root.right = right;            
        }
    }
}