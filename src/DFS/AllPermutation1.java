package DFS;

/*
Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

Set = "", all permutations are [""]
一共有3层，每一层代表一个position，这个position指的是挡板，也是层数
每一个node 可以伸出 n-1个孩子，只要这个孩子还没被叫过
 */

import java.util.ArrayList;
import java.util.List;

public class AllPermutation1 {
    public List<String> permutations(String input){
        List<String> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        //将字符串，转化为字符数组toCharArray()
        char[] array = input.toCharArray();
        helper(array, result, 0);
        return result;
    }
    public void helper(char[] array , List<String> result, int index){
        //base case
        if (index == array.length){
            result.add(new String(array));
            return;
        }

        //recursion rule
        for (int i = index; i < array.length; i++){
            swap(array, index, i );
            helper(array, result, index+1);
            swap(array, index,i);
        }


    }
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        AllPermutation1 sol = new AllPermutation1();
        String input = "abc";
        System.out.println(sol.permutations(input));

        char[]c = {'a','b','b','c'};
        System.out.println(c[3]);

    }
}
