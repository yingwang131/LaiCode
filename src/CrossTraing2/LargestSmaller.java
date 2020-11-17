package CrossTraing2;

import com.sun.source.tree.Tree;

public class LargestSmaller {
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
    public int largestSmaller(TreeNode root, int target){
        int cur = Integer.MIN_VALUE;
        while (root != null){
            if (root.key >= target){
                root = root.left;
            }else {
                // 这里要注意if else 的用法
                //update the largest solution
                cur = root.key;
                root = root.right;
            }
        }
        return cur;

    }

    public static void main(String[] args) {
        LargestSmaller sol = new LargestSmaller();
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(12);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;


//        System.out.println(sol.largestSmaller(n1,14));
//        System.out.println(sol.closed(n1, 14));

        int x = 16;
        if (x > 115){
            System.out.println("x>0");
        }else if (x > 50){
            System.out.println("x>5");
        }else if (x > 100){
            System.out.println("x > 10");
        }else {
            System.out.println("other， x>0");
        }
    }
}
