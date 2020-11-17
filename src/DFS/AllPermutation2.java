package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation2 {
    public static void main(String[] args) {
        AllPermutation1 sol = new AllPermutation1();
        String input = "";
        System.out.println(sol.permutations(input));
    }
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> list = new ArrayList<>();
        if (input == null){
            return list;
        }
        char[] array = input.toCharArray();
        helper(array, list, 0);
        return list;
    }
    public void helper(char[] array, List<String> list, int index){
        if (index == array.length){
            list.add(new String(array));
            return;
        }

        for ( int i = index; i < array.length; i++){
            swap(array, index, i);
            helper(array, list, index +1);
            swap(array, index,i);
        }
    }
    public void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
