package HashTableStringI;

import java.util.*;

/*
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
这一题为什么选择comparator 而不是 comparable
1: 笔记上的 PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 之所以打印出来是minHeap是因为Integer implementing Comparable Interface
抽象method: public int compareTo(Integer another) 比较了2个int 值之间的关系，负的优先级最高，所以才是1，2，3，4，5 的order
2：这一题为什么不能用Comparable interface 是因为Map.Entry<String, Integer> 是需要自己来定义的，java里面没有这样的定义
3：如果我不implements Comparable 或这 Comparator，自己去写优先级的话，这个代码里面根本就没有优先级的定义
 */
//1:step1：iterate thru the input list, and update the HashMap
//2:Recall：Heap：top k 的那个题目
//3: 如果指定的数与参数相等返回0。如果指定的数小于参数返回 -1。如果指定的数大于参数返回 1。

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k){
        if (combo.length == 0){
            return new String[0];
        }

        //use minHeap to find the top k
        Map<String, Integer> freqMap = getFreqMap(combo); //把input的list 用key value 记录一下



        PriorityQueue<Map.Entry<String, Integer>>minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue()); // 这句话和下面的判断相等，大小的if 一样，只不过O1O2都是Integer，可以直接调用Integer的compareTo来比较，就更简单，省略下面的几行代码；
                // 并且Integer 本身 的比较，就是返回值越小的，优先级越高；所以下面的代码就多于了；所以return1.-1是为了比较新的entry的顺序，而且我是一个minHeap，所以写比较的时候要遵循minheap的order

//                if (o1.equals(o2)){ //不能这么写的原因是 < 不支持 object type，因为这里是Map。那这个equals 好像比较的不是2个Comparator 呀，Anna 是不是说错了？
//                    return 0; // 应该是type不一样，这个是一个匿名类，而匿名类的写法就是，.compareTo；
//                }
                if (o1.getValue() == o2.getValue()){
                    return 0;
                }
                return o1.getValue() < o2.getValue() ? -1:1;
            }
        });




//        PriorityQueue<Map.Entry<String, Integer>>minHeap = new PriorityQueue<>(k,Collections.reverseOrder());


        for (Map.Entry<String, Integer> entry: freqMap.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry);//先把小于k的kv pair 都放到minheap里面，下面的判断语句才开始判断，value大的要把minheap 头上小的给删掉，大的value放进去（最后里面都剩下k个最大的元素）
            } else if (entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return freqArray(minHeap);
    }
    // itera thru the input list; use hashMap to count the key value pair
    private Map<String, Integer> getFreqMap(String[] combo){
        Map<String, Integer> mapTimes  = new HashMap<>();
        for (String s: combo){
            Integer freq = mapTimes.get(s);
            if (freq == null){ // 如果key之前没出现过就是1，出现过的话就+1
                mapTimes.put(s, 1);
            }else {
                mapTimes.put(s, freq + 1);
            }
        }
        return mapTimes;
    }
    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>>minHeap){
        String[] result = new String[minHeap.size()];//只是声明result 有多大而已，不是copy过来，真的copy在for里面,这里minHeap的所有东西到底过没过来？
        for (int i = minHeap.size() - 1; i >=0; i--){//从这一句开始，才开始copy
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWords sol = new TopKFrequentWords();
        String[] result = {"a", "a","a", "a","b","b","c","c","c","c","c"};

        System.out.println(Arrays.toString(sol.topKFrequent(result, 2)));

//        System.out.println(Arrays.toString(new String[0]) );
//        System.out.println(Arrays.toString(new int[0]));
    }

}
