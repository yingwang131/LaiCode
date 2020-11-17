package Recursion1AndSortingAlgorithm;

import java.util.Arrays;

/*
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
 */
public class SelectionSort {
    public int[] solve(int[] array){
        if (array == null || array.length == 0){
            return array;
        }
        // 我需要做2步，1：找到最小值的minIndex 2： 用最小的minIndex 和 i swap， 扩大挡板
        for (int i = 0; i < array.length; i++){
            int minIndex = i;
            for (int j = i+1; j < array.length; j++){
                if (array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            swap(array,minIndex,i);
        }

        return array;
    }
    public void swap(int[]array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        SelectionSort sol = new SelectionSort();
        int[] array = {4, 2, -3, 6, 1};
        int[] result = sol.solve(array);
        System.out.println(Arrays.toString(result));
    }
}
