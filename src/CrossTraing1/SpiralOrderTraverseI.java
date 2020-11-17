package CrossTraing1;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        //recursion rule: 分成4圈，每一个for 循环一个圈
        List<Integer> list = new ArrayList<>();
        return spiralRec(matrix, 0, matrix.length, list);

    }
    //注意，如果不知道要不要写返回值式，如果写了，那就得保证所有corner case都要过

    public List<Integer> spiralRec(int[][] matrix, int offsite, int size, List<Integer> list) {
        //recursion way: 1 base case: 只有一个的时候；
        if (size == 0) {
            return list;
        }
        if (size == 1) {
            list.add(matrix[offsite][offsite]);
            return list;

        }
        for (int i = 0; i < size - 1; i++) {
            list.add(matrix[0 + offsite][i + offsite]);

        }
        for (int i = 0; i < size - 1; i++) {
            list.add(matrix[i + offsite][offsite + size - 1]);

        }
        for (int i = size - 1; i >= 1; i--) {
            //2,2 21
            list.add(matrix[offsite + size - 1][i + offsite]);
        }
        for (int i = size - 1; i >= 1; i--) {
            //20, 10
            list.add(matrix[i + offsite][offsite]);
        }
        //这里要转换位置，把数字1 跳到数字5，
        spiralRec(matrix, offsite + 1, size - 2, list);
        return list;

    }

    public static void main(String[] args) {
        SpiralOrderTraverseI sol = new SpiralOrderTraverseI();
        int[][] matrix = {
                {-16, 5, 33, 36},

                {-17, 4, 91, -52},

                {9, -15, -40, 77},

                {15, 55, 8, -87}};
//        System.out.println(sol.spiral2(matrix));
        System.out.println(sol.spiral(matrix));
    }
}

    /* 那总结一下：要写返回值，什么时候不需要返回值呢？
       //如果我要写成64行，这个return 连个方法名，那我在下面的这个方法必须要有相同type的返回值
      public List<Integer> spiral(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        return spiralRec(matrix, 0, matrix.length, list);
      }

       public List<Integer> spiralRec(int[][]matrix, int offsite, int size, List<Integer> list){
        if (size == 0){
            return list;
        }
        if (size == 1){
            list.add(matrix[offsite][offsite]);
            return list;
        }
       }

     */
    /*
    //如果我要写成85行，return 和方法名分开写，那我在下面的这个方法可以是void，90，94行都直接写return；
    public List<Integer> spiral(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        spiralRec(matrix, 0, matrix.length, list);
        return list;
      }

       public void spiralRec(int[][]matrix, int offsite, int size, List<Integer> list){
        if (size == 0){
            return;
        }
        if (size == 1){
            list.add(matrix[offsite][offsite]);
            return;
        }
       }
     */


