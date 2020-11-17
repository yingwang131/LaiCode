package HeapGraphSearch;

import java.util.*;

/*
A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
1: max heap; 2: min-heap; 3: quick-select
 */
public class KthSmallestInUnsrotedArr2 {
    public static void main(String[] args) {
        int[] array = {5,3,4,2};
        int k = 2;
        System.out.println(Arrays.toString(kSmallest2(array, k)));


    }
    public static int[] kSmallest(int[] array, int k){
        // clarify: integer
        // datastructure: max-heap, size <= k;
        //initialize: {}
            /*
            for each number:
                if maxheap size() < k;
                insert
                else
                    if maxheap.top() > x;
                    maxheap.pop;
                    maxheap.insert(x)
             */
        //termination: no more elements
        //base case:
        if (array.length == 0||k == 0){
            return new int[0];
        }
        Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        // fake heapify to insert k element
        for (int i = 0; i < k; i++){
            maxheap.offer(array[i]);
        }
        for (int i=k; i < array.length; i++){ // make sure maxheap alway have the min element I have see so far
            if (array[i] < maxheap.peek()){
                maxheap.poll();
                maxheap.add(array[i]);
            }
            //else iterator the maxheap's min element and print it out
        }
        // termination?
        int res[] = new int[k];
        //【3，2，1】 print as an ascending order
        for ( int i = k-1; i >=0; i--){
            res[i] = maxheap.poll();
        }


        return res;
    }

    public static int[] kSmallest2(int[]array, int k){

            // maxHeap 用new Comparator 来写
            if (array.length == 0||k == 0){
                return new int[0];
            }
            Queue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
//                if (o1.equals(o2)) {
//                    return 0;
//                }
                if (o1.intValue() == o2.intValue()){
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
            for(int i = 0; i < k; i++){
                maxHeap.offer(array[i]);
            }
            for(int j = k; j < array.length; j++){
                if (array[j] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(array[j]);
                }
            }
            int res[] = new int[k];
            //【3，2，1】 print as an ascending order
            for ( int i = k-1; i >= 0; i--){
                res[i] = maxHeap.poll();
            }
            return res;
        }





    public static int[] kSmallest3(int[]array, int k){
        // use minHeap
        if (array.length == 0||k == 0){
            return new int[0];
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        //先全都都offer进去，然后再poll出来前k个
        for ( int i = 0 ; i < array.length; i++){
            minHeap.offer(array[i]);
        }
//        for ( int j = 0; j < k; k++){
//            minHeap.poll();
//        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }

    public static int[] kSmallest4(int[]array, int k){
        //quick select
        /*
        1:  random pick up the pivot,
        2: case1: if x happens to be the 6th element, X is the answer
            case2: index(x) > 6; find the smallth 6 element in the left half
            case3： index（x）<6 ; find the smallth (k-index(x) - 1) in the right half
            那在x左边包括x一定是包含在答案里面的，在到pivot右边找3个就好了

         */
        if (array.length == 0||k == 0){
            return new int[0];
        }
        quickSelect(array,0,array.length -1, k-1);//why k-1;
        int[] res = Arrays.copyOf(array, k);
        Arrays.sort(res);
        return res;
    }

    private static void quickSelect(int[] array, int left, int right, int target){
        int mid = partition(array, left, right);
        if (mid == target){
            return;
        }else if(target <  mid){
            quickSelect(array,left, mid -1, target);
        }else {
            quickSelect(array, mid+1, right, target );
        }
    }
    public static int partition(int[] array, int left, int right){
        int pivot = array[right];
        int start = left;
        int end = right - 1;
        while (start <= end){
            if (array[start] < pivot){
                start++;
            } else {
                swap(array, start, end--);
            }
        }
        swap(array, start, right);
        return start;//?
    }
    public static void swap(int[] array, int left , int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    }



