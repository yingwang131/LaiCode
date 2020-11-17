package DP3;

/*
basecase:
step1: 对于left-》right， right-》left， top-》bottom， buttom-》top做最长的连续的1 的做法求出边长
step2：M[i][j] = min(M1[i][j], M2[i][j], M3[i][j], M4[i][j])
       return global_max among all M[i][j]
induction rule:
 */
public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        int[][] right = new int[row][col];
        int[][] up = new int[row][col];
        int[][] down = new int[row][col];
        int max = 0;

        //从左到右跑, 每一个都是一个独立的dp，并且每一个独立的dp里面有它自己的 basecase
        for (int i = 0; i < row; i++) {
            //left[0][0] = matrix[0][0],left 指的是这个left 二维数组的 i行 0列，matrix i行，0列
            left[i][0] = matrix[i][0];
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }

        //从右到左跑
        for (int i = 0; i < row; i++) {
            //right[0][3] = matrix[0][3]，basecase
            right[i][col - 1] = matrix[i][col - 1];
            for (int j = col - 2; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }

        //从上往下跑
        for (int j = 0; j < col; j++) {
            //basecase
            up[0][j] = matrix[0][j];
            for (int i = 1; i < row; i++) {
                if (matrix[i][j] == 1) {
                    up[i][j] = up[i - 1][j] + 1;
                }
            }
        }


        //从下往上跑
        for (int j = 0; j < col; j++) {
            //basecase：
            down[row - 1][j] = matrix[row - 1][j];
            for (int i = row - 2; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));
                max = Math.max(max, temp);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        LongestCrossOf1s sol = new LongestCrossOf1s();
        int[][] matrix = {
                {0, 1, 0, 0},

                {1, 1, 1, 1},

                {0, 1, 0, 0},

                {0, 1, 0, 0}};
        System.out.println(sol.largest(matrix));
    }
}
