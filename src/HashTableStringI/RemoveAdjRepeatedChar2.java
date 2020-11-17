package HashTableStringI;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjRepeatedChar2 {
    public String deDup(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        if (input == null || input.length() <=1){
            return input;
        }
        // if (input == null ){
        //   return input;
        // }
        // if (input.isEmpty()){
        //   return input;
        // }
        int j = 0;
        while (j < input.length()){
//            System.out.println(stack.peekFirst());
            if (!stack.isEmpty() && array[j] == stack.peekFirst()){
                char tmp = array[j];
                while(j < array.length&& array[j] == tmp){
                    j++;
                }
                stack.pollFirst();
            }else{
                stack.offerFirst(array[j]);
                j++;
            }
        }
        int len = stack.size();
        for (int i = len -1;i >=0; i--){
            array[i] = stack.pollFirst();
        }
        return new String(array, 0, len);
    }
    public static void main(String[] args) {
        RemoveAdjRepeatedChar2 sol = new RemoveAdjRepeatedChar2();
        String input = "abbbbaaazwy";
        String input2 = "a";
        String input3 = "aababab";
        String input4 = "abccde";
        System.out.println(sol.deDup(input4));


    }
}
