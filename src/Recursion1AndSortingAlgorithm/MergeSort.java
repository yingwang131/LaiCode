package Recursion1AndSortingAlgorithm;

import java.util.Arrays;

public class MergeSort {
    /*
    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
     */
    //1： 先分成2个数组，2：把分开的2个数组分别用递归的方式sort好 3：再把2个数组合起来，谁小移动谁
    public int[] mergeSort(int[] array){
        if (array == null || array.length == 0){
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, 0, array.length - 1,helper);
        return array;
    }
    private void mergeSort(int[] array, int left, int right, int[] helper){
        if (left >= right){
            return;
        }
        //1:
        int mid = left + (right - left)/2;
        //2:
        mergeSort(array,left, mid, helper);
        mergeSort(array,mid+1,right, helper);
        //3: 2个数组合起来，谁小移动谁，left side empty, stop; right side empty, explicty copy
        for (int i = left; i <= right; i++){
            helper[i] = array[i];
        }
        int k = left, i = left, j = mid+1;
        while (i <= mid && j <= right){
            if (helper[i] <= helper[j]){
                array[k] = helper[i];
                i++;
                k++;
            }else{
                array[k] = helper[j];
                j++;
                k++;
            }
        }
        while (i <= mid){
            array[k] = helper[i];
            i++;
            k++;
        }

    }





    public static void main(String[] args) {
        MergeSort sol = new MergeSort();
        int[] array = {4, 2, -3, 6, 1};
        System.out.println(Arrays.toString(sol.mergeSort(array)));
    }


}
