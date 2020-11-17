package CrossTraing1;

import HeapGraphSearch.GetKeysInBinaryTreeLayer2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode (int key){
        this.key = key;
    }
}

public class BFS1GetKeysBylayer {
    public List<List<Integer>> layerByLayer(TreeNode root){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null){
            return list;
        }
        //bfs1 classical way, FIFO queue, generate one node, expand 2 nodes
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size(); // count size 必须在while 里面，因为每次generate 和poll数量都会变化；
            List<Integer> layer = new ArrayList<>();
            for (int i =0; i < size; i++ ){
                TreeNode print = queue.poll();
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
    public static void main(String[] args) {
        BFS1GetKeysBylayer sol = new BFS1GetKeysBylayer();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;



        System.out.print(sol.layerByLayer(n1));
    }
}
