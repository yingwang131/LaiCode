package CrossTraing2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
 */
public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++){ //为什么这个右边界是array.length -2 呢,因为是3个数组的和
            if (i > 0 && array[i] == array[i-1]){//在这里这么写是因为3sum 需要i不要再重复的数字上循环
                continue;
            }
            // 如果能让 left 的index 总是比 i 的index 大，那就可以避免因为循环i而出现相同的数组了
            int left = i+1;
            int right = array.length - 1;
            while (left < right) {
                int tmp = array[left] + array[right];
                if (tmp + array[i] == target){
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    //在这里实现去重
                    while (left < right && array[left] == array[left - 1]){
                        left++;
                    }
                }else if (tmp + array[i] > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int[] array = {1,2,2,3,2,4};
        int target = 8;
        int[] array1 = {3,4,0,-1,2,0,5};
        int target1 = 5;
        System.out.println(sol.allTriples(array1, target1));
    }
}
