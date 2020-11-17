package HashTableStringI;

import java.util.*;
// 上网找的答案
public class TopKFrequentWordsMaxHeap3 {
    private class Freq implements Comparable<Freq>{
        private int key;
        private int freq;
        public Freq(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq o) {
            if(this.freq<o.freq)
                return 1;
            if(this.freq>o.freq)
                return -1;
            return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer,Freq> map=new HashMap<>();
        //使用Map集合存储每个元素对应的频率
        for(int i:nums){
            if(map.get(i)==null){
                map.put(i,new Freq(i,1));
            }else{
                Freq freq=map.get(i);
                freq.freq+=1;
                map.put(i,freq);
            }
        }
        //使用优先级队列存储出现频率较大的前K个元素
        PriorityQueue<Freq> priorityQueue=new PriorityQueue<>();
        //开始遍历Map
        for(int key:map.keySet()){
            //当优先级队列元素未到K
            if(priorityQueue.size()<k){
                priorityQueue.offer(new Freq(key,map.get(key).freq));
            }
            //优先级队列元素达到K之后，每次替换队列中频率最小的元素
            if(map.get(key).freq>priorityQueue.peek().freq){
                //将优先级队列中最小的频率替换
                priorityQueue.poll();
                priorityQueue.offer(new Freq(key,map.get(key).freq));
            }
        }
        LinkedList<Integer> list=new LinkedList<>();
        while (!priorityQueue.isEmpty()){
            list.addFirst(priorityQueue.poll().key);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,2,2,3};
        List<Integer> list=new TopKFrequentWordsMaxHeap3().topKFrequent(nums,2);
        System.out.println(list);
    }
}


