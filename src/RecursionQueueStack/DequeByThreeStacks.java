package RecursionQueueStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {
    Deque<Integer> sleft;
    Deque<Integer>sright;
    Deque<Integer>sbuffer;
    public DequeByThreeStacks() {
        // Write your solution here.
        sleft = new ArrayDeque<>();
        sright= new ArrayDeque<>();
        sbuffer = new ArrayDeque<>();
    }
    //     ||stack1 stack2|| 12345678
    //              bstack|| 8765
    public void offerFirst(int element) {//从左边stack进来，
        sleft.offerFirst(element);
    }

    public void offerLast(int element) {//从右边stack进来
        sright.offerFirst(element);
    }

    public Integer pollFirst() { // 从左边stack poll, 得把右边的倒到左边；
        //把
        move(sright, sleft);
        return sleft.isEmpty()?null:sleft.pollFirst();
    }
    public void move(Deque<Integer> start, Deque<Integer> end){
        //为了把右边stack 一半的元素导入到bufferStack， 和ipad 的图是一个过程
        if(!end.isEmpty()){
            return;
        }
        int half = start.size()/2;
        //先把后面一半导到bufferstack
        for (int i = 0; i < half;i++){
            sbuffer.offerFirst(start.pollFirst());
        }
        //再把剩下的 导到rstack
        while (!start.isEmpty())
        end.offerFirst(start.pollFirst());
        //再把bufferstack导入 sright
        while (!sbuffer.isEmpty()){
            start.offerFirst(sbuffer.pollFirst());
        }
    }

    public Integer pollLast() { //把左边的导入右边
        move(sleft,sright);
        return sright.isEmpty()?null:sright.pollFirst();
   }

    public Integer peekFirst() {//
        move(sright,sleft);
        return sleft.isEmpty()?null:sleft.peekFirst();
    }

    public Integer peekLast() {
        move(sleft,sright);
        return sright.isEmpty()?null:sright.peekFirst(); //注意这里是peekFirst 哦
    }

    public int size() {
        return sright.size() + sleft.size();
    }

    public boolean isEmpty() {
        return sright.isEmpty()&&sleft.isEmpty();
    }

    public static void main(String[] args) {
        DequeByThreeStacks sol = new DequeByThreeStacks();
//        System.out.println(sol.size());
//        System.out.println(sol.size());
//        sol.offerLast(277);
//        sol.offerFirst(32);
//        System.out.println(sol.isEmpty());
//        System.out.println(sol.pollFirst());
//        System.out.println(sol.isEmpty());
//        System.out.println(sol.peekFirst());
        //[0, 0, offerLast(227), offerFirst(32), false, 32, false, 227]


        System.out.println(sol.peekFirst());
        sol.offerLast(74);
        System.out.println(sol.peekFirst()); //74?
        sol.offerFirst(95);
        sol.offerLast(20);
        sol.offerFirst(143);
        System.out.println(sol.pollLast());
        System.out.println(sol.pollFirst());
        sol.offerFirst(9);
        // null, offerLast(74), 74, offerFirst(95), offerLast(20), offerFirst(143), 20, 143, offerFirst(9)]
    }
}
