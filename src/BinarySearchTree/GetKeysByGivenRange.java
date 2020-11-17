package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class GetKeysByGivenRange {
    public static List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        //base case: if root == min ==max, return root; 还要返回一个List，是不是得开一个list
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        helper(root, min, max, res);
        return res;
    }
    private static void helper(TreeNode root, int min, int max, List<Integer> res){
        //base case
        if (root == null){
            return;
        }

        if (root.key > min){
            helper(root.left, min, max, res);
        }
        if (root.key >= min && root.key <= max){
            res.add(root.key);
        }
        if (root.key < max){
            helper(root.right, min,max, res);
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);

        int min = 2;
        int max = 5;
        System.out.println(getRange(n1, min,max));


    }
}
