package HashTableStringI;

import java.lang.reflect.Array;
import java.util.*;

public class TopKFrequentWords2 {
    public static void main(String[] args) {
        TopKFrequentWords2 sol = new TopKFrequentWords2();
//        String[] result = {"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        String[] result ={"a", "a", "b", "b", "b", "b", "c", "c", "c", "d" };

        System.out.println(Arrays.toString(sol.topKFrequent(result, 2)));




    }
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if (combo.length == 0) {
            return new String[0];
        }

        //step 1: use hashmap get all key value pair
        Map<String, Integer> hashMap = getHashMap(combo);
        //step 2: use minHeap to find the top k
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if (o1.getValue() == o2.getValue()){
//                    return 0;
//                }
//                return o1.getValue() < o2.getValue()? -1:1;
//            }

                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //这里在做什么？主逻辑
        for (Map.Entry<String, Integer> x: hashMap.entrySet()) {
            if (minHeap.size() < k){
                minHeap.offer(x);//先在hashMap里面挑k个元素放到minHeap里面
            }else if (x.getValue() > minHeap.peek().getValue()){// 如果hashmap里面的value 大于 minHeap头上的value的话
                // 把minHeap小的元素给删掉，把hashmap里面大的元素放到minHeap里
                minHeap.poll();
                minHeap.offer(x);

            }
        }
        String[] res = new String[minHeap.size()]; // 写入resarray的时候是从后往前写的，这样打印出的result就是字母多的在前面
        for (int i = minHeap.size()-1; i >= 0; i--){
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }
    public Map<String, Integer> getHashMap(String[] combo){
        Map<String, Integer> map = new HashMap<>();
        for (String x: combo) {
            Integer freq = map.get(x); // get key return value,第一次return的value一定是null，因为string 里面只有字母，没有字母的次数；
            if (freq == null){
                map.put(x,1); // put key , value
            }else {
                map.put(x, freq +1);
            }
        }
        return map;
    }




    // 用maxHeap来做，发现用maxheap和minheap的行数都一样，但是push 到maxheap里面并没有按照从大到小排列，而且最后打出来的for也不work，还是minHeap好用
    public String[] topKFrequent2(String[] combo, int k) {
        // Write your solution here
        if (combo.length == 0) {
            return new String[0];
        }

        //step 1: use hashmap get all key value pair
        Map<String, Integer> hashMap = getHashMap2(combo);
        //step 2: use maxHeap to find the top k
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()){
                    return 0;
                }
                return o1.getValue() > o2.getValue()? -1:1;
            }
        });

        //这里在做什么？
        for (Map.Entry<String, Integer> x: hashMap.entrySet()) {
            if (maxHeap.size() < k){
                maxHeap.offer(x);//先在hashMap里面挑k个元素放到minHeap里面
            }else if (x.getValue() > maxHeap.peek().getValue()){// 如果hashmap里面的value 大于 minHeap头上的value的话
                // 把minHeap小的元素给删掉，把hashmap里面大的元素放到minHeap里
                maxHeap.poll();
                maxHeap.offer(x);

            }
        }
        String[] res = new String[maxHeap.size()]; // 写入resarray的时候是从后往前写的，这样打印出的result就是字母多的在前面
        for (int i = maxHeap.size()-1; i >= 0; i--){
            res[i] = maxHeap.poll().getKey();
        }

        return res;
    }
    public Map<String, Integer> getHashMap2(String[] combo){
        Map<String, Integer> map = new HashMap<>();
        for (String x: combo) {
            Integer freq = map.get(x); // get key return value,第一次return的value一定是null, 因为我还没有input assign value；《a：1》
            if (freq == null){
                map.put(x,1); // put key , value
            }else {
                map.put(x, freq +1);
            }
        }
        return map;
    }
}