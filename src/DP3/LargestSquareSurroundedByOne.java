package DP3;
/*
Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.



Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0



Examples

{{1, 0, 1, 1, 1},

 {1, 1, 1, 1, 1},

 {1, 1, 0, 1, 0},

 {1, 1, 1, 1, 1},

 {1, 1, 1, 0, 0}}



The largest square surrounded by 1s has length of 3.
step1：preprocess direction 1(right ->left) and direction 2 (bottom->up)
step2：for for each possible top-left corner{
            for each possible edge length (min(M[]i)[j], M2[i][l]...1){
                check bottom left corner with direction 1
                check top right corner with direction 2
                }
        }
step3：return global max
 */
public class LargestSquareSurroundedByOne {
    public int largestSquareSurroundedByOne(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int result = 0;
        int Mrow = matrix.length;
        int Ncol = matrix[0].length;
        //trick for here, left[i][j] is actually mapped to matrix[i-1][j-1],this will reduce corner case
        int[][]left = new int[Mrow +1][Ncol +1];
        int[][]up = new int[Mrow+1][Ncol+1];
        for (int i = 0; i < Mrow; i++){
            for (int j = 0; j < Ncol; j++){
                if (matrix[i][j] == 1){
                    left[i+1][j+1] = left[i+1][j]+1;
                    up[i+1][j+1] = up[i][j+1]+1;
                    for(int maxLength = Math.min(left[i+1][j+1], up[i+1][j+1]); maxLength >=1; maxLength--){
                        if (left[i+2-maxLength][j+1] >= maxLength && up[i+1][j+2-maxLength] >=maxLength){
                            result = Math.max(result,maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }


    public int largestSquareSurroundedByOne2(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int Mrow = matrix.length;
        int Ncol = matrix[0].length;

        int[][] left = new int[Mrow][Ncol];
        int[][] up = new int[Mrow][Ncol];
        int max = 0;

        //从右往左 建立dp数组
        for (int i=0;i<Mrow;i++){
            for(int j=Ncol-1;j>=0;j--){
                if (matrix[i][j] == 1){
                    if(j==Ncol-1){ //i =0, j=4
                        left[i][j]=1;
                    }else{
                        left[i][j]=left[i][j+1]+1;
                    }
                }

            }
        }

        //从下往上，建立dp数组
        for(int i = Mrow-1; i >= 0; i--){
            for (int j = 0; j < Ncol; j++ ){
                if (matrix[i][j] == 1){
                    if(i == Mrow -1){
                        up[i][j] =1;
                    }else{
                        up[i][j]=up[i+1][j]+1;
                    }
                }
            }
        }


        //从右下角到左上角，找正方形
        for (int i=Mrow-1;i>=0;i--){
            for(int j=Ncol-1;j>=0;j--){
                if(matrix[i][j]==1) {
                    //find the max length of edge of the square whose up-left corner point is [i][j]
                    int maxLen = Math.min(left[i][j], up[i][j]);
                    for (int l = maxLen; l >= 0; l--) {
                        //find the down-left point
                        int x1=i+l-1;
                        int y1= j;

                        // find the up-right point
                        int x2=i;
                        int y2=j+l-1;

                        //if the down edge and the right edge greater than l, that means these three points
                        // can wrap a square
                        if(left[x1][y1]>=l&&up[x2][y2]>=l){
                            max=Math.max(max,l);
                            break;
                        }
                    }
                }
            }
        }

        return max;



    }

    public static void main(String[] args) {
        LargestSquareSurroundedByOne sol = new LargestSquareSurroundedByOne();
        int[][] matrix = {
                {1, 0, 1, 1,1},

                {1, 1, 1, 1,1},

                {1, 1, 0, 1, 0},

                {1, 1, 1, 1,1},

                {1, 1, 1, 0, 0}};
        System.out.println(sol.largestSquareSurroundedByOne2(matrix));
        System.out.println(0b1);//1
        System.out.println(0b10);//2
        System.out.println(0b11);//3
    }

}
