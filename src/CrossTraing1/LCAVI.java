package CrossTraing1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given M nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

- M >= 2.

- There is no parent pointer for the nodes in the K-nary tree.

- The given M nodes are guaranteed to be in the K-nary tree.

Examples

        5

      /   \

     9   12

   / | \      \

  1 2 3     14



The lowest common ancestor of 2, 3, 14 is 5.

The lowest common ancestor of 2, 3, 9 is 9.
 */
public class LCAVI {
    //说白了就在k叉树里找k个nodes的lca，以前是在2叉树找，现在在k叉树找;以前是2个节点，现在是k个节点
    //就是把basecase换成set呗，和LCAIV写法差不多
    static class KnaryTreeNode {
        int key;
        List<KnaryTreeNode> children;
        public KnaryTreeNode(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        // Write your solution here
        Set<KnaryTreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }
    private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set){
        if (root == null || set.contains(root)){
            return root;
        }
        KnaryTreeNode result = null;
        for (KnaryTreeNode x: root.children){
            KnaryTreeNode resultOfchild = helper(x, set);
            if (resultOfchild != null){
                if (result == null){
                    result = resultOfchild;
                } else {
                    return root;
                }
            }
        }
        return result;
    }

}
