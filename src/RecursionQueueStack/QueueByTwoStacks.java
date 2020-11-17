package RecursionQueueStack;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public QueueByTwoStacks(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    public Integer poll(){
        //case 1: if s2 is empty, s1 poll, s2push
        //case 2: if s2 is not empty, s2.pop
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.offerFirst(stack1.pollFirst());
            }
        }
        return stack2.pollFirst();
    }
    public void offer(int element){
        stack1.offerFirst(element);
    }
    public Integer peek(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if (stack2.isEmpty()  ){
            while (!stack1.isEmpty()){
                stack2.offerFirst(stack1.pollFirst());
            }
        }
        return stack2.peekFirst();
    }
    public  int size(){
        return stack2.size() + stack1.size();
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueByTwoStacks sol = new QueueByTwoStacks();

        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
//        s1.offerFirst(3);
//        s1.poll();
//        s1.peek();
//        s1.offer(1);
//        s1.peek();
//        s1.offer(2);
//        s1.offer(6);
//        s1.poll();
//        s1.peek();
//        System.out.println(s1.offerFirst(3));
//        System.out.println(s1.poll());
//        System.out.println(s1.peek());
//        System.out.println(s1.offer(1));
//        System.out.println(s1.peek());
//        System.out.println(s1.offer(2));
//        System.out.println(s1.offer(6));
//        System.out.println(s1.poll());
//        System.out.println(s1.peek());

        s1.push(1);
        s1.push(2);
        s1.push(3);

        /*
        这样写当然不对了，
        s1：1，2，3；
        s2：空；
        能进去if循环
        s1：1，2，3；
        s2：3，
        当s2 有一个元素的时候，这个if 循环再也进不来了，你说对不对？
        if (s2.isEmpty() && !s1.isEmpty()){

            s2.offerFirst(s1.pollFirst());

        }
         */
    }
}
