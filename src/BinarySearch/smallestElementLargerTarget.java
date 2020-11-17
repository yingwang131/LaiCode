package BinarySearch;
/*
A = {1, 2, 3}, T = 1, return 1

A = {1, 2, 3}, T = 3, return -1
A = {1, 2, 2, 2, 3}, T = 1, return 1， 这个题目和first target很像，不是和closet target相似
 */

public class smallestElementLargerTarget {
    public int smallestElementLargerThanTarget(int[] array, int target){
        // 1 find the target by using first occurance
        // 2 when mid == target, 不能直接返回mid，因为这样就不能post-processing了，若left = mid，可以继续post-processing
        // 3 post-processing, array[left]>target, return left
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1){
            int mid = left + (right - left)/2;
            if (array[mid] < target){
                left = mid;
            }else if (array[mid] > target){
                right = mid;
            } else {
                // 如果这里我直接return mid 了，说明我直接就结束了，如果我返回left = mid，程序还可以走到下面的post-processing去
                // check一下 返回最小的元素大于target；
                 left = mid;
            }
        }
        if (array[left] > target){
            return left;
        }else if (array[right] > target){
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        smallestElementLargerTarget sol = new smallestElementLargerTarget();
        int[] array = {10,16,17,18,26,28,30,33,35,36,38,41,42,46,49,54,58,60,63,64};
        int target = 30;
        System.out.println(sol.smallestElementLargerThanTarget(array,target));
    }
}
