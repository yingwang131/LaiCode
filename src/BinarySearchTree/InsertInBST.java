package BinarySearchTree;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.xml.transform.stax.StAXResult;

public class InsertInBST {
    // 不知道为什么这个iteration 方法2过不去laicode， 83/101
    public static TreeNode insertIterative2(TreeNode root, int key){
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while (root != null){
            prev = root;
            if (root.key < key){
                root = root.right;
            }else if (root.key > key){
                root = root.left;
            }else {
                return cur;
            }
        }
        if (prev.key < key){
            prev.right = new TreeNode(key);
        }else if (prev.key > key){
            prev.left = new TreeNode(key);
        }
        return cur;

    }

    public static TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        if (root == null){
            return new TreeNode(key);
        }
        if (root.key > key){
            root.left =  insert(root.left, key);
        }else if (root.key < key) {
            root.right = insert(root.right, key);
        }
        return root;

    }

    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.key + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = null;
//        root = insertIterative2(root, 17);
//        insertIterative2(root, 3);
//        insertIterative2(root, 20);
//        insertIterative2(root, 40);
//        insertIterative2(root, 70);
//        insertIterative2(root, 60);
//        insertIterative2(root, 80);


        /*
                10
                / \
              5    15
              \
              8
              /\
              6 9
         */
        root = insert(root,10);
        insert(root, 5);
        insert(root,15);
        insert(root, 8);
        insert(root,6);
        insert(root, 9);


        inOrder(root);
    }
}
