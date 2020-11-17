package LinkedList;

import queueLinkedList.ListNode;

import java.util.List;

/*
Find the middle node of a given linked list with odd number length.



Assumption: the length > 0



Example:

L = 1 -> 2 -> 3 -> null, return 2->3
 */
public class FindMiddleNodeOdd {
    public static ListNode findMiddleNode(ListNode head){
        //base case
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);

        head.next = node1;
        node1.next = node2;

        System.out.println(findMiddleNode(head).getValue());
    }
}
