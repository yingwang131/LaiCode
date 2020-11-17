package BinarySearchTree;

public class SearchInBST {
    public TreeNode search(TreeNode root, int key){
        if (root == null){
            return null;
        }
        //bst的性质，左子树的每一个node都要比root小，所以search左边可以这么写
        if(root.key > key){
            return search(root.left, key);
        }else if (root.key < key){
            return search(root.right, key);
        }else {
            return root;
        }
    }

    public static void main(String[] args) {
        SearchInBST sol = new SearchInBST();

        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        int k = 7;
        System.out.println(sol.search(n1, k));
    }
}
