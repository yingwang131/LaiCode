package BinarySearchTree;

import javax.swing.*;

public class DeleteInBST {
     /*
     step1：find target node
     step2：根据4中情况 delete node 8
      */
     public static TreeNode delete(TreeNode root, int target){
         if (root == null){
             return null;
         }
         //step1：find target node
         //如果不写root.left = 我的root 还是会不断变化，因为在main函数构图的时候已经决定了左右node是谁
         //写上root.left = 的原因是能让我的整个树连起来，而不是都是分散的每个recursion call，分散的树没有意义，最后返回root看不出效果
         if (root.key > target){
             root.left = delete(root.left, target);
             return root;
         }else if (root.key < target){
             root.right = delete(root.right, target);
             return root;
         }
         /*
         如果代码能走到这里，guarantee root != null && root.key == target(6==6),找到了target，该删除8了；
         前三种情况：
         case1：The node to be deleted has no children; delete 8，return null
             3                   3
            / \      ->         / \
           2   8               2
         case2: the node to be deleted has no left child; delete 8, return root.right
             3                  3
            / \                / \
           2   8     ->       2   10
                \
                10
         case3: the node to be deleted has no right child; delete8,return root.left
             3                  3
            / \                / \
           2   8     ->       2   6
               /
              6
          */
         if (root.left == null){
             return root.right; //case 1,2; 有case1是因为r.L=null，return r.R，最后还是return null，因为没有孩子，所以return上去的如果是null，说明8已经删除掉了；
         }else if (root.right == null){
             return root.left; //case 3
         }
         /*
         代码如果能走到这里，说明是case 4，有2个孩子，先看case 4.1：把8删掉，把6接到8node 的右孩子的左孩子上（即10的左孩子）
             3                  3
            / \                / \
           2   8     ->       2   10
              / \                 / \
             6  10               6   12
                  \
                   12
          */
         if (root.right.left == null){
             root.right.left = root.left;
             return root.right; //最终还是返回root.right,把10 给返上去
         }
         /*
         代码如果能走到这里，说明是case 4，有2个孩子，再看case 4.2：先找到最小的node 9，把9删掉；
         再把待删除的node8的左右孩子和node9接上，就完美的删除了node8，并保证数的结构正确
             3                  3
            / \                / \
           2   8     ->       2    9
              / \                 / \
             6  12               6   12
               /  \                  / \
             11    14               11  14
             /                      /
            9                     10
             \
             10
          */
         //1:find and deleted smallest node in the root.right
         TreeNode smallest = deleteSmallest(root.right);
         //2:connect the smallest node with root.left and root.right
         smallest.left = root.left;
         smallest.right = root.right;
         //3:return the smallest node,因为我已经在上面2不重新构建了我的tree，我当然要把 node 9返上去，才能和3连上呀，要不然整个tree也就不对了
         return smallest;

         }

         private static TreeNode deleteSmallest(TreeNode cur){ //cur = 12
            TreeNode prev = cur; //prev = 12
            cur = cur.left; // cur = 11, cur 是在不断变化的
            while (cur.left != null){
                prev = cur; //prev = 11
                cur  = cur.left;//cur =9
            }
            prev.left = prev.left.right;
            return cur;
     }
    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.key + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
         /*
             3                  3
            / \                / \
           2   8     ->       2    9
              / \                 / \
             6  12               6   12
               /  \                  / \
             11    14               11  14
             /                      /
            9                     10
             \
             10
          */
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(12);
        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(14);
        TreeNode n8 = new TreeNode(9);
        TreeNode n9 = new TreeNode(10);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n5.left = n6;
        n5.right = n7;
        n6.left=n8;
        n8.right = n9;
        int target = 8;
        delete(n1, target);
        inOrder(n1);
    }
}
