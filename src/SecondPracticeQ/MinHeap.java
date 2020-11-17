package SecondPracticeQ;

import java.awt.*;

public class MinHeap {
   private int size;
   private int[] array;

   public MinHeap(){

   }
   public MinHeap(int[]array){
       if (array == null || array.length == 0){
           throw new IllegalArgumentException();
       }
       this.size = array.length;
       this.array = array;
       heapify();
   }
    //heapify
   private void heapify(){
       for (int i =  size/2 - 1; i >= 0; i--){
           percularDown(i);
       }
   }

    //poll
    public Integer poll(){
       if (array == null || size == 0){
           return null;
       }
       int result = array[0];
       array[0] = size - 1;
       size--;
       percularDown(0);
       return result;
    }
    private void percularDown(int index){
       while (index <= size/2 - 1){
           int leftChildIdx = index * 2 + 1;
           int rightChildIdx = index * 2 + 2;
           int swapNode = leftChildIdx;
           if ( rightChildIdx <= size - 1&& array[rightChildIdx] < array[leftChildIdx]){
               swapNode = rightChildIdx;
           }

           if (array[swapNode] < array[index]){
               swap(array, swapNode, index);
           }else {
               break;
           }
           index = swapNode;
       }
    }

    private void swap(int[] array, int i, int j){
       int tmp = array[i];
       array[i] = array[j];
       array[j] = tmp;
    }
    public void offer(int ele){
        if (size == array.length){
            expand();
        }
        array[size] = ele;
        size++;
        percularUp(size - 1);

    }
    //offer->expand
    public void expand(){
       if (size == array.length){
           int[] newArray = new int[(int) (array.length * 1.5)];
           for (int i = 0; i < array.length; i++){
               newArray[i] = array[i];
           }
           array = newArray;
       }
    }
    public void percularUp(int index){
        while (size > 0){
            int parentIdx = (index -1)/2;
            if (array[parentIdx] > array[index]){
               swap(array, parentIdx, index);
            }else {
                break;
            }
            index = parentIdx;
        }
    }


    //peek
    public Integer peek(){
       if (array == null || size == 0){
           return null;
       }
       return array[0];
    }
    //isEmpty
    public boolean isEmpty(){
       return size == 0;
    }
    //size
    public int size(){
       if (size == 0){
           return 0;
       }
       return size;
    }
    //update
    public Integer update(int index, int ele){
       if (index <0 || index >= size){
           return null;
       }
       int oldValue = array[index];
       array[index] = ele;
       if (oldValue < ele){
           percularDown(index);
       } else {
           percularUp(index);
       }
       return oldValue;
    }

    public static void main(String[] args) {
        MinHeap sol = new MinHeap();
        int[] array = {10, 29, 12, 5, 7, 14,6};
        sol = new MinHeap(array);
        sol.offer(4);
        System.out.println(sol.poll().toString());
    }

}
