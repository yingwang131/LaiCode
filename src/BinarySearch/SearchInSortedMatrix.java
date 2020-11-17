package BinarySearch;

import java.util.Arrays;
/*
matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

target = 7, return {1, 2}

target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 */
public class SearchInSortedMatrix {
    public int[] search(int[][]matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{-1,-1};
        }
        int row =  matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int mid_row = mid/col;
            int mid_col = mid%col;
            if (matrix[mid_row][mid_col] == target){
                return new int[]{mid_row,mid_col};
            }else if (matrix[mid_row][mid_col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        SearchInSortedMatrix sol = new SearchInSortedMatrix();
        int[][] matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
        int target =  7;
        int[] result = sol.search(matrix,target);
        System.out.println(Arrays.toString(result));
    }
}
