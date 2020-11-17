package DP2;

/*
{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1
//base case M[0] = array[0]
        //induction rule: if(M[i-1] >= 0); M[i-1] + array[i];
        //                if (M[i-1] <0 )是负数的话，要东山再起； array【i】
 */
public class LargestSubArraySum {
    public int largestSum(int[] array){

        if(array == null || array.length == 0){
            return 1;
        }
        //base case
        int result = array[0];
        int gloMax = array[0];
        for (int i = 1; i < array.length; i++){
            if (result >= 0){
                result+= array[i];
            }else {
                result = array[i];
            }
            gloMax = Math.max(result, gloMax);
        }
        return gloMax;
    }
}
