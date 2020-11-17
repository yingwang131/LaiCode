package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversal {
    public static List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> statck = new ArrayDeque<>();
        TreeNode helper = root;

        while (helper!= null || !statck.isEmpty()){
            if (helper != null){
                statck.push(helper);
                helper = helper.left;
            }else {
                helper = statck.pollFirst();
                result.add(helper.key);
                helper = helper.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*
            5
            /\
            2 8
            /\
            1 3

            inorder: 12358
         */
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(inOrder(n1));
    }
}
