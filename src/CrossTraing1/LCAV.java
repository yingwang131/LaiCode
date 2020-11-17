package CrossTraing1;

import java.util.ArrayList;
import java.util.List;

/*
Given two nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

-There is no parent pointer for the nodes in the K-nary tree.

-The given two nodes are guaranteed to be in the K-nary tree.

Examples



        5

      /   \

     9   12

   / | \      \

 1 2   3      14



The lowest common ancestor of 2 and 14 is 5.

The lowest common ancestor of 2 and 9 is 9.


 */
public class LCAV {
    //说白了就在k叉树里找2个nodes的lca，以前是在2叉树找，现在在k叉树找
    static class KnaryTreeNode {
      int key;
      List<KnaryTreeNode> children;
      public KnaryTreeNode(int key) {
          this.key = key;
          this.children = new ArrayList<>();
      }
    }
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        if(root == null || root == a || root == b){
            return root;
        }
        KnaryTreeNode result = null;
        for (KnaryTreeNode x: root.children){
            KnaryTreeNode resultOfchild = lowestCommonAncestor(x, a, b);
            if (resultOfchild != null){// 如果roc 不是null，到目前为止，只有一个resultOfchild返回non-null
                if (result == null){
                    // 只有一个roc 返回notNull，其他的reuslt 都是null，那我应该返回那个孩子返回的东西；
                    result = resultOfchild;
                } else {
                    //有一个roc 返回notNull，其他的result 也都是notNull，那我就返回root；
                    return root;
                }
            }
        }
        return result;
    }

}
