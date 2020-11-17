package String2;

import DFS.AllPermutation1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
移动有input层，每一层有input个元素
 */
public class AllPermutationsII {
    public List<String> permutations(String set){
        List<String> list = new ArrayList<>();
        if (set == null){
            return list;
        }
        char[] array = set.toCharArray();
        helper(array, 0, list);
        return list;
    }
    private void helper(char[] array, int index, List<String> list){
        if (index == array.length){
            list.add(new String(array));
            return;
        }
        //这里需要剪枝
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++){
            if (!used.contains(array[i])){
                used.add(array[i]);
                swap(array,i, index);
                helper(array, index+1,list);
                swap(array, i, index);
            }

        }
    }
    private void swap(char[] array, int left, int right){
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args) {
        AllPermutationsII sol = new AllPermutationsII();
        String input = "aba";
        System.out.println(sol.permutations(input));
    }
}
