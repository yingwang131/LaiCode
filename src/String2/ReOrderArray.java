package String2;

import java.util.Arrays;

/*
{ N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
ABCD1234 -> A1B2C3D4, 反着做mergeSort； 偶数的情况
A B C D E F G | 1 2 3 4 5 6 7 -》A1B2C3D4E5F6G7; 奇数的情况
A B C G F E D 3 2 1 4 5 6 7 ->分别reverse chunck 2， then chunck3
A B C 1 2 3 D E F G 4 5 6 7 ->reverse 全部，即chunck2 和chunck3 一起reverse
A B C 1 2 3-》然后就像mergesort分别recursion left 和right

A C B 2 1 3 ->分别reverse chunck 2， then chunck3
A 1 2 B C 3 ->reverse 全部，即chunck2 和chunck3 一起reverse

A 1 2 B C 3 ->分别reverse chunck 2， then chunck3; C1: A1; C2: 2; C3:B; C4:C3
A 1 2 B C 3 ->
 */
public class ReOrderArray {
    public int[] reorder(int[] array) {
        if (array.length % 2 == 0){
            reorder(array, 0,array.length -1);
        }else {
            //if array has odd number of elements, we ignore the last one when do the reordering
            reorder(array, 0, array.length -2);
        }
        return array;
    }
    private void reorder(int[]array, int left, int right){
        int length = right -left +1;
        //if the subarray has 2 or 0 elements, we can just return as this should be the base case
        if (length <= 2){
            return;
        }
        int mid = left + length /2;
        int leftMid = left + length/4;
        int rightMid = left + length * 3/4;
        // int leftmid = left + (1/4) * length; // 这样写会stack overflow
        // int rightmid = left + (3/4) * length; // 这样写会 wrong answer
        //这3步，是在使用iloveyahoo的trick，虽然iloveyahoo 是先全部rever，再局部reverse words，但是这里反了过来：变为先reverse 局部的c1和c3，在全部reverse
        reverse(array, leftMid,mid -1);
        reverse(array, mid,rightMid -1);
        reverse(array, leftMid,rightMid -1);


        //half of the left partition's size = lmid - left
        // 当我们做完所有的reverse后，在用recursion把问题size变小，继续做
        reorder(array, left, left + (leftMid - left) * 2 - 1);
        reorder(array, left +(leftMid - left) * 2, right);

    }
    private void reverse(int[] array, int left, int right){
        while (left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {

        ReOrderArray sol = new ReOrderArray();
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(sol.reorder(array)));



    }
}
