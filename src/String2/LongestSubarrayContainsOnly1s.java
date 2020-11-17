package String2;

import java.util.Map;
/*
Input: array = [1,1,0,0,1,1,1,0,0,0], k = 2

Output: 7
solution: it is actually a sliding window problem. The window can contain
at most K zeros in the window. 注意：这个题目和 0是不是连在一起没有关系，0在哪里我都会去找最长的1，多么妙呢？
 */
public class LongestSubarrayContainsOnly1s {
    public int longestConsecutiveOnes(int[] nums, int k){
        int slow = 0;
        int fast = 0;
        int count = 0;
        int longest = 0;
        while (fast < nums.length){
            if (nums[fast] == 1){
                longest = Math.max(longest, ++fast - slow);
            }else if (count < k){
                count++;
                longest = Math.max(longest, ++fast - slow);

            }else if (nums[slow++] == 0){
                count--;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubarrayContainsOnly1s sol = new LongestSubarrayContainsOnly1s();
        int[]nums = {0,1,1,0,1,1,0,1,1,0};
        int[]nums1 = {1,1,0,0,1,1,1,0,0,0};
        int k = 2;
        System.out.println(sol.longestConsecutiveOnes(nums1, k));



    }
}
