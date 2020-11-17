package RecursionQueueStack;

import java.util.ArrayDeque;
import java.util.Queue;

/*
assumption: we cannot call isEmpty(), peek(), size()
 */
public class StackBy2QueueNoSize {
    private java.util.Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackBy2QueueNoSize(){
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    public void push(int x){
        queue1.offer(x);

    }


    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        Integer prev = queue1.poll(); //prev = 1,
        Integer cur = queue1.poll();//cur =2
        while (cur != null){
            queue2.offer(prev); //先把1 放到q2，再想办法把2 放到q2
            prev = cur;//prev = 2;
            cur = queue1.poll(); //cur

        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
        return prev;
    }

    /** Get the top element. */
    public Integer top() {
        Integer res = pop();
        if (res != null){
            queue1.offer(res);
        }
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return top()== null;
    }

    public static void main(String[] args) {
        StackBy2QueueNoSize sol = new StackBy2QueueNoSize();

        sol.push(1);
        sol.push(2);
        sol.push(3);
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        sol.push(4);
        sol.push(5);
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        System.out.println(sol.top());


        System.out.println(sol.isEmpty());
        //"push(1)", "push(2)", "push(3)", "3", "2", "push(4)", "push(5)", "5", "4", "1", null, null, "true"
    }
}
