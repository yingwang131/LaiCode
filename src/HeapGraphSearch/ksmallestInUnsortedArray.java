package HeapGraphSearch;

import BinarySearch.KthSmallestIn2sortedArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
/*
A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */

public class ksmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k){
        // 思路：先把unsorted 变成sorted，然后再用一个binary search 来找到前k小的元素
        // 如何它unsorted 变成一个sorted 有三种办法：1：max heap，2：min-heap， 3：quick-select

        //base case:
        if (array.length == 0||k == 0){
            return new int[0];
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //这个reverse的意思就是把顺序给调过来。因为我不写reverOrder，java默认的是Integer的顺次，即从小到大，是个minHeap，所有要用reverOrder把顺序给缓过来；
        // 先把前k 个元素 heapifiy 一下，所以先要把前k的元素offer进来
        /*
        //这样写更简便；
        for (int i = 0; i < k; i++){
            maxHeap.offer(array[i]);
        }


        //从第k+1个元素开始比较大小，index的话应该是k
        for (int i = k; i < array.length; i++){
           if (array[i] < maxHeap.peek()){
               maxHeap.poll();
               maxHeap.offer(array[i]);
           }
        }
         */
        //这样子写，把※号里面的2部合并成了一步；
        for (int x: array){
            if (maxHeap.size() < k){
                maxHeap.offer(x);
            }else if (x < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(x);
            }
        }
//        //最后再把tree里面最小的k个元素给打印出来，这样打印是乱序
//        for (int x: maxHeap
//             ) {
//            System.out.println(x);
//        }
        int[]res = new int[maxHeap.size()];
        //这样打印出来的是【4321】
//        for (int i = 0; i < k; i++){
//            res[i] = maxHeap.poll();
//        }

        //这样打印出来的是【1234】
        for(int i = maxHeap.size()-1; i >= 0; i--){
            res[i] = maxHeap.poll();
        }
        return res;

    }

    public int[] kSmallest1(int[] array, int k){

        Queue<Integer> minHeap = new PriorityQueue<>();

//        for (int i = 0; i < array.length; i++){
//            minHeap.offer(array[i]);
//        } //2种方法都对啊

        for(int x : array){
            minHeap.offer(x);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll();
//            System.out.println(minHeap.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        ksmallestInUnsortedArray sol = new ksmallestInUnsortedArray();
        int[] array = {7,4,1,9,8,15,2,3};
        int k = 4;
        int[] result = sol.kSmallest(array,k);
        System.out.println(Arrays.toString(result));
//         sol.kSmallest1(array,k);

        System.out.println(Integer.MAX_VALUE);
//
//        for ( int i = 0; i < 5; i++){
//            if (i == 2){
//                continue;//break: 作用于while loop，跳出整个循环； contine：跳出当前循环，注意while只有一个循环
//            }
//            System.out.println(i);
//
//        }
////
//        int j = 0;
//
//        while (j <= 10){
//            if (j == 3){
//                continue;//在while循环里面，用continue 和break 都一样；因为while只有一个循环，continue：跳出当前循环，break：跳出整个循环
//            }
//            System.out.println(j);
//            j++;
//        }
//
    }
}
