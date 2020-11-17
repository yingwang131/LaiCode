package OA;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayGameAlice {
    //int[] array = {1,3,3,1,5}
    public String arrayGame(String a){
        char[] input = a.toCharArray();
        if (a.isEmpty()){
            return a;
        }
        Deque<Character> stack = new ArrayDeque<>();
        int fast = 0;
        while (fast < input.length){
            char cur = input[fast];
            if (!stack.isEmpty() && stack.peekFirst() == cur){
                while (fast < input.length && input[fast] == cur){
                    fast++;
                }
                stack.pollFirst();
            }else {
                stack.offerFirst(cur);
                fast++;
            }
        }
        int len = stack.size();
        for ( int i = len -1; i >= 0; i--){
           input[i] = stack.pollFirst();
        }
        return new String(input, 0, len);

    }

    public static void main(String[] args) {
        ArrayGameAlice sol = new ArrayGameAlice();
        String a = "13315";
        String a1 = "1223311";
        System.out.println(sol.arrayGame(a1));
    }
}
