package BinarySearchTree;

public class CountNode {
    public static int countNode(TreeNode root){
        //basecase
        if (root == null){
            return 0;
        }
        return countNode(root.left) + countNode(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(12);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;


        System.out.println(countNode(n1));
    }
}
