package CrossTraing1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given K nodes in a binary tree, find their lowest common ancestor.
Assumptions

K >= 2

There is no parent pointer for the nodes in the binary tree

The given K nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2, 3, 14 is 5

The lowest common ancestor of 2, 3, 9 is 9
 */
public class LCAIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }
    private TreeNode helper(TreeNode root, Set<TreeNode> set){
        //唯一的区别就是basecase check的时候；n个node和2个node其实没有区别，
        //只要不在root下面的结点，我们都不考虑；
        if (root == null || set.contains(root)){
            return root;
        }
        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right,set);
        if (left != null && right != null){
            return root;
        }
        return left == null? right:left;
    }
}
