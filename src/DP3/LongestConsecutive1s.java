package DP3;

import DP2.LargestSquareOf1s;

/*

1:basecase: input[0] = 0
	      input[0] = 1
	      因此：M[0] = input[0]
2:induction rule:
M[i] represents [form the 0th element to the i-th element] the length of the  longest contiguous 1s [must include the i-th element]
3: M[i] = 1 + M[i-1]        if(input[i] ==1)
		0	                otherwise input[i] ==0

 */
public class LongestConsecutive1s {
    public int longest0(int[] array){ //正确
        if(array == null || array.length == 0){
            return 0;
        }
        int[] M = new int[array.length + 1];
        int result = M[0];
        //basecase
        M[0] = array[0];
        for ( int i = 1; i < array.length; i++){
            if (array[i] == 1){
                M[i] = 1 + M[i-1];
            }else {
                M[i] = 0;
            }
        }
        for (int i = 0; i < M.length; i++){
            result = Math.max(result, M[i]);
        }
        return result;

    }
    public int longest(int[] array){ // 也正确
        if(array == null || array.length == 0){
            return 0;
        }
        int[] M = new int[array.length + 1];
        //basecase
        M[0] = array[0]==0?0:1;
        int result = M[0];

        int i = 1;
        for ( ; i < array.length; i++){
            if (array[i] == 1){
                M[i] = 1 + M[i-1];
            }else {
                M[i] = 0;
            }
            result = Math.max(M[i],result);
        }
        return result;

    }

    public int longest2(int[] array){ // 这种是和longest subarray 一样的写法，不喜欢，因为和induction不一样
        //这个是用了一个current 指针，那我如何写和induction rule 一模一样的代码呢？
        if (array.length == 0){
            return 0;
        }

        //basecase
        int[] M = new int[array.length + 1];
        M[0] = array[0];
        int result = 0;
        int cur = 0; // the counter goes back and including the ith element
        for ( int i = 0; i < array.length; i++){
            if (array[i] == 1){
                cur++;
                result = Math.max(cur,result);
            }else {
                cur = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestConsecutive1s sol = new LongestConsecutive1s();
        int[] array = {1,0,1,0,0,1,1,1,1,0};
        int[] array2 = {0,1,0,1,0};
        int[] array3 = {};
        System.out.println(sol.longest0(array));
    }
}
