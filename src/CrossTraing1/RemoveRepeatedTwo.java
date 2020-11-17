package CrossTraing1;

import java.util.Arrays;

public class RemoveRepeatedTwo {
    public int[] dedup(int[] array) {
        if (array == null){
            return null;
        }
        if (array.length <= 1){
            return array;
        }
        int slow = 2;
        int fast = 2;
        while (fast < array.length){
            if (array[fast] != array[slow-2]){
                array[slow++] = array[fast++];
            }else {
                fast++;
            }
        }
        return Arrays.copyOf(array,slow);
    }

    //也可以改成for，改for 我比较喜欢，但是昨天死心眼，以为只有while才能不多加fast
    public int[] dedup2(int[] array) {
        if (array == null){
            return null;
        }
        if (array.length <= 1){
            return array;
        }
        int slow = 2;

        for (int fast = 2;  fast < array.length; fast++){
            if (array[fast] == array[slow-2]){
                continue;

            }else {
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOf(array,slow);
    }

    public static void main(String[] args) {
        RemoveRepeatedTwo sol = new RemoveRepeatedTwo();
        int[] array = {1, 2, 2,2,3, 3, 3, 3};
        System.out.println(Arrays.toString(sol.dedup2(array)));
    }
}
