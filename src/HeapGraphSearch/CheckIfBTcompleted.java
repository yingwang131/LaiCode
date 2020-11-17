package HeapGraphSearch;

import BinarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
1：一但遇到气泡就不可以再遇到任何数字了
 */
public class CheckIfBTcompleted {
    public boolean isCompleted(TreeNode root){
        // corner case
        if (root == null){
            return true;
        }
        // 还是用BredthFirstsearch来做，expand，generate，termination rule
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flags = false; // 默认的是false，不是完全树
        queue.offer(root);

        while (!queue.isEmpty()){
            //expand
          TreeNode cur  =queue.poll();
          // 如果有任何node 没有孩子，我们就set flag 为true，表示现在进入警戒模式，气泡后面不能再出现数字，
          if (cur.left == null){ // if elseif else:谁真执行谁，当我发现3.left是null的时候，flags 由F变T，但是在这里的if不执行
              flags = true;// 因为这个condition只执行一个真的，然后到下面right 的condition，elseif(T)，return false;
          }else if (flags){//所以这个flags是为了下面做个铺垫
              // if flag is set but we still see cur has left child, then it is not a completed tree
              return false;
          }else {
              //if flag is not set and left child is present
              // 如过没有发现气泡，我就generate node 的左右孩子进去
              queue.offer(cur.left);
          }
          // same logical for right node
          if (cur.right == null){
              flags = true;
          } else if (flags){
              return false;
          } else {
              queue.offer(cur.right);
          }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfBTcompleted sol = new CheckIfBTcompleted();
        /*
                 1
              /    \
             2      3
            / \    / \
           4   5 nul  6
         */

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;




        System.out.println(sol.isCompleted(n1));
    }
}
