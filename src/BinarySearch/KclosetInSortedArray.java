package BinarySearch;

import java.util.Arrays;
/*
A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */
public class KclosetInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        //1: find the target using binary search
        //2: 提前一步结束，用|left- target|<=|right-target|
        //3: 找到target后，要用中心开花，谁小移动谁,中心开花谁小移动谁，要小心那个if的判断条件，把左右边界和绝对值都要包括进去
        if (array == null || array.length == 0) {
            return array;
        }
        int left = closedInSortedArray(array,target);
        int right = left + 1;
//        int[] result = new int[]{k}; //写在{}里面的是赋值，所以当我给i付了一个k值后，后面的i就加不进去了，因为没有位置了；
        // 这里是分配空间，我们并不知道 k的具体内容是什么，所以只负责分配空间不负责赋值；
        int[] result = new int[k];// 这一句是分配了长度是5的数组，但是没有赋值
        for (int i = 0; i < k; i++){
            if (right >= array.length ||

                    (left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target))){
                result[i] = array[left];
                left--;
            } else {
                result[i] = array[right];
                right++;
            }
        }
        return result;
    }
    public int closedInSortedArray(int[] array, int target){
            int left = 0;
            int right = array.length - 1;
            while (left < right - 1){
                int mid = left + (right - left)/2;
                if (array[mid] < target){
                    left = mid;
                } else if (array[mid] > target){
                    right = mid;
                } else{
                    return mid;
                }
            }
            //post-processing
            if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)){
                return left;
            } else{
                return right;
            }
    }

    public static void main(String[] args) {
        KclosetInSortedArray sol = new KclosetInSortedArray();
        int[] array = {1,5};
        int target = 10;
        int k = 1;
        int res[] = sol.kClosest(array,target,k);
        System.out.println(Arrays.toString(res));
    }


}
