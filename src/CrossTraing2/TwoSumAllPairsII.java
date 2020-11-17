package CrossTraing2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]] 涉及的是一个素组； 1：2个指针相像而行的一定是排好序的数组，因为只有排好序的数组
arr[I] + arr[J] > target；才j--， 因为j 右边的数组一定更大，所以要j--
 */
public class TwoSumAllPairsII {
    public List<List<Integer>> allPairs(int[] array, int target){
        //array is not null, length greater than 2
        // sort first
        // 题目里面还涉及了要处理duplicate
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = array.length -1;
        while (i < j){
            // 这里要想想如何去除重复的元素
            if (i > 0 && array[i] == array[i-1]){
                i++;
                continue; // 跳出while 这个循环，从下一个iteration开始
            }
            int cur = array[i] + array[j];
            if (cur == target){
                result.add(Arrays.asList(array[i], array[j]));
                i++;
                j--;
            }else if (cur < target){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumAllPairsII sol = new TwoSumAllPairsII();
        int[] array = {1,2,3,5,7,8};
        int[] array1 = {3,5,3,2,4,4};
        int[] array2 = {1,1,1,1,1};
//        System.out.println(sol.allPairs(array,8));
//        System.out.println(sol.allPairs(array1, 7));
        System.out.println(sol.allPairs(array2,2));
    }
}
