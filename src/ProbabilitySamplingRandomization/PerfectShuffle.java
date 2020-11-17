package ProbabilitySamplingRandomization;

import java.util.Random;

public class PerfectShuffle {
    //shuffle:随机打乱的定义：每一种排列顺序的概率都相等，52张牌的全排列是52！，每一个牌的概率是1/52!
    public void shuffle(int[] array){
        if (array.length <= 1){
            return;
        }
        // from right to left
        //for index i-1, random pick one of the first i elements
        for (int i =  array.length; i >= 1; i--){
            int j = (int)(Math.random() * i);
            swap(array, i-1, j);
        }
    }

    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        PerfectShuffle sol = new PerfectShuffle();
        int[]array = {5,2,3,0,2};
        sol.shuffle(array);
    }


}
