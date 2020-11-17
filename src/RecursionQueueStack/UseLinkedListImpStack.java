package RecursionQueueStack;

import queueLinkedList.ListNode;

/*
用linkedList实现一个stack
1：stack是FILO，stack api 是poll，offer，peek
2：
 */
public class UseLinkedListImpStack {
    public static void main(String[] args) {
        Stack<Number> sol = new Stack<Number>();



        sol.push(7);
        sol.push(8);
        sol.push(9);
        System.out.println(sol.pop());
        System.out.println(sol.peek());
    }
}
    class Stack<D extends Number> {
       private ListNode head;
//        public Stack(){
//            head = null;
//        }
    // 用一个单链表，从头上叉，头上删
    public void push (int value) {

        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;

    }

    public Integer pop(){ // 移除堆栈顶部的对象
        if (head == null){
            return null;
        }
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        return prev.value; // prev.value 返回的是之前删除掉的那个指针对应的值，head.next 返回的是新节点的头，不是删除掉的元素
    }

    public Integer peek(){
        if (head == null){
            return null;
        }
        return head.value; //对于stack来说，是peek最顶端的元素的，在这里最顶端就是最后面的node，因为是头插法，
        // -->9-->8-->7 先插入7，再在7的头上插入8，再在8的头上插入9，所以最后head 指向的是9，9就是最顶端的元素，当peek时，当然是head.value了
        //   h    h    h

    }

    }


