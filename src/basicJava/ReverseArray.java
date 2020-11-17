package basicJava;

import java.util.Arrays;

public class ReverseArray {
    /*
    public static void reverse(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }
        //reverse 有3中方法：1前后指针一起数，然后swap；2用一个倒序的for loop
        //倒序的for loop不就是哄人么，哪里有swap 原数组啊，就是按照倒序给打印了出来；

        for (int j = array.length-1; j >= 0; j--) {
            System.out.println(array[j]);

        }
    }

     */

    public static int[] reverse1(int[] array){
        int i = 0;
        int j = array.length -1;
        for (int index = 0; index < array.length; index++){
            while (i <= j){
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        ReverseArray sol = new ReverseArray();
        int[] array = {2,3,4,5};
//        reverse1(array);

        System.out.println(Arrays.toString(reverse1(array)));
//        reverse(array);

        }
}

