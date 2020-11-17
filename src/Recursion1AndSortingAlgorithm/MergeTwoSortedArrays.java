package Recursion1AndSortingAlgorithm;

/*
array1 = {3,7}
array2 = {1,6,8,9}
answer = {1,3,6,7,8,9}
 */


import java.util.Arrays;

public class MergeTwoSortedArrays {
    public int[]merge (int[]one, int[]two){
        //先占上坑，输出的是6 个 0；
        int[] array = new int[one.length + two.length];
        int i = 0; int j = 0; int k = 0;
        while (i < one.length && j < two.length){
            if (one[i]>= two[j]){
                array[k] = two[j];
                j++;
                k++;
            }else{
                array[k] = one[i];
                i++;
                k++;
            }
        }
        // if we still have elements in the left side, we need explict copy them
        while (j < two.length){
            array[k] = two[j];
            j++;
            k++;
        }
        // if we still have elements in the left side, we need explict copy them
        while (i < one.length){
            array[k] = one[i];
            i++;
            k++;
        }
        return array;
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays sol = new MergeTwoSortedArrays();
//        int[] one = {3,7};
//        int[] two = {1,6,8,9};
        int[] two = {3,7};
        int[] one = {1,6,8,9};
        int[] res = sol.merge(one, two);
        System.out.println(Arrays.toString(res));
    }
}
