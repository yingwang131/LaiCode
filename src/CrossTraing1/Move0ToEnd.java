package CrossTraing1;

import java.util.Arrays;

public class Move0ToEnd {
    //快慢指针，string里面的trick,可以保证相对顺序
    // [1, 9, 8, 4, 2, 7, 0, 0, 0]
    public int[] moveZero(int[] array){
        if(array.length <= 1){
            return array;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++){
            if (array[fast] == 0){
                continue;
            }else {
                array[slow++] = array[fast];
            }
        }
        //还得来个post-processing 把后面的0给补上, append 0 untill s == f
        for (int i = slow; i < array.length; i++){
            array[i] = 0;
        }
        return array;
    }

    public int[] moveZero2(int[] array) {
        // 水油分离，privot，2 pointers move in opposite direction，quickSort 里面的trick
        //[1, 9, 8, 4, 7, 2, 0, 0, 0]，不能保证相对顺序；
        if (array == null || array.length == 0){
            return array;
        }
        int i = 0;
        int j = array.length -1;
        while (i <= j){
            if (array[i] != 0){
                i++;
            }else {
                swap(array, i, j);
                j--;
            }
        }
        return array;
    }
    public void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        Move0ToEnd sol = new Move0ToEnd();
        int[] array = {1,9,8,4,0,0,2,7,0};
        System.out.println(Arrays.toString(sol.moveZero(array)));
    }
}
