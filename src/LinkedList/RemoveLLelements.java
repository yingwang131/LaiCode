package LinkedList;

import queueLinkedList.ListNode;

import java.util.List;

/*
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLLelements {
    public static ListNode removeElements(ListNode head, int val){
        ListNode dummy = new ListNode(88);
        ListNode cur = dummy;
        while (head != null){
            if (head.value == val){
                cur.next = head.next;
            }else{
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        removeElements(head, 6);
        while (head != null){
            System.out.println(head.getValue() + " ");
            head = head.getNext();
        }
    }
}
