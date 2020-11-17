package RecursionQueueStack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackBy1Queue {
    private Queue<Integer> queue1;
    public StackBy1Queue (){
        queue1 = new ArrayDeque<>();
    }

    public void push(int x){
        queue1.offer(x);
    }
    public Integer pop(){
        if (queue1.isEmpty()){
            return null;
        }
        int size = queue1.size();//size is 3
        System.out.println(size);
        while (--size != 0){ //while(size-- > 1){ 当size 每次减少一个，只留下最后一个元素，其他的全部放到要pop元素的后面
            System.out.println(size);
            queue1.offer(queue1.poll());
        }
        return queue1.poll();
    }
    public Integer top(){
        if (queue1.isEmpty()){
            return null;
        }
        int result = pop();
        queue1.offer(result);
        //我那到top 的元素后，还不能直接返回top，还需要把这个result放回到q里面，才能保证q的顺序不变
        return result;
    }
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackBy1Queue sol = new StackBy1Queue();
        sol.push(1);
        sol.push(2);
        sol.push(3);
        System.out.println(sol.pop());
        System.out.println(sol.top());

    }
}
