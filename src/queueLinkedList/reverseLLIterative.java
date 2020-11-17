package queueLinkedList;
/*
L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 */

public class reverseLLIterative {
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null){
            ListNode n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }
        return prev;
    }

    public static ListNode reverseRec(ListNode head){
        // base case
        if (head == null || head.next == null){
            return head;
        }
        //subproblem
        ListNode newHead = reverseRec(head.next);
        // recursion rule
       head.next.next = head;
       head.next = null;

       return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        head = reverseRec(head);
        while (head!= null){
            System.out.println(head.getValue()+ " ===");
            head = head.getNext();
        }

    }

}
