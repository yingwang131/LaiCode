package queueLinkedList;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class QueueByTwoStacks {

    Deque<Integer> stack1;
    Deque<Integer> stack2;


    // 这个是个什么东西，没有返回值，是constructor么，为什么放在这里？是constructor,那里面要装什么东西？
    public QueueByTwoStacks(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    // 来一个shuffe method
    public void shuffle(){ // s2 是空，但是当 s1 不为空的时候，把s1 导到 s2 里面，先s1 pop， 再s2.push
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());

            }
        }
    }
    public Integer poll() {
        Integer result = null;
        shuffle();
        // base case
        if (stack2.isEmpty() && stack1.isEmpty()) { // s2 是空,  s1 也是空，return null，
            return null;
        }
        //s2 不为空的时候，直接pop
        if (!stack2.isEmpty()){
            result = stack2.pop();
        }
        return result;
    }

    public void offer ( int element){
        stack1.push(element);

    }
    public Integer peek () {
        Integer result = null;
        shuffle();
        // base case
        if (stack2.isEmpty()) { // s2 是空,  s1 也是空，return null，
            return null;
        }
        //s2 不为空的时候，直接pop
        if (!stack2.isEmpty()){
            result = stack2.peek();
        }
        return result;
    }
    public int size () {
        Integer result = null;
        result = stack1.size() + stack2.size();
        return result;

    }
    public boolean isEmpty () {
        boolean result = false;
        result = stack1.isEmpty() && stack2.isEmpty();
        return result;
    }


    public static void main(String[] args) {
        QueueByTwoStacks sol = new QueueByTwoStacks();
//        Deque<Integer> stack1= new LinkedList<>();
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(3);
//        stack1.push(4);
//        stack1.push(5);
//        System.out.println(sol.stack1.size());
//        Deque<Integer> stack2= new LinkedList<>();
//
//
//        System.out.println(sol.poll());

        List<Integer> result = new ArrayList<>();
        // 把result 都存到了 list 里面；因为new 出来的instance class 本身就是一个queue，所以只要sol.offer 进去；sol.poll出来，再放到result 的List里面
        sol.offer(1);
        sol.offer(2);
        sol.offer(3);

//        sol.offer(4);
//        result.add(sol.poll());
//
//        sol.offer(5);
//        result.add(sol.poll());

        result.add(sol.poll());
        result.add(sol.poll());
        result.add(sol.poll());
        System.out.println(result.toString());

    }
}

/*
public class QueueByTwoStacks {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    QueueByTwoStacks(){
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    public Integer poll(){
        Integer re=null;
        if(!stack2.isEmpty()){
            re=stack2.pop();
        }else{
            while(!stack1.isEmpty()){//move to stack2 to make stack1 have only one element.Then pop this element.
                re=stack1.pop();
                stack2.push(re);
            }
            if(!stack2.isEmpty()){
                re=stack2.pop();
            }
        }
        return re;
    }
    public Integer offer(int o){
        stack1.push(o);
        return o;
    }

    public static void main(String[] args) {
        QueueByTwoStacks queue=new QueueByTwoStacks();
        List<Integer> re=new ArrayList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
//        re.add(queue.poll());
//        queue.offer(4);
//        re.add(queue.poll());
//        queue.offer(5);
        re.add(queue.poll());
        re.add(queue.poll());
        re.add(queue.poll());
        System.out.println(re.toString());
    }

}

 */