package CrossTraing2;

import java.lang.constant.Constable;

import static java.lang.Integer.*;

public class ClosedToTarget {
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


    public int closed(TreeNode root, int target) {

        int minG = MAX_VALUE;
        int ans = root.key;
        TreeNode cur = root;
        while (cur != null) {

            if (cur.key == target) {
                return root.key;
            } else if (cur.key < target) {
                int diff = Math.abs(cur.key - target);
                if (diff < minG) {
                    ans = cur.key;
                }
                minG = min(minG, diff);
                cur = cur.right;
            } else if (cur.key > target) {
                int diff = Math.abs(cur.key - target);
                if (diff < minG) {
                    ans = cur.key;
                }
                minG = min(minG, diff);
                cur = cur.left;
            }
        }
        return ans;
    }

    public int closed2(TreeNode root, int target) {
        int cur = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            } else {
                if (Math.abs(root.key - target) < Math.abs(cur - target)) {
                    cur = root.key;
                }
                if (root.key < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        ClosedToTarget sol = new ClosedToTarget();
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(12);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;


        System.out.println(sol.closed2(n1,14));
//        System.out.println(sol.closed(n1, 14));
    }

}
