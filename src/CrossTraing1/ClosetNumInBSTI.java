package CrossTraing1;
/*
这个题目是crossingTraing2 的题目，laicode 135题
Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6
 */

public class ClosetNumInBSTI {
    public static class TreeNode{
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int key){
            this.key = key;
        }
    }

    public int closet(TreeNode root, int target){
        //root is not null and no duplicate keys
        int result = root.key;
        while (root != null){
            if (root.key == target){
                return root.key;
            }else {
                if (Math.abs(root.key - target) < Math.abs(result - target)){
                    result = root.key;
                }
                if (root.key < target){
                    root = root.right;
                }else {
                    root = root.left;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ClosetNumInBSTI sol = new ClosetNumInBSTI();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(14);



        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;



//        System.out.print(sol.closet(n1,10));
        System.out.print(sol.closet(n1,4));
    }
}
