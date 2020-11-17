package queueLinkedList;

/*
Example:

stack1 = [8,4,6,1]  stack2 = []

After shuffle:

stack1 = [], stack2 = [1, 6, 4, 8]

 */

import java.util.Deque;
import java.util.LinkedList;

public class ShuffleStacks {
    public void shuffle(Deque<Integer> stack1, Deque<Integer> stack2){
        while (!stack1.isEmpty()){
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        return;
    }

    public static void main(String[] args) {
        ShuffleStacks sol = new ShuffleStacks();
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        stack1.push(8);
        stack1.push(4);
        stack1.push(6);
        stack1.push(1);

        // 把s2 打印出来
        sol.shuffle(stack1, stack2);
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }


//        System.out.println(sol.shuffle(stack1,stack2));

    }
}
