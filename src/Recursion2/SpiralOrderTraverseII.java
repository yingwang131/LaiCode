package Recursion2;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        // apiral order traverse 1 是3行3列，但这个题目是 3行4列；稍微变一下，变哪里呢？
        List<Integer> list = new ArrayList<>();
        // assume: matrix is not null, has size of M*N, mn >= 0
        int m = matrix.length;
        // need to handle if m==0, matrix[0].length will throw ArrayIndexoutofBound
        if (m == 0){
            return list;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        // the base case is complicated comparing to N*N matrix
        // 1: there is nothing left
        // 2: there is one row left
        // 3: there is one column left
        while (left < right && up < down){
            for (int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down -1; i++){
                list.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--){
                list.add(matrix[down][i]);
            }
            for (int i = down -1; i >= up + 1; i--){
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        //1
        if (left > right || up > down){
            return list;
        }
        //2
        if (left == right){
            for (int i = up; i <= down; i++){
                list.add(matrix[i][left]);
            }
        }else{
            //3
            for (int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        SpiralOrderTraverseII sol = new SpiralOrderTraverseII();
        int[][] matrix = {
                {1,  2,  3,  4},

                {5,  6,  7,  8},

                {9, 10, 11, 12}};
        System.out.println(sol.spiral(matrix));
//        System.out.println(sol.spiral(matrix));
    }
}
