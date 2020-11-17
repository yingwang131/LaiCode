package RecursionQueueStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMin {
    Deque<Integer> stack;
    Deque<Integer> stackM;
    public StackWithMin(){
        stack = new ArrayDeque<>();
        stackM = new ArrayDeque<>();
    }
    public void push(int element){
        stack.push(element);
        if (stackM.isEmpty() || element <= stackM.peek()){
            stackM.push(element);
        }
    }
    //top() - return the top element without remove it, if the stack is empty, return -1
    public int top(){
        if(stackM.isEmpty() || stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }
    public int pop(){
        if (stackM.isEmpty() || stack.isEmpty()){
            return -1;
        }


        if (stack.peek() == stackM.peek()){
            stackM.pop();
        }
        System.out.println("******"+stack.peek());
        return stack.pop();
    }
    public int min(){
        if (stack.isEmpty() || stackM.isEmpty()){
            return -1;
        }
        return stackM.peek();
    }

    public int pop2(){
        if (stackM.isEmpty() || stack.isEmpty()){
            return -1;
        }

        /*
        if (stack.peek() == stackM.peek()){
         stackM.pop();
         }
         return stack.pop();
         */
        int temp = stack.peek();
        if (temp == stackM.peek()){
            stackM.pop();
        }

        return stack.pop();
    }
    public static void main(String[] args) {
        StackWithMin sol = new StackWithMin();
        sol.push(136);
        System.out.println(sol.pop2());
        sol.push(135);
        sol.push(139);


//        System.out.println(sol.top());
//        System.out.println(sol.min());
//        System.out.println(sol.pop());
//        System.out.println(sol.min());
//        System.out.println(sol.top());
//        System.out.println(sol.min());
//        System.out.println(sol.pop());
//        System.out.println(sol.min());







    }
}
