package CrossTraing1;




public class LCABST1 {


    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;

        }
        public String toString(){
            return Integer.toString(key);
        }
    }

    public TreeNode lca(TreeNode root, int p, int q) {
        // 以前基础版的lac 入参是3个node，但这个题目是一个node，2个值，所以说LCA和BSTLCA入不一样
        //base case
        if (root == null) {
            return root;
        }
        //从左右孩子拿信息
        if (p < root.key && q < root.key) {
            //? q 也要小于root.key，是把右子树剪枝了么？
            // 不是剪枝，是pq比root小，就在左边，pq比root大就在右边，如果都不满足就return root
            root = root.left;
        }
        if (p > root.key && q > root.key) {
            root = root.right;
        }
        //当前层干点啥
        //把什么信息返回给爸爸
        return root;
    }

    public static void main(String[] args) {
        LCABST1 sol = new LCABST1();

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(14);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        TreeNode result = sol.lca(n1, 1, 3);
        System.out.println(result.toString());
    }
}