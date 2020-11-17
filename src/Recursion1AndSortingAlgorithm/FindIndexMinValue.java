package Recursion1AndSortingAlgorithm;

/*
array = {1, 9, 6, 8, 7}, i = 1 ⇒ return 2

array = {0, 3, 9, 8, 5, 4}, i = 2 ⇒ return 5
 */
public class FindIndexMinValue {
    public int minIndex(int[] array, int i) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int minIndex = i;

        for (int j = i + 1; j < array.length; j++){
            // 一定要小心这里，因为初始化的minIndex = i；
            // 但是在for loop里面，每一个iteration 后，是要和找到最小的array【minIndex】来相比较，而不是每次都和初始化的minIndex比较
            // 在for loop里面的minIndex 变化的 minIndex = j；
            if (array[minIndex] > array[j]){
                minIndex = j;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        FindIndexMinValue sol = new FindIndexMinValue();
        int[] array = {1, 9, 6, 8, 7};
        int i = 1;
        System.out.println(sol.minIndex(array, i));
    }
}
