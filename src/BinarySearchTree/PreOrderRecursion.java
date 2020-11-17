package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderRecursion {
    public static List<Integer> preOrder(TreeNode root){
        //? 为什么要用一个List
        List<Integer> result = new ArrayList<>();
        //subproblem
        preOrder(root, result);
        return result;
    }
    public static void preOrder(TreeNode root, List<Integer>result){
        if (root == null){
            return;
        }
        result.add(root.key);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public static void main(String[] args) {

//        List<Integer> result = new ArrayList<>();
//        result.add(0, 10);
//        result.add(1,5);
//        result.add(2, 15);
//        result.add(3,2);
//        result.add(4, 7);
//        result.add(5,12);
//        result.add(6,20);
//
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(preOrder(n1));

    }
}
