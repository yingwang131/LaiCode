package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderTraversal {
    public static List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode current = stack.peekFirst();
            //prev是null， current 是 prev 的子女的时候，就该左边优先的往下看；
            if (prev == null || current == prev.left || current == prev.right){
                //有左子女，就把左子女放进来
                if (current.left != null){
                    stack.push(current.left);

                }else if (current.right != null){// 没有左子女，就把右子女放进来
                    stack.push(current.right);
                }else {
                    //如果左右子女都没有，就打印当前节点，就打印自己，打印方式就是pop出来
                    result.add(current.key);
                    stack.pollFirst();
                }
                // 如果我从左边返回的时候，我就看看右边有没有子女，右边如果没有子女，打印自己；右边如果有子女，把右子女push进去
            }else if (prev == current.left){
                if (current.right != null){
                    stack.push(current.right);
                }else {
                    result.add(current.key);
                    stack.pollFirst();
                }
                // 如果不是从左边返回，是从右边返回的时候，先打印当前节点，把当前节点拿出来，
            }else {
                result.add(current.key);
                stack.pollFirst();
            }
            //不管之前做了什么，都让prev = cur，到这一步，这两个变量分别指向谁？
            prev = current;
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
            postorder:13285
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

        System.out.println(postOrder(n1));
    }

}
