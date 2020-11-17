package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class ClosetInSortedArray {
    public int closet(int[] array, int target){
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        // 因为我不想让L or R 和mid 在同一个位置，因为这样会造成死循环，所以我要提前一步停下来 + post-processing
        while (left < right -1){
            int mid = left + (right - left)/2;
            if (array[mid] == target){
                return mid;
            }else if (array[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        //post processing
        if (Math.abs(array[left] - target) < (Math.abs(array[right]-target))){
            return left;
        }else{
            return right;
        }
    }

    public static void main(String[] args) {
        ClosetInSortedArray sol  = new ClosetInSortedArray();
        int[]array = {1, 4, 6};
        int target = 5;
        List<Integer> list = new ArrayList<>();
        System.out.println(sol.closet(array, target));
    }

}
