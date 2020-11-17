package DP2;

public class ArrayHopperII {
    /*
    M[I] : represents the minimum number of jumps to jump from i to the target.

BaseCase：M[n-1] = 0
induction rule：1 + min(M[j]) where  i < j <= i + input[i] ;
对所有的 j 取最小值， i一定在 j 的右侧，j 一定不能超过 我的i 一步可以跳达的位置；


     */
    public int minJump(int[] array) {
        int[] jump = new int[array.length];
        // basecase
        jump[array.length - 1] = 0; // base case
        for (int i = array.length - 2; i >= 0; i--) {
            jump[i] = -1;//initialized as -1
            int min = Integer.MAX_VALUE;
            int induction = Math.min(i + array[i]+1, array.length );
            for (int j = i; j < induction; j++) {
                if (jump[j] != -1) {
                    min = Math.min(min, 1 + jump[j]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                jump[i] = min;
            }
        }
        return jump[0];
    }

    public int minJump2(int[] array) {
        // Java solution from the front to back
        int length = array.length;
        int [] result = new int[length];
        //we don not need to jump for index 0
        result[0] = 0;
        for (int i = 1; i < length; i++){
            result[i] = -1;// initialized as unreachable
            for (int j = i -1; j >= 0; j--){
                if (j + array[j] >= i && result[j] != -1){
                    if (result[i] == -1 || result[i] > result[j] + 1){
                        result[i] = result[j] + 1;
                    }
                }
            }

        }
        return result[length - 1];
    }

    public static void main(String[] args) {
        ArrayHopperII sol = new ArrayHopperII();
        int[] array = {2,3,1,1,4};
        System.out.println(sol.minJump2(array));
    }
}
