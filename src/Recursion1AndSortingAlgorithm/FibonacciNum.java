package Recursion1AndSortingAlgorithm;

public class FibonacciNum {
    public int fibonacci(int k){
        //recursion, base case: k <0 return 0, k == 1 return 1, k == 2 return 1
        // recursion rule: fib2: fib(k-1) + fib(k-2) = 1+0 = 1
        // time: 看直上直下的路径，是2^N
        // space：用了recursion On
        if (k <= 0){
            return 0;
        }else if (k == 1){

            return 1;
        }else if (k == 2){
            return 1;
        }
        return fibonacci(k-1) + fibonacci(k-2);
    }

    public static void main(String[] args) {
        FibonacciNum sol = new FibonacciNum();
        int k = 2;
        int k1 = 3;
        int k2 = 6;
        System.out.println(sol.fibonacci(k2));
    }
}
