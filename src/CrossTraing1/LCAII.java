package CrossTraing1;



/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 */
public class LCAII {
    //There is parent pointer for the nodes in the bst
    //这个题目上课讲的最后一个题5.7有parents pointer，
    //step1：compute the depth of a and the depth of b
    //move a b up untill a and b on the same level
    //move a and b up together untill they meet
    static class TreeNodeP{
        public int key;
        public TreeNodeP left;
        public TreeNodeP right;
        public TreeNodeP parent;
        public TreeNodeP(int key, TreeNodeP parent){
            this.key = key;
            this.parent = parent;
        }
        public String toString() {
            return Integer.toString(key);
        }
    }

    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        int lshort = length(one);
        int llong = length(two);
        if (lshort <= llong){
            return mergeNode(one, two, llong - lshort);
        } else{
            return mergeNode(two, one, lshort - llong);
        }
    }

    private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff){
        while (diff > 0 ){
            longer = longer.parent;
            diff--;
        }
        while (longer != shorter){
            longer = longer.parent;
            shorter = shorter.parent;
        }
        return longer;
    }
    private int length(TreeNodeP node){
        int length = 0;
        while (node != null){
            length++;
            node = node.parent;
        }
        return length;
    }

    public static void main(String[] args) {
        LCAII sol = new LCAII();
        TreeNodeP n1 = new TreeNodeP(5, null);
        TreeNodeP n2 = new TreeNodeP(9,n1);
        TreeNodeP n3 = new TreeNodeP(12,n1);
        TreeNodeP n4 = new TreeNodeP(2, n2);
        TreeNodeP n5 = new TreeNodeP(3,n2);
        TreeNodeP n6 = new TreeNodeP(14,n3);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(sol.lowestCommonAncestor(n4,n2).toString());
//        System.out.println(sol.lowestCommonAncestor(n4,n6));
    }

}
