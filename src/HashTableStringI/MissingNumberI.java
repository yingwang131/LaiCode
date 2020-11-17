package HashTableStringI;
/*

A = {2, 1, 4}, the missing number is 3; N = 4
A = {1, 2, 3}, the missing number is 4; N = 4
A = {}, the missing number is 1; N = 1

方法1： 用hash table 这个数据结构，它包含了HashMap，HashSet，那我究竟用哪个？HashSet 因为我不关心counts了几次value，我之关系它是否出现过；On，worst：On^2

 */


import java.util.HashSet;
import java.util.Set;

public class MissingNumberI {
    public int missing(int[] array){
        int n = array.length + 1;
        //1:iterate thru the input array, add every element to the hashSet
        //2: for each number from 1 to n, check if it exits in the hashset
        Set<Integer> mySet = new HashSet<>();

        for (int x: array){
            if (array != null){
               mySet.add(x);
            }
        }

//        for (int i = 0; i < array.length; i++){
//            if (array != null){
//                mySet.add(array[i]); // 这里千万别写成了.add（i），会直接把index给加到myset里面，太搞笑了
//            }
//        }



        for(int i = 1; i <= n; i++){ //这个题目限制了只能从1开始，如果改成【7，9，10】是不可以的，因为n=3+1=4，i<4 不对
            System.out.println(i);
            if (!mySet.contains(i)){
                return i;//这里的i是指这个元素哦，不是index；如果 myset里面没有contains i = ? 的这个值，i=1，就在myset里面找有没有value1；i = 2，就找myset有没有value=2；
                // 如果没有和i相等的value，我就return 这个i，否则返回最初设置的n的值，n+1
            }
        }
        return n;
    }

    //方法2： On 用 1+ 2+3+...+n = n * (n+1)/2
    //       calculate the sum of all elements in the input array ==> sum
    //       target value = n * (n+1)/2 - sum
    public int missing2(int[] array){
        int n = array.length + 1;
        long totalSum = n * (n+1)/2;
        long realSum = 0;
        for (int x: array){
            realSum += x;
        }
        return (int)(totalSum - realSum);
    }

    // 方法4  boolean Array, 是正确的

    /**
     * store from 1 to N, except one number
     * @param array
     * @return
     */
    public int missing4(int[] array){
        int n = array.length + 1;
        boolean[] exist = new boolean[n+1];

        for (int i = 0; i < array.length; i++){
            exist[array[i]] = true;
            //因为这里写的是exist【array【0】】==》 exist【12】，要把exist[12]变成true，所以这个exist要比原来的array大2位，一位是给index0，一位是给最右一个数字12
        }
        for (int j = 1; j <= n ; j++){
            if (exist[j] == false){
                return j;
            }
        }
        return n;
    }


    public static void main(String[] args) {
        MissingNumberI sol = new MissingNumberI();
//        int[] array = {2,11,10,9,4,5,6,7,1,3,8};
        int[] array = {2,1,4};
//        int[] array = {4,2,3,1};
        System.out.println(sol.missing4(array));

    }
}
