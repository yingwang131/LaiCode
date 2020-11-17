package LinkedList;

import queueLinkedList.ListNode;

public class PartitionLL {
    public static ListNode partition(ListNode head, int target){
        ListNode smallDummy = new ListNode(80);
        ListNode largeDummy = new ListNode(90);

        ListNode s = smallDummy;
        ListNode l = largeDummy;
        ListNode cur = head;
        while (cur != null){
            if (cur.value < target){
                s.next = cur;
                s = s.next;
            }else{
                l.next = cur;
                l = l.next;
            }
            cur = cur.next;
        }
        s.next = largeDummy.next;
        l.next = null;
        return smallDummy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        partition(head,3);

        while (head != null){
            System.out.println(head.getValue() + " ");
            head = head.getNext();
        }
    }
}
