package Recursion2;


  class TreeNodeLeft {
    public int key;
    public TreeNodeLeft left;
    public TreeNodeLeft right;
    public int numNodesLeft;//所有子树的element
    public TreeNodeLeft(int key) {
      this.key = key;
    }
  }

public class StoreNumNodesInLeftsubT {
    public void numNodesLeft(TreeNodeLeft root) {

        numNodes(root);
    }
    private int numNodes(TreeNodeLeft root){
        if (root == null){
            return 0;
        }
        // 1: what do you expect from your lr child?
        int leftTotal = numNodes(root.left);
        int rightTotal = numNodes(root.right);

        // 2: what do you want to do in the current laryer?
        // 当前层的 report 上来的 left child 的1， 有可能不会被当前层 消耗掉，但是还是需要report，但是这个代码看不懂
        root.numNodesLeft = leftTotal;// root.它整个的子树的node个数，report给它的parent,不仅仅是只关心当前层的left sum
        // 3: return l + r+1
        return leftTotal + rightTotal + 1;
    }
}
