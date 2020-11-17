package CrossTraing1;




public class LCAI {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two){
        if(root == null || root == one|| root == two){
            return root;
        }
        TreeNode left   =lowestCommonAncestor(root.left, one, two);
        TreeNode right  =lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null){
            return root;
        }
        return left == null ? right: left;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode one, TreeNode two){
        if(root == null || root == one|| root == two){
            return root;
        }
        TreeNode left   =lowestCommonAncestor2(root.left, one, two);
        TreeNode right  =lowestCommonAncestor2(root.right, one, two);
        if (left == null && right == null ){
            return null;
        }
        if (left != null && right != null){
            return root;
        }
        if (left != null && right == null){
            return left;
        }
        if (left == null && right != null){ //哪里会用到
            return right;
        }
        return root;

    }
    public static void main(String[] args) {
        LCAI sol = new LCAI();

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(14);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

//        n1.left = null;
//        n1.right = null;

        System.out.println(sol.lowestCommonAncestor2(n1,n4,n6));
    }
}



