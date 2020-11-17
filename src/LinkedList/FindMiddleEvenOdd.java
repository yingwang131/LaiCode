package LinkedList;

import queueLinkedList.ListNode;

public class FindMiddleEvenOdd {
    public static ListNode findMiddleOddEven(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 因为 fast.next == null or fast.next.next == null 就stop的否定条件就是 13 行
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(0);


        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(findMiddleOddEven(head).getValue());
    }
}
