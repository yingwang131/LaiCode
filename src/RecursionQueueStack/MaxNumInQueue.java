package RecursionQueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNumInQueue {
    public int maxInQueue(Queue<Integer> queue){
        if (queue == null || queue.isEmpty()){
            return 0;
        }
        int max = queue.poll();
        while (!queue.isEmpty()){
            max = Math.max(max, queue.poll());
        }
        return max;
    }

    public static void main(String[] args) {
        MaxNumInQueue sol = new MaxNumInQueue();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.offer(8);
        queue.offer(3);
        queue.offer(2);
        queue.offer(7);
      System.out.println(sol.maxInQueue(queue));
    }
}
