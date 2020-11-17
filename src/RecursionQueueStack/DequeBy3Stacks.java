package RecursionQueueStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeBy3Stacks {
    Deque<Integer>right;
    Deque<Integer>left;
    Deque<Integer>bufferStack;
    public DequeBy3Stacks(){
        right = new ArrayDeque<>();
        left = new ArrayDeque<>();
        bufferStack = new ArrayDeque<>();
    }
    public void offerFirst(int element){
        //offerFirst 就像是left.add（）
        left.offerFirst(element);
    }
    public void offerLast(int element){
        //offerLast  就像是right.add()
        right.offerFirst(element);
    }
    public Integer pollFirst(){
        //pollFirst 是左边
        move(right, left);
        return left.isEmpty() ? null:left.pollFirst();
    }
    public Integer pollLast(){
        //pollLast 是右边
        move(left, right);
        return right.isEmpty() ? null:right.pollFirst();
    }
    public Integer peekFirst(){
        move(right, left);
        return left.isEmpty() ? null:left.peekFirst();
    }
    public Integer peekLast(){
        move(left, right);
        return right.isEmpty() ? null:right.peekFirst();
    }
    public int size(){
        return left.size() + right.size();
    }
    public boolean isEmpty(){
        return left.isEmpty() && right.isEmpty();
    }
    //when end is empty, move half of the elements from start to end side ;不一定是左边还是右边,看着办
    //  12345678 ||stack1 stack2||
    private void move(Deque<Integer> start, Deque<Integer> end){
        if (!end.isEmpty()){
            return;
        }
        int halfSize = start.size()/2;
        for (int i = 0; i < halfSize; i++){
            bufferStack.offerFirst(start.pollFirst());
        }
        while (!start.isEmpty()){
            end.offerFirst(start.pollFirst());
        }
        while (!bufferStack.isEmpty()){
            start.offerFirst(bufferStack.pollFirst());
        }
    }

}
