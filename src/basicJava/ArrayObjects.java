package basicJava;
import java.util.*;
public class ArrayObjects {
    public int min(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0){
            return 0;
        }
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public int sum(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    public static void swap(int[] array, int i, int j) {
        // Write your solution here
        if (array == null || array.length == 0){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }


    public static void main(String[] args){
        ArrayObjects sol = new ArrayObjects();
        int[] arr = {7,3,2};
        int i = 7;
        int j = 2;
//        System.out.println(sol.min(arr));
//        System.out.println(sol.sum(arr));


        /*
        print the swap function
         */
        int[] array = {7,3,2};
        // 把原始数组的每一个元素打印出来；
        for (int x:array
             ) {
            System.out.println(x);
        }

        //call swap function
        swap(array,1,2);
        for (int t = 0; t<array.length;t++){
            System.out.println("first way to print:" + array[t]);
            // 当call 完了swap function， 我们就可以把原来的array再loop 一遍,打印出来，因为我们调换了位置；
        }

        System.out.println("second way to print:" + Arrays.toString(array));



    }
}
