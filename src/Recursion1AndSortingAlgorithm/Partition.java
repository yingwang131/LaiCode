package Recursion1AndSortingAlgorithm;

import java.util.Arrays;

/**
 * array = {9,4,6,2,0,1,7}
 *
 * pivotIndex = 2
 * Result: {1, 4, 0, 2, 6, 9, 7}
 */
public class Partition {
    public int[] partition(int[] array, int privotIndex){
        //1: pick up the pivot, 因为函数里面只给了一个int，并不是一个值，所以要选pivot值
        int pivot = array[privotIndex];
        //2:swap the pivot to the end of the array
        swap(array,privotIndex,array.length - 1 );
        //3:set up the i j, start to partition
        int i = 0;
        int j = array.length - 2;
        while (i <= j){
            if (array[i] > pivot){
                swap(array,i,j);
                j--;
            }else if (array[i] <= pivot){
                i++;
            }
        }
        swap(array, i, array.length - 1);
        //这里要注意不是swap（array, i , pivotInde),而是最后一个swap过去的pivot
        return array;
    }

    /**
     *
     * @param array
     * @param left
     * @param right
     */
    private void swap(int[]array, int left, int right){
        int tmep = array[left];
        array[left] = array[right];
        array[right] = tmep;
    }

    public static void main(String[] args) {
        Partition sol = new Partition();
        int[] array = {9,4,6,2,0,1,7};
        int privotIndex = 2;
        int[] result = sol.partition(array,privotIndex);
        System.out.println(Arrays.toString(result));

    }
}
