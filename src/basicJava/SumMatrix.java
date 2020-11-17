package basicJava;

public class SumMatrix {
    public static void main(String[] args) {
        int[][]a = {{2,3},{4,5},{1,0}};
        int[][]b = {{2,5},{4,-1},{1,6}};

        int m = a.length;
        int n = b[0].length;
        int sum = 0;

        int[][]matrix = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = a[i][j] + b[i][j];
//                System.out.println(matrix[i][j]);
                sum += matrix[i][j];
                System.out.println(sum);
            }

        }


    }
}
