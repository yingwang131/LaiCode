package CrossTraing1;

import java.util.Arrays;

/*
{2, 1, 5, 4, 3},
the largest number is 5 and smallest number is 1. return [5, 1]
Solution 2：
1：每2个切一刀  1 2 | 4 3 | 6 5 | 8 7|
2：1 和2 比，4 和3 比，6和5比，8和7比
first round：n/2
small：1 3 5 7     →  the global min must be here
large： 2 4 6 8    ->   the global max must be here

find the global min in the small set ⇒ N/2
find the global max in the large set => N/2
the total number of comparisons = 3n/2 = 1.5n;

 */
public class largestAndSmallest {

    public int[] largestAndSmallest(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        //每2个切一刀，把大的放在左边，小的放右边；我也可以实现一个大的放右边，小的放左边；
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                swap(array, i, n - 1 - i);
            }
        }
        //the largest value should be the largest of the left half
        //the smallest value should be the smallest of the right half
        return new int[]{largest(array, 0, (n-1)/2), smallest(array, n/2, n-1)};
    }
    private int largest(int[] array, int left, int right) {
        int largest = array[left];
        for (int i = left+1; i <= right; i++) {
            largest = Math.max(largest, array[i]);
        }
        return largest;
    }

    private int smallest(int[] array, int left, int right){
        int smallest = array[left];
        for (int i = left + 1; i <= right; i++){
            smallest = Math.min(smallest, array[i]);
        }
        return smallest;
    }

    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        largestAndSmallest sol = new largestAndSmallest();
        int[] array = {2,1,5,4,3};
        System.out.println(Arrays.toString(sol.largestAndSmallest(array)));
        System.out.println(5/2);
    }
}
