package RecursionQueueStack;

import queueLinkedList.ListNode;

/*
用linkedlist 实现一个 queue，需不需要 双端队列呢？ 不需要，因为我要是有一个 单链表，再给一个tail，
实现：尾插入， 头部删除
 */
public class UseLLImpQueue {
    public static void main(String[] args) {
        Queue sol = new Queue();
        sol.offer(8);
        System.out.println(sol.poll());
        System.out.println(sol.peek());
    }
}

class Queue{
    private ListNode head;
    private ListNode tail;

    //constructor
    public Queue(){
        head = tail = null;
    }
    public void offer(Integer value){
        // 尾部插入，一定记住 只有一个node或者node为null 的时候，tail 和head 在一个位置
        if (head == null) {
            head = new ListNode(value);
            tail = head;
        } else {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
    }

    public Integer poll(){
        // 头部删除
        if (head == null){
            return null;
        }
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        if (head == null){ // 当只有一个元素，我删除一个元素之后，head 和 tail还是要保持一致，都是null
            tail = null;
        }
        return prev.value;
    }
    public Integer peek(){
        if (head == null){
            return null;
        }
        return head.value;
    }
}
