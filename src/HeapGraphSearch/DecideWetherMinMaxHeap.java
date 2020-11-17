package HeapGraphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DecideWetherMinMaxHeap {
    public static void main (String[] args){
        Queue<Integer> pq = new PriorityQueue<>(new namedComparator());
        pq.offer(1500*1000*1000);
        pq.offer(-1000*1000*1000);
        pq.offer(2000*1000*1000);
        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

}

class namedComparator implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        if (o1.equals(o2)){
            return 0;
        }
        return o1 < o2 ? -1 : 1;
    }
}
