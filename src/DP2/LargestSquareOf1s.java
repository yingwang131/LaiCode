package DP2;

import javax.print.MultiDocPrintJob;

/*
basecase: M[i][j] represents the max.length of square, i,j as the bottom-right corner
induction rule:
M[i][j] = 1+ min(M[i-1][j-1], M[i-1][j],M[i][j-1]) if A[i][j] == 1
    0                                              otherwise
 */
public class LargestSquareOf1s {
    public int largest(int[][] matrix){
        int N = matrix.length;
        if (N == 0){
            return 0;
        }
        int result = 0;
        int[][] sides = new int[N][N];
        for ( int i = 0; i < N; i ++){
            for (int j = 0; j < N; j++){
                if (i == 0 || j == 0) { // 看到任何0，都是返回0
                    sides[i][j] = matrix[i][j] == 1 ? 1 : 0;

                }else if (matrix[i][j] == 1){
                    sides[i][j] = 1 + min(sides[i-1][j-1], sides[i-1][j],sides[i][j-1]);

                }
                result = Math.max(result, sides[i][j]);
            }

        }
        return result;

    }
    private int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }

    public int largest2(int[][] matrix) {
        // Write your solution here
        int N = matrix.length;
        if (N == 0){
            return 0;
        }
        int result = 0;
        int[][] largest = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j =0; j < N; j++){
                if (i ==0 || j == 0){
                    if (matrix[i][j] == 1){
                        largest[i][j] = 1;
                    }else {
                        largest[i][j] = 0;
                    }
                } else if (matrix[i][j] == 1){
                    largest[i][j] = Math.min(largest[i-1][j-1]+1, largest[i-1][j]+1);
                    largest[i][j] = Math.min(largest[i][j-1]+1, largest[i][j] );
                }
                result = Math.max(result, largest[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestSquareOf1s sol = new LargestSquareOf1s();
        int[][]matrix = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},};
        System.out.println(sol.largest(matrix));
    }
}
