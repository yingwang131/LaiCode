package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets2 {
    public static void main(String[] args) {
        AllSubsets2 sol = new AllSubsets2();
        String set = "abc";
        System.out.println(sol.subSets(set));
    }

    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> list = new ArrayList<>();
        if (set == null){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        helper(set,0, sb, list);
        return list;
    }
    public void helper(String set, int index, StringBuilder sb, List<String>list){
        if (index == set.length()){
            list.add(sb.toString());
            return;
        }
        //如何通过代码把a给加到这个list里面？input是一个string，是不是先得把第一个字母取出来？
        sb.append(set.charAt(index));
        helper(set, index +1, sb, list);
        //在代码里面如何显示
        sb.deleteCharAt(sb.length() -1);

        //不加a
        helper(set,index+1, sb,list);
    }
}
