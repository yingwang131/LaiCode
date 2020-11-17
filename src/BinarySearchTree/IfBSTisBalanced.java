package BinarySearchTree;

public class IfBSTisBalanced {
    public static boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        return  isBalanced(root.left) && isBalanced(root.right)
        && Math.abs(findHeight(root.right) - findHeight(root.left)) <= 1;

    }
    public static int findHeight(TreeNode root){
        // base case
        if (root == null){
            return 0;
        }
        //subproblem:height(root.left) height(root.right)
        // recursion rule: max(l, r) + 1

        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);
        int treeH = Math.max(leftH, rightH) + 1;

        return treeH;

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;


        System.out.println(isBalanced(n1));
    }
}
