package queueLinkedList;

/*
Example:

Given: 1->7->5->4->2->null



Answer: 5
 */
public class countNode {
    public int count(ListNode head){
        ListNode cur = head;
        int count = 0;

        while (cur != null){
            System.out.println(head.getValue()+ "+++++++++");
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public static void main(String[] args) {
        countNode sol = new countNode();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(sol.count(head));

    }
}
