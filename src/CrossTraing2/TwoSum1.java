package CrossTraing2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4) 这个题目return的是true false 并且数组是没有排过序的
 */
public class TwoSum1 {
    // 「assumed the array is unsorted」
    public boolean existSum(int[] array, int target){
        Set<Integer> set = new HashSet<>();
        //这里的num到底是个啥？这个num是一个变量，这个变量就是array里面的每一个元素。用for loop 去循环array里面的每一个元素
        for (int num: array){
            if (set.contains(target - num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean existSum2(int[] array, int target){
        Arrays.sort(array);
        int i = 0;
        int j = array.length-1;
        //termination condition when i >= j should stop
        while (i < j){
            int sum = array[i] + array[j];
            if (sum == target){
                return true;
            }else if (sum > target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum1 sol = new TwoSum1();
        int[] array = {3,2};
        int[] array1 = {3,4,0,-1,2,0,5};
//        System.out.println(sol.existSum(array, 6));
        System.out.println(sol.existSum2(array1, 10));
    }
}
