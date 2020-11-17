package HeapGraphSearch;


import BinarySearchTree.TreeNode;

import java.util.*;

public class GetKeysInBinaryTreeLayer {

    public List<List<Integer>> layerByLayer(TreeNode root){

        //? 为什么需要一个list？因为最后return的是所有的node，这些所有的node 是分层被一个arraylist给包围的
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null){
            return list;
        }
        //还得建一个queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            //a:这个size是动态变化的，只能放在for 前面
            //也就是 第一层1个node，第二层2个node，每次在打印之前我把每层的node的size给记录一下，我就打size 个node；有几个打印几个；
            int size = queue.size();
           //b：我每一层有几个node，我把每一层node的个数记录一下，再用一个for循环，把当前层的node 给打印出来就好了；

            List<Integer> curLayer = new ArrayList<>();
           for (int i = 0; i < size; i++){
               TreeNode printNode = queue.poll();
               curLayer.add(printNode.key);
               if (printNode.left != null){
                   queue.offer(printNode.left);
               }
               if(printNode.right != null){
                   queue.offer(printNode.right);
               }
           }
           list.add(curLayer);
        }
        return list;
    }

    public static void main(String[] args) {
        GetKeysInBinaryTreeLayer sol = new GetKeysInBinaryTreeLayer();
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
}
