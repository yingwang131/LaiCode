package CrossTraing2;

import java.util.Arrays;

public class FourSum {
    /*
    A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

    A = {1, 2, 2, 3, 4}, target = 12, return false
     */
    public boolean exist(int[] array, int target){
        //method1: n^3
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++){
            for (int j = i+1; j < array.length - 2; j++){
//                if (j > 0 && array[j] == array[j-1]){ //为什么4sum 就不需要像3sum那样的，
//                //因为现在是4sum，如果写了这个if，array数组有4个元素的话，直接就跳出循环返回false了
//                    continue;
//                }
                int left = j+1;
                int right = array.length -1;
                while (left < right){
                    int tmp = array[left] + array[right];
                    if (tmp + array[i] + array[j] == target){
                        return true;
                    }else if (tmp + array[i] + array[j] > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FourSum sol = new FourSum();
        int[]array = {1, 2, 2, 3, 4};
        int target = 12;
        int[]array1 = {1,1,1,1};
        int target1 = 4;
        System.out.println(sol.exist(array1, target1));

        /*
        for (int i = 0; i < 5; i++){
            if (i == 3){
                continue;
            }
            System.out.println(i + "");
        }

         */
    }
}
