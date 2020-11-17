package DP2;

import java.util.Arrays;

/*
{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5. The indices of the left and right boundaries are 0 and 2, respectively.

{-2, -1, -3}, the largest subarray sum is -1. The indices of the left and right boundaries are both 1


Return the result in a array as [sum, left, right]
 */
public class LargestSubArraySumII {
    public int[] largestSum(int[] array){
        int[] result = new int[array.length];
        //base case
        result[0] = array[0];
        int curLeft = 0;
        int gloLeft = 0;
        int gloRight = 0;
        int gloMax = array[0];
        for (int i = 1; i < array.length; i++){
            if (result[i -1] < 0){
                result[i] = array[i];
                curLeft = i;
            }else {
                result [i] = array[i] + result[i-1];
            }
            if (result[i] > gloMax){
                gloMax = result[i];
                gloLeft = curLeft;
                gloRight = i;
            }
        }
        int[] finalResult = {gloMax, gloLeft, gloRight};
        return finalResult;
    }

    public static void main(String[] args) {
        LargestSubArraySumII sol = new LargestSubArraySumII();
        int[] array = {1};
        System.out.println(Arrays.toString(sol.largestSum(array)));
    }
}
