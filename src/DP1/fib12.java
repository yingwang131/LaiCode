package DP1;

public class fib12 {

    /*
    time: O(n^2),recusrion
     */
    public long fibonacci0(long K){
        if (K <= 0){
            return 0;
        }
        if (K == 1){
            return 1;
        }
        return fibonacci0(K-1)+ fibonacci0(K -2);
    }

    /*
    time: O(n) dp
     */
    public  long fibonacci(int K){
        if (K <= 0){
            return 0;
        }
        // I need to do the exception in here otherwise will have indexoutof boundary error
        if (K == 1){
            return 1;
        }
        long[] array = new long[K+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= K; i++){
            array[i] = array[i - 1]+array[i - 2];
        }
        return array[K];
        }

    /*
    time: O1 dp
     */
    public long fibnacci2(int K){
        long a = 0;
        long b = 1;
        if (K <= 0){
            return 0;
        }
        if (K == 1){
            return 1;
        }
        while (K > 1){
            long temp = a+b;
            a = b;
            b = temp;
            K--;
        }
        return b;
    }
    public static void main(String[] args){
        fib12 sol = new fib12();
        int result = 4;
//        System.out.println(sol.fibonacci0(result));
        System.out.println(sol.fibonacci(result));
//        System.out.println(sol.fibnacci2(result));
    }
}
