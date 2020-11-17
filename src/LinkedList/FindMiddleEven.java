package LinkedList;

import queueLinkedList.ListNode;

public class FindMiddleEven {
    public static ListNode findMiddleEven(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(findMiddleEven(head).getValue());
    }
}
