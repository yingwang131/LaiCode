package queueLinkedList;

/*
min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.


 */

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public StackWithMin(){
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    public int pop(){
        if (stack.isEmpty()){
            return -1;
        }
        int t = stack.pop();
        if (t == minStack.peek()){
            minStack.pop();
        }
      return t;

    }
    public void push(int element){
        stack.push(element);
        if (minStack.isEmpty() || element <= minStack.peek()){
            minStack.push(element);
        }

    }
    public int peek(){
        if (stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }
    public int min(){

        if (minStack.isEmpty()){
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin sol = new StackWithMin();
        sol.push(7);
        sol.push(2);
        sol.push(5);
        sol.push(3);
        sol.push(8);
        sol.push(1);

        System.out.println(sol.minStack);
        System.out.println(sol.min());


    }

}
