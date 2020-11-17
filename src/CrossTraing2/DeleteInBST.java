package CrossTraing2;
/*
Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.

Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.

Assumptions

There are no duplicate keys in the binary search tree

The smallest larger node is first candidate after deletion
 */
public class DeleteInBST {
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
//    public TreeNode deleteTree(TreeNode root, int key){
//        // 先找到这个node，再把它delete掉；
//    }
}
