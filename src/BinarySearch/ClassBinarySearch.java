package BinarySearch;

import java.util.Arrays;

public class ClassBinarySearch {
    public int binarySearch(int[] array, int target){
        if (array == null || array.length ==0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left <= right){
            int middle = left + (right - left)/2;
            //这个middle总是在变，所以不能放在while外面，放在为了外面的话，middle永远是index=2
            if (array[middle] == target){
                return middle;
            } else if (array[middle] > target){
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return -1;

    }
    public static void main(String[] args){
        ClassBinarySearch sol = new ClassBinarySearch();
        int[] array = {1, 2, 3, 4, 5};
        int target = 4;
        System.out.println(sol.binarySearch(array,target));

    }
    //time:logn
    //space:o1

}
