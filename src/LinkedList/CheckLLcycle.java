package LinkedList;

import queueLinkedList.ListNode;

public class CheckLLcycle {
    public static boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);



        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(hasCycle(head));
    }
}
