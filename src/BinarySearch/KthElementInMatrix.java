package BinarySearch;

public class KthElementInMatrix {
    public int findElement(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int row = k/matrix[0].length;
        int column = k%matrix[0].length;
        return matrix[row][column];

    }

    public static void main(String[] args) {
        KthElementInMatrix sol = new KthElementInMatrix();
        int[][] matrix = { {1, 3, 4}, {5, 6, 7}, {8, 9, 10} };
        int k  = 4;
        System.out.println(sol.findElement(matrix,k));
    }
}
