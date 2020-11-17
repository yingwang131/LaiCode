package HeapGraphSearch;

import BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetKeysInBinaryTreeLayer2 {
    public static void main(String[] args) {
        GetKeysInBinaryTreeLayer2 sol = new GetKeysInBinaryTreeLayer2();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(9);
        TreeNode n8 = new TreeNode(11);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n4.left = n7;
        n4.right = n8;


        System.out.print(sol.layerByLayer(n1));
    }
    public List<List<Integer>> layerByLayer(TreeNode root){

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null ){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        //offer the root into queue

        queue.offer(root);
        while (!queue.isEmpty())  {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for ( int i =0; i < size; i++ ){
                TreeNode print =  queue.poll();
                layer.add(print.key);
                if (print.left != null){
                    queue.offer(print.left);
                }
                if (print.right != null){
                    queue.offer(print.right);
                }
            }
            list.add(layer);

        }
        return list;

    }
}
