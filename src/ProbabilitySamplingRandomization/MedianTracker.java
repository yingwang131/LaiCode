package ProbabilitySamplingRandomization;

import java.util.Collections;
import java.util.PriorityQueue;

//DataStructure：heap
public class MedianTracker {
    // 答案里面的smallHalf 就是maxHeap
    // 答案里面的largerHalf 就是 minHeap
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianTracker(){
        //we care about the smallest number of the maxHeap
        // and the largest number of the minHeap.
        /*
        为什么一定是max reverse order呢, 所以一定要在max 上也reverseOrder
        不在maxH写reverse order， maxHeap[1,2] minHeap[3，10]，maxH.peek 是 1，minH.peek 是 3 中位数是：2.0
        在maxH写reverse order，   maxHeap[2,1] minHeap[3，10]，maxH.peek 是 2，minH.peek 是 3 中位数是：2.5
         */
        maxHeap = new PriorityQueue<>(1,Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    public void read(int value){
        //need to read all the values one by one,follow the two case form the 19大班课笔记
        if (maxHeap.isEmpty() || value <= maxHeap.peek()){
            maxHeap.offer(value);
        }else{
            minHeap.offer(value);
        }
        // after we insert value, will break the balance,need to do some adjustment
//        if (maxHeap.size() > minHeap.size()+1){
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }else if (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        System.out.println(maxHeap);
        System.out.println(minHeap);
    }
    public Double median(){
       int size = size();
       if (size == 0){
           return null;
       }else if (size % 2 != 0){ //这里是多此一举么？
           return (double)(maxHeap.peek());
       }else {
           System.out.println(maxHeap.peek());
           System.out.println(minHeap.peek());
           return (maxHeap.peek() + minHeap.peek())/2.0;
       }
    }
    private int size(){
        return minHeap.size() + maxHeap.size();
    }

    public static void main(String[] args) {
        MedianTracker sol = new MedianTracker();
        sol.read(1);
        sol.read(2);
        sol.read(3);
        sol.read(10);
        System.out.println(sol.median());
    }
}
