package DP1;
import java.util.*;
/*
base case: M[0] = 1
induction rule:
    M[i-1] + 1 , when input[i] > input[i-1]
    1          , otherwise
 */
public class longestAscendingSubArray {
    // time: O(n)
    // space: O(n)
    public int longest(int[] array){
        if (array.length == 0){
            return 0;
        }
        int result = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++){
            if (array[i] > array[i-1]){
                cur++;
                result = Math.max(result, cur);
            } else {
                cur = 1;
            }
        }
        return result;
    }

    public int longest2(int[] array){
        if (array.length == 0){
            return 0;
        }
        int result = 1;
        int cur = 1;
        //dp[i] = 1   (array[i] <= array[i - 1])
        //        dp[i - 1] + 1 (array[i] > array[i - 1])
        for (int i = 1; i < array.length; i++){
            if (array[i] > array[i-1]){
                cur++;
                result = Math.max(result, cur);
            } else {
                cur = 1;
            }
        }
        return result;
    }
    /*
    DFS: cutting the rope
    题目：5米长的绳子，最少切一刀，最大的乘积是多少
    1: 一共有几层？每一层叉出来 5 个叉；
     */
    public int getMaxProduct(int n){
        // time:n^n
        // space: O（）
        if (n <= 1){
            return 0;
        }
        int maxProduct = 0;
        for (int i = 1; i < n; i++){
            // i = meters of rope to cut off
            int best = Math.max(n-i, getMaxProduct(n-i));
            maxProduct = Math.max(maxProduct, i * best);
        }
        return maxProduct;
    }

    /*
    DP:左大段，右大段
    base case：
    induction rule：
    time:
    space:
     */
    public int curRope(int n){
        // basecase:
        int[]M = new int[n+1];
        M[0] = 0;
        M[1] = 0;
        // induction rule:
        for (int i = 2; i <= n; i++){
            int curMax = 0;
            for (int j = 1; j <= i/2; j++){ // 如果不写 <= 会报错
                curMax = Math.max(curMax, Math.max(j,M[j]) * Math.max(i-j, M[i - j]));
            }
            M[i] = curMax;
        }
        return M[n];
    }

    /*
    DP:左大段，右小段，还是curRope的题目，因为右小段更加通用，只需要改动一点就可以
    base case：
    induction rule：
    time:
    space:
     */
    public int curRope1(int n){
        // basecase:
        int[]M = new int[n+1];
        M[0] = 0;
        M[1] = 0;
        // induction rule:
        for (int i = 2; i <= n; i++){
            int curMax = 0;
            for (int j = 1; j <= i; j++){ // 如果不写 <= 会报错
                curMax = Math.max(curMax, Math.max(j,M[j]) * (i-j));
            }
            M[i] = curMax;
        }
        return M[n];
    }

    /*
    cutDintinary : DP 左大段， 右小段
     */
    public boolean canBreak(String input, String[] dict){
        //base case
        Set<String> dictSet = twoSet(dict);
        boolean[] M = new boolean[input.length() + 1];
        for (int i = 0; i < M.length; i++){
            if (dictSet.contains(input.substring(0,i))){
                M[i] = true;
            }
            // otherwise, check the possible single splite
            for (int j = 1; j < i; j++){
                //check the subproblem and the rest of the word
                if (M[j] && dictSet.contains(input.substring(j,i))){
                    M[i] = true;
                }
            }
        }
        return M[input.length()];
    }

    private Set<String> twoSet(String[] dict){
        Set<String> set = new HashSet<>();
        for (String s: dict){
            set.add(s);
        }
        return set;
    }
    /*
    cutDintinary : DP 左大段， 右小段
    input parameters are string and HashSet
     */
    public boolean canBreakdic(String input, HashSet<String> dict){
        //base case: 即case 0
        boolean[] M = new boolean[input.length()+1];
        //base case: 即case 0
        for (int i = 0; i <M.length; i++ ){
            if(dict.contains(input.substring(0,i))){
                M[i] = true;
            }
            // induction rule: 即case 1， 2， 3， 4 ,..
            for (int j = 1; j < i; j++ ){
                if (M[j] && dict.contains(input.substring(j,i))){
                    M[i] = true;
                }
            }
        }
        return M[input.length()];
    }

    /*
    ArrayHopper I DP:
    method1: canJump[i] means from index i, can jump to index array.length - 1, 即从后往前
     */

    public boolean canJump(int[] array){
        // assume array is not null and is not empty
        if (array.length == 1){
            return true;
        }
        boolean[] jumps = new boolean[array.length];
        //array.length-2 意味着从倒数第二个 元素开始，因为倒数第一个元素一定是true；
        for (int i = array.length - 2; i >= 0; i-- ){
            // if from index i, it is already possible to jump to the end of the array
            // i < j <= i + A[i]
            if (i + array[i] >= array.length - 1){
                jumps[i] = true;
            } else{
                //if any of the reachable indices from index i is reachable to the end of the array
                for (int j = array[i]; j >= 1; j--){
                    if (jumps[j+i]){
                        jumps[i] = true;
                        break;
                    }
                }
            }
        }
        return jumps[0];

    }

    public boolean canJump2(int[] array){
        boolean[] jumps = new boolean[array.length];
        //base case
        jumps[0] = true;
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < i; j++){
                // if index j is reachable from index 0,and from index j, it is possible to jump to index i
                if (jumps[j] && array[j] + j >= i){
                    jumps[i] = true;
                    break;
                }
            }
        }
        return jumps[array.length - 1];
    }

    public static void main(String[] args){
        longestAscendingSubArray sol = new longestAscendingSubArray();
//        int[]res = new int[]{7,2,3,1,5,8,9,6};
//        System.out.println(sol.longest(res));

        /*
        DFS cutting the rope
         */
        int n = 3;
        System.out.println(sol.getMaxProduct(n));

        /*
        curRope
         */
        int m = 4;
        System.out.println(sol.curRope(m));

         /*
        curRope
         */
        int x = 4;
        System.out.println(sol.curRope1(x));

        /*
        cut dictionary
         */
        String z = "bobcatrob";
        String[] dict = {"bob","cat","rob"};
        System.out.println(sol.canBreak(z,dict));

         /*
        cut dictionary
         */
        String y = "bobcatrob";
        HashSet<String> di = new HashSet<>(Arrays.asList("bob","cat","rob"));
        System.out.println(sol.canBreakdic(y,di));

        /*
        array hopper 1
         */
        int[] array = {2,3,1,1,4};
//        System.out.println(sol.canJump(array));

        /*
        array hopper 2
         */
        System.out.println(sol.canJump2(array));
    }
}
