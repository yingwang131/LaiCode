package Recursion1AndSortingAlgorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
 */
public class QuickSort {
    public int[] quickSot(int[] array){
        if (array == null || array.length == 0){
            return array;
        }
        quickSort(array,0,array.length - 1);
        return array;
    }
    public void quickSort(int[]array,int left, int right){
        //base case:
        if (left >= right){
            return;
        }
        //1:random pick up the pivot
        Random rand = new Random();
        int pivot = rand.nextInt(right - left + 1)+left;
        //2:swap the pivot to the right most，如果pivot 是1，swap的是index为1的元素，但swap里面传的是index；【15342】
        swap(array, pivot, right);
        //3: set up i and j
        int i = left;
        int j = right - 1;
        while (i <= j){
            if (array[i] > array[right]){
                //注意：这里永远是array[i] 和 pivot 比较，但privot 已经被我放到最右边了，必须是array[right]
                // 如果写 > pivot ，这个pivot指的是一个index 在几号元素，不是实际的元素哦
                swap(array, i,j);
                j--;
            }else{
                i++;
            }
        }
        swap(array, right, i);//这里最终换的也是 i 和 pivot 换，但是在swap函数里面都是index，把i写成privot的下场就是，i=0，pivot=0，自己和自己换了，啥用没有
        quickSort(array, left, i-1);
        quickSort(array,i+1, right);
    }
    private void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        QuickSort sol = new QuickSort();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(sol.quickSot(array)));
    }
}
