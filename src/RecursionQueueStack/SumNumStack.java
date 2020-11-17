package RecursionQueueStack;

import java.util.Deque;
import java.util.LinkedList;

public class SumNumStack {
    public int sumOfStack(Deque<Integer> stack){
        if (stack == null || stack.isEmpty()){
            return 0;
        }
        int sum = stack.pollFirst();
        while (!stack.isEmpty()){
            sum += stack.pollFirst();
        }
        return sum;
    }

    public static void main(String[] args) {
        SumNumStack sol = new SumNumStack();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println(sol.sumOfStack(stack));
    }
}
