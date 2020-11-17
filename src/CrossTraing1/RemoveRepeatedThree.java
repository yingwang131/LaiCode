package CrossTraing1;

import java.util.Arrays;

/*
{1, 2, 2, 3, 3, 3} → {1}
 */
public class RemoveRepeatedThree {
    public int[] dedup(int[] array) {
        if (array == null || array.length <= 1){
            return array;
        }
        int slow = 0;
        int fast = 0;
//        int fnext = fast+1; 这里直接开始写是不对的，会outofbount，因为没有check fast 必须要小于length
//        while (fnest < array.length && array[fnext] == array[fast]){
//            fnext++;
//        }
        while (fast < array.length) { // 所以再包一个while，大while负责fast 不出界
            int fnext = fast+1;

            while (fnext < array.length && array[fnext] == array[fast]) {
                //小while负责fnext 不出界，因为都是fnext， 和fast 在嗖嗖往前跑；
                fnext++;
            }

            //fnext is the first element that doesn't equal to a[f]
            if (fnext - fast == 1) {
                array[slow++] = array[fast++];
            } else {
                fast = fnext;
            }
        }
        return Arrays.copyOf(array, slow);

    }

    public static void main(String[] args) {
        RemoveRepeatedThree sol = new RemoveRepeatedThree();
        int[] array = {1,2,2,3,3,3};
        int[] array2 = {1,1,1};
        System.out.println(Arrays.toString(sol.dedup(array2)) );
    }
}
