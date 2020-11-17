package CrossTraing2;



import java.security.PublicKey;

/*
Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.

Assumptions

There are no duplicate keys in the binary search tree
basecase： root == null
subproblem： search(root.left)，search（root.right）
recursion rule：只要找到k，就返回这个node
 */
public class SearchInBST {

    static class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
    public String toString() {
        return Integer.toString(key);
    }
  }
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
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;



//        System.out.println(sol.search(n1,8));
        System.out.println(sol.search(n1,1));
    }

}
