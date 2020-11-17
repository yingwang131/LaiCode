package Recursion1AndSortingAlgorithm;

import java.util.Arrays;

/**
 * {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
 */
public class RainbowSort {
    public int[] rainbowSort(int[] array){
        if (array == null || array.length == 0){
            return array;
        }
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < array.length; i++){

            if (array[i] == -1){
                count1++;
            }else if (array[i] == 0){
                count2++;
            }else{
                count3++;
            }
        }
        //把每一个count打印出来，比如有1个-1 ，2个1，2个0，分别再拷贝的array里面；但如何打印出来count呢
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

//        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < count1; i++) {
            array[i] = -1;
        }
        for (int j = 0; j < count2; j++){
            array[j] = 0;
        }
        for (int y = 0; y < count3; y++){
            array[y] = 1;
        }


//        System.out.println(list);
        return array;

    }

    public int[] rainbowSort1(int[] array){
        if (array == null || array.length == 0){
            return array;
        }
        //还是用挡板的思想；有三个要区分的元素，所以是3个挡板，4 个区域；
        int i = 0, j = 0, k = array.length - 1;
        while(j <= k){
            if (array[j] == -1){
                swap(array,i,j);
                i++;
                j++;
            }else if (array[j] == 0){
                j++;
            }else {
                swap(array,j,k);
                k--;
            }
        }
        return array;
    }

    public void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        RainbowSort sol = new RainbowSort();
        int[] array = {1, 0, 1, -1, 0};
        int[] res = sol.rainbowSort1(array);
        System.out.println(Arrays.toString(res));


    }


}
