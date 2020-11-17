package DP1;

public class ArrayHopperI {
    public boolean canJump(int[] array) {
        // Write your solution here
        // assume array is not null and is not empty
        if (array.length == 1){
            return true;
        }
        boolean[] jump = new boolean[array.length];
        //basecase在这里默认为：M【4】 == true；
        jump[array.length -1] = true;
        for (int i = array.length - 2; i >=0; i--){
            // i < j <= i + A[i]
            if (i + array[i] >= array.length - 1){
                jump[i] = true;
            }else {
                // if any of the reachable indices from index i is reachable to the end of the array
                for (int j = array[i]; j >= 1; j--){
                    if (jump[j + i]){ // 这个j是 array[I]的值，不管怎么样，j + i， 比如2+0 是true，那现在的就是true
                        jump[i] = true;
                        break;
                    }
                }
            }
        }
        return jump[0];
    }

    public boolean canJump2(int[] array) {
/*
  This way is match to the induction rule we leaned during the class
  base case:
  dp[end] = true
  dp[n] represent whether we can jump from n-th position to the end
  dp[n] = true (dp[n + 1] ~ dp[n + jumpStep] had one true)
           false (otherwise)
*/
        boolean[] dp = new boolean[array.length];
        dp[array.length - 1] = true;

        for (int i = array.length - 2; i >= 0; i--) {
            int upperBound = Math.min(array.length - 1, i + array[i]);
            for (int j = i + 1; j <= upperBound; j++) {
                if (dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        ArrayHopperI sol = new ArrayHopperI();
        int[] array = {2,3,1,1,4};
        int[]array2 = {4,2,1,1,0,4};
        System.out.println(sol.canJump2(array));
    }
}
