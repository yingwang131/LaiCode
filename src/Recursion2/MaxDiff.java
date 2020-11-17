package Recursion2;

import CrossTrainingIII.MaxWaterTrappedI;

public class MaxDiff {
    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
        public String toString() {
            return Integer.toString(key);
        }
    }
    public  int maxDifferNode(TreeNode root){
        if (root == null){
            return 0;
        }
        int[] globalMax = {0};
        TreeNode[] sol = new TreeNode[0];
        helper(root,globalMax,sol);
        return 0;//不知道这里怎么写；
    }
    private int helper(TreeNode root,int[] globalMax,TreeNode[] sol){
        //base case
        if (root == null){
            return 0;
        }

        //step1
        int leftTotal = helper(root.left, globalMax, sol);
        int rightTotal = helper(root.left, globalMax, sol);
        //step2
        if (Math.abs(leftTotal - rightTotal) > globalMax[0]){
            globalMax[0] = Math.abs(leftTotal - rightTotal);
            sol[0] = root;
        }
        //step3
        return  leftTotal + rightTotal + 1;
    }

    public static void main(String[] args) {
        MaxDiff sol = new MaxDiff();

        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(1);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        n5.right = n8;

        System.out.println(sol.maxDifferNode(n1));

    }
}
