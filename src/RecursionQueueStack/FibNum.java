package RecursionQueueStack;

public class FibNum {
    /*
    time: O(2^n)
     */
    public int fibonacci(int k){
        if (k <= 0){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return fibonacci(k-1) + fibonacci(k-2);
    }



    /*
    dp: time: O(n)
    O(n), dp 和 recursion 的关系
               rec：从大到小的解决问题： sub-problem，base case， recursion rule
               dp:  从小到大的解决问题： sub-solution， basecase， induction rule
     */
    public int fib1(int k){
        //corner case
        if (k <= 0){
            return 0;
        }
        // I need to do the exception in here otherwise will have indexoutof boundary error
        if (k == 1){
            return 1;
        }

        // in order to record the sub-solution
        int[] fibsArray = new int[k+1];
        //base case
        fibsArray[0] = 0;
        fibsArray[1] = 1;
        for (int i = 2; i <= k; i++){
            fibsArray[i]=fibsArray[i-1] + fibsArray[i-2];
        }
        return fibsArray[k];

    }


    public static void main(String[] args) {
        FibNum sol = new FibNum();
        int k = 6;
        System.out.println(sol.fib1(k));
    }
}
