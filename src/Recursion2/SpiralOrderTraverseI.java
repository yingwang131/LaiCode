package Recursion2;

import java.util.ArrayList;
import java.util.List;

/*
{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
recursion 和二维的array结合
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        //offset的物理意义就是 从1开始，下一圈的循环是 1的右下角+1，也就是row +1，col+1；
        recurSpiral(matrix, 0, matrix.length, list);
        return list;
    }
    private void recurSpiral(int[][] matrix, int offset, int size, List<Integer> list){
        //recursion 的算法做起来还是简单一点，具体步骤看笔记，很容易理解，只要盯着例子走，就能写对
        //base case
        if (size == 0){
            return;
        }
        if (size == 1){
            list.add(matrix[offset][offset]);
            return;
        }
        for ( int i = 0; i < size -1; i++){
            list.add(matrix[0+offset][i+offset]);
        }
        for ( int i = 0; i < size -1; i++){ //
            list.add(matrix[i+offset][offset + size -1]);
        }
        for ( int i = size -1; i >= 1; i--){ //
            list.add(matrix[offset + size -1][i+offset]);
        }
        for ( int i = size -1; i >= 1; i--){ //
            list.add(matrix[i+offset][offset]);
        }
        recurSpiral(matrix, offset+1, size -2,list);
    }

    //method 2 Iterative traversal
    public List<Integer> spiral2(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int start = 0;
        int end = n -1;
        while (start < end){
            for (int i = start; i <= end; i++){ //start = 0， end =2；  代表要循环第0行，从第0行到第2列的元素都打印出来【1，2，3】
                list.add(matrix[start][i]);
            }
            for (int i = start+1; i <= end-1; i++){//start = 0， end =2；代表要循环第1行，即第一行第二列matrix【1】【2】=》6
                list.add(matrix[i][end]);
            }
            for (int i = end; i >= start; i--){//start = 0， end =2；代表要循环第二行，从第2行的第二列一直到第二行的第0列【9，8，7】
                list.add(matrix[end][i]);
            }
            for(int i = end -1; i>= start +1; i--){//start = 0， end =2；代表要循环的一行，即第一行第0列 matrix【1】【0】 ==》4
                list.add(matrix[i][start]);
            }
            start++; //START =1
            end--; //END =1
        }
        //if at last we have 1 element left, we need to traverse it as well
        if (start == end){ // 当start和end相等，打印matrix[1][1] =>4
            list.add(matrix[start][end]);
        }
        return list;

    }

    public static void main(String[] args) {
        SpiralOrderTraverseI sol = new SpiralOrderTraverseI();
        int[][] matrix = {
                {1,  2,  3},

                {4,  5,  6},

                {7,  8,  9}};
        System.out.println(sol.spiral2(matrix));
//        System.out.println(sol.spiral(matrix));
    }
}
