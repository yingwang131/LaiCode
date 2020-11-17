package BinarySearchTree;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key){
        this.key = key;
        left = right = null;
    }
    @Override
    public String toString() {
        return Integer.toString(key);
    }
}
