package basicJava;

import java.util.Arrays;

public class SwapFunction {
    public static void swap(int[]array, int a, int b){
        if (array == null || array.length ==0){
            return;
        }
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void  main (String[] args){
        int[]array = {7,3,2};
        System.out.println("before swap: " + Arrays.toString(array));
        swap(array, 1,2);
        System.out.println("after swap: "+Arrays.toString(array));
    }
}
