package basicJava;

public class sumof2dArray {

    public int sum(int[][] array) {
        // Write your solution here
        int sum = 0;
        int row = array.length;
        int columns = array[0].length;
        for (int i= 0; i < row; i++){
            for (int j = 0; j < columns; j++){
                System.out.println(array[i][j]);
                sum += array[i][j];
            }
        }
        return sum;
    }

    public String helloWorld(){
        String res = "hello world";
        return res;
//        System.out.println(res);
//        System.out.println("Hello World");
    }

    /*
    calculate the factorial
     */
    public int factorial(int n){
        int res = 1;
        for (int i = 1; i <= n; i++){
            res *= i;
        }
        return res;
    }

    public int sum(int[] arrays){
        int s = 0;
        if (arrays == null || arrays.length == 0 ) {
            return -1;
        }
        for (int i = 0; i <= arrays.length-1; i++){
            s += arrays[i];
        }
        return s;
    }



    public static void main(String[] args){
        sumof2dArray sol = new sumof2dArray();
        int[][]array = {{2,3},{4,5},{1,0}};
        int n = 5;
        int[] arrays = null;
        System.out.println(sol.sum(array));

//
//        System.out.println( sol.helloWorld());
//
//        System.out.println(sol.factorial(n));
//        System.out.println(sol.sum(arrays));


    }


}
