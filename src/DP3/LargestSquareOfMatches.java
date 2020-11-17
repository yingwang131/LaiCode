package DP3;

import org.w3c.dom.ls.LSOutput;
//这个题目解法不对，还没找到方法；
public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int Mrow = matrix.length;
        int Ncol = matrix[0].length;

        int[][] right = new int[Mrow + 1][Ncol + 1];
        int[][] down = new int[Mrow + 1][Ncol + 1];

        //从右往左 建立dp数组
        for (int i = 0; i < Mrow; i++) {
            for (int j = Ncol - 1; j >= 0; j--) {
                if (hasRight(matrix[i][j])) {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }

        //从下往上，建立dp数组
        for (int i = Mrow - 1; i >= 0; i--) {
            for (int j = 0; j < Ncol; j++) {
                if (hasDown(matrix[i][j])) {
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }

        //从右下角到左上角，找正方形
        for (int i = Mrow - 1; i >= 0; i--) {
            for (int j = Ncol - 1; j >= 0; j--) {
                if (hasBoth(matrix[i][j])) {
                    //find the max length of edge of the square whose up-left corner point is [i][j]
                    int maxLen = Math.min(right[i][j], down[i][j]);
                    for (int l = maxLen; l >= 0; l--) {
                        //find the down-left point
                        int x1 = i + l - 1;
                        int y1 = j;

                        // find the up-right point
                        int x2 = i;
                        int y2 = j + l - 1;

                        //if the down edge and the right edge greater than l, that means these three points
                        // can wrap a square
                        if (right[x1][y1] >= l && down[x2][y2] >= l) {
                            max = Math.max(max, l);
                            break;
                        }
                    }
                }
            }
        }

        return max;

    }
    private boolean hasRight(int value){
        return (value & 0b1)!= 0;
    }

    private boolean hasDown(int value){
        return (value & 0b10)!= 0;
    }

    private boolean hasBoth(int value){
        return value == 0b11;
    }

}

