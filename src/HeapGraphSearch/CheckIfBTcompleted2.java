package HeapGraphSearch;

import BinarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBTcompleted2 {
    public static void main(String[] args) {
        CheckIfBTcompleted2 sol = new CheckIfBTcompleted2();
        /*
                 1
              /    \
             2      3
            / \    / \
           4   5 nul  nul
           /
           7


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
//        TreeNode n6 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
//        n4.left = n6;
        n3.right = n6;

        System.out.println(sol.isCompleted(n1));
    }

    public boolean isCompleted(TreeNode root){
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //offer root, expand then generate
        boolean flag = false; // 这句话在while里面和外面的区别？放在里面每generate的时候都会把上一层已经set好的flag给冲掉，所以得放在外面
        queue.offer(root);
        while (!queue.isEmpty()){

            TreeNode cur = queue.poll();
            if (cur.left == null){
               flag = true;
            }else if(flag){ //flag的内容都和上一层定义的boolean flag有关，但是只有if条件为true的时候才会执行哦，这是基础；
                return false; //意味之前已经有过一次null了，我把flag从false变成了true，但现在又一次出现
            }else { // 如果flag 不是true的话，那就是第三种情况，left孩子即不是null，并且之前也没有出现过null，所以很安全的把left child给加进去
                queue.offer(cur.left);

            }

            if (cur.right == null){
                flag = true;
            }else if (flag){
                return false;
            }else {
                queue.offer(cur.right);
            }

        }
        return true;

    }
}
