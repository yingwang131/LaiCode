package basicJava;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][]array = {{1,3,4},{3,4,6},{3,-2,-1}};
        if (array.length != array[0].length){
            System.out.println("cannot calculate trace for non-square matrix");
        }else {
            int n = array.length;
            int sum = 0;
            for (int i = 0; i < n; i++){
                sum += array[i][i];
            }
            System.out.println(sum);
        }
    }
}
