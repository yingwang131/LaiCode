package LinkedList;

import queueLinkedList.ListNode;

public class MergeTwoSortedLL {
    public static ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode a = one;
        ListNode b = two;
        ListNode c = dummy;
        while (a != null && b != null) {
            if (a.value > b.value) {
                c.next = b;
                b = b.next;

            } else {
                c.next = a;
                a = a.next;
            }
            c = c.next;
        }
        if (b != null) {
            c.next = b;
        } else {
            c.next = a;
        }

        return dummy.next;
    }

    public static ListNode merge1(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0); // dummy 是一个node 的名称
        ListNode cur = dummy; // cur 是这个dummy node 的指针，要遍历链表怎么能没有指针呢？
        while (one != null && two != null){
            if (one.value <= two.value){
                cur.next = one;
                one = one.next;
            }else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }

        if (one != null){
            cur.next = one;
        }else {
            cur.next = two;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode dummy = new ListNode(0);

        ListNode one = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(6);

        ListNode two = new ListNode(2);
        ListNode node3 = new ListNode(5);
        one.next = node1;
        node1.next = node2;

        two.next = node3;


        merge1(one, two);
        while (one != null) {
            System.out.println(one.getValue() + " ");
            one = one.getNext();
        }
    }
}
