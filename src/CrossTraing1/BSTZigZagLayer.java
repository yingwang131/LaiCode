package CrossTraing1;

import java.util.*;



public class BSTZigZagLayer {

    static class TreeNode{
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int key){
            this.key = key;
        }
    }



    public List<Integer> zigZag(TreeNode root){
        //[1, 2, 5, 4, 3, 6, 7]
        if (root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.offerFirst(root);
        int layer = 0;
        while(!queue.isEmpty()){
            int size= queue.size();
            for (int i = 0; i < size; i++){
                if (layer == 0){
                    //this means even layer,偶数层，从右往左expand
                    // 从左边塞进他的right child，再塞进他的left child
                    TreeNode print = queue.pollLast();
                    list.add(print.key);
                    if (print.right != null){
                        queue.offerFirst(print.right);
                    }
                    if (print.left != null){
                        queue.offerFirst(print.left);
                    }
                }else{
                    //this means odd layer,基数层，从左往右expand
                    //从右边塞进他的left child，再从右边塞进他的right child
                    TreeNode print2 = queue.pollFirst();
                    list.add(print2.key);
                    if (print2.left != null){
                        queue.offerLast(print2.left);
                    }
                    if (print2.right != null){
                        queue.offerLast(print2.right);
                    }
                }
            }
            layer = 1-layer;
        }
        return list;

    }

    public List<Integer> zigZag2(TreeNode root) {

        // [1, 2, 3, 7, 6, 5, 4]
        // 因为laicode的顺序和老师上课讲的顺序不一样，即zigzag的起始不一样，但代码最后实现一样
        if (root == null){
            return new LinkedList<Integer>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                if (layer == 0){
                    // at even layer,from right to left;
                    TreeNode tmp = deque.pollLast();
                    list.add(tmp.key);
                    if (tmp.right != null){
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null){
                        deque.offerFirst(tmp.left);
                    }
                }else {
                    // add odd layer, from left to right
                    TreeNode tmp = deque.pollFirst();
                    list.add(tmp.key);
                    if (tmp.left != null){
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null){
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return list;
    }


    public static void main(String[] args) {
        BSTZigZagLayer sol = new BSTZigZagLayer();
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



        System.out.print(sol.zigZag(n1));
    }

}
