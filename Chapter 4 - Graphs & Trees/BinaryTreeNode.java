public class BinaryTreeNode { 
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    private void printNode() {
        System.out.print("Left -> "+left == null ? "NULL": left.data +"  RIGHT -> "+right == null ? "NULL" : right.data);
    }
}