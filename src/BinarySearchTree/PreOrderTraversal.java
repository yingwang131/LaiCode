package BinarySearchTree;

import java.util.*;

public class PreOrderTraversal {
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            result.add(cur.key);
            if (cur.right!= null){ // 因为我想先打印出2，所以先把右边的node push到stack的低步，下次pop的时候，是先pop出后放进去的2
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return result;
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
        System.out.println(preOrder(n1));
    }
}
