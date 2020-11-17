package DFS;

/*
Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
0：一共有3层，每一层的物理意义是代表一个字母；每个节点有2个node，分别代表放或者不放；
1：画完图之后，还是一个recursion tree，所以
basecse，当我走到第3层的时候，我屁事都不用做，把加a不加a那条横线看成level，所以不能超过set的长度，set是3，index：有0123层
subproble，加A，不加A；加b不加b，。。。
recursion rule：合起来？
 */


import queueLinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets1 {
    public List<String> subSets(String set){
        List<String> list = new ArrayList<>();
        if (set == null){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        helper(set, sb,list, 0 );
        return list;
    }
    private void helper(String set, StringBuilder sb, List<String>list, int index_level){
        //index_level 就是我dfs的层数L0123，当数到第3层时，我什么都不用做了，完了
        if (index_level == set.length()){
            list.add(sb.toString());
            return;
        }
        //recursive rule:
        //case1：加a，加b，加c，把a加到sb里面去
        sb.append(set.charAt(index_level));
        helper(set, sb, list, index_level + 1 );
        sb.deleteCharAt(sb.length() - 1);//为了recursion tree返回时还是原来的数，保持物理意义

        //case2：不加a，b，c,所以也不用吐
        helper(set, sb, list, index_level+1);


    }

    public static void main(String[] args) {
        AllSubsets1 sol = new AllSubsets1();
        String set = "abc";
        System.out.println(sol.subSets(set));
    }
}
