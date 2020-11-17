package OA;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayGame {
    //int[] array = {1,3,3,1,5}
    public String arrayGame(int[] input){
        if (input == null){
            return null;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int fast = 0;
        while (fast < input.length){
            int cur = input[fast];
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


    public String arrayGameStr(Integer[] array){
        if(array.length==1){
            return "Bob";
        }else{
            List<Integer> input=new ArrayList<>(Arrays.asList(array));
            int slow=0,fast=1;
            //设置一个标志
            boolean isAliceWin=true;
            int iteration=0;
            //连个连续的数字
            while(slow<fast&&fast<input.size()) {
                if (input.get(slow) == input.get(fast)) {
                    //移除
                    input.remove(slow);
                    input.remove(fast);

                    if (input.size() <= 1) {
                        if (iteration % 2 == 0) {//是Alice在操作
                            isAliceWin = true;
                        } else {
                            isAliceWin = false;
                        }
                        break;
                    }
                    //当前list元素个数大于等于2，两个指针复位，继续走
                    slow = 0;
                    fast = 1;
                    iteration++;
                } else {
                    slow++;
                    fast++;
                }
            }
            if(isAliceWin){
                return "Alice";
            }else{
                return "Bob";
            }
        }
    }

    public String removeParal(String input){
        if(input.length()<=1){
            return input;
        }else{
            int start=0,end=input.length()-1;
            boolean flag=true;
            while(input.length()>=2&&flag) {
                while (start < end) {
                    if (input.charAt(start) == input.charAt(end)) {
                        start++;
                        end--;
                    } else {
                        start=0;
                        end--;
                    }
                }
                int beginIndex=0;
                if (end < start) {
                    beginIndex=start +1;
                }
                if (end == start) {
                    beginIndex=2 * start +1;
                }
                if(beginIndex>=input.length()){
                    return "";
                }
                if(beginIndex<input.length()&&beginIndex>=2) {
                    input=input.substring(beginIndex);
                    //start,end复位
                    start = 0;
                    end = input.length() - 1;
                    flag=true;

                }else{
//                    input="";
                    flag=false;
                }
            }
            return input;

        }
    }

    //a a   a codedoc
            //codesignal

    public static void main(String[] args) {
        ArrayGame sol = new ArrayGame();
        Integer[] input = {1,2,2,3,3,1,1};
        Integer[] input1 = {1,3,3,1,5};
        System.out.println(sol.arrayGameStr(input1));
//        String str="aasignal";
//        System.out.println(sol.removeParal(str));

    }
}
